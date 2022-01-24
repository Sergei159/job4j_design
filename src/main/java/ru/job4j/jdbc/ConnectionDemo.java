package ru.job4j.jdbc;

import ru.job4j.io.Config;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс подключается к БД
 */
public class ConnectionDemo {


     public static Connection getConnection(String path) throws Exception {
        Config config = new Config(path);
        config.load();
        Class.forName(config.value("driver"));
        String url = config.value("url");
        String login = config.value("login");
        String password = config.value("password");
        return DriverManager.getConnection(url, login, password);

    }

    public static void main(String[] args) throws Exception {
         /**
        try (Connection connection = getConnection("app.properties")) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());

        }*/
    }
}