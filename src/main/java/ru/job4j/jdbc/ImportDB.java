package ru.job4j.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Класс получает информацию о пользователях из файла формата .txt ,а затем заводит
 * данные в БД
 */

public class ImportDB {

    private Properties cfg;

    /**
     * Имя файла, откуда читаются данные
     */
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * метод читает из файла формата .txt данные об имени и email
     * пользователей и добавляет их в список users
     * @return возвращает список users с данными, прочитанными из файла dump
     */
    public List<User> load() {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .filter(s ->  s.length() > 0)
                    .forEach(str -> {
                        String[] pair = str.split(";");
                        if (pair.length != 2
                                && (pair[0].isEmpty() || pair[1].isEmpty())) {
                            throw new IllegalArgumentException("wrong initial data format");
                        }
                        users.add(new User(pair[0], pair[1]));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * метод загружает в БД поля из списка users
     * @param users список пользователей
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement(
                        "insert into users (name, email) values (?, ?);")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./dump.txt");
        db.save(db.load());
    }

}