package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private String path;


    public TableEditor(String path) throws Exception {
        this.path = path;
        initConnection();
    }

    private void initConnection() throws Exception {
        connection = ConnectionDemo.getConnection(path);
    }

    private void sqlExecution(String sql, String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            if (!sql.contains("drop table")) {
                System.out.println(getTableScheme(connection, tableName));
            }
        }
    }

    public void createTable(String tableName) throws Exception {
            String sql = String.format(
                    "Create table if not exists %s ();",
                    tableName);
            sqlExecution(sql, tableName);
    }


    public void dropTable(String tableName) throws Exception {
            String sql = String.format(
                    "drop table %s;",
                    tableName);
            sqlExecution(sql, tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
            String sql = String.format(
                    "alter table %s add %s %s;",
                    tableName, columnName, type);
            sqlExecution(sql, tableName);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
            String sql = String.format(
                    "alter table %s drop column %s ;",
                    tableName, columnName);
        sqlExecution(sql, tableName);

    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
            String sql = String.format(
                    "alter table %s rename column %s to %s;",
                    tableName, columnName, newColumnName);
        sqlExecution(sql, tableName);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    " select * from %s  where exists (select %s) limit 1", tableName, tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }

        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor tableEditor = new TableEditor("app.properties");
        tableEditor.createTable("users");
        tableEditor.dropTable("users");
        tableEditor.createTable("users");
        tableEditor.addColumn("users", "name", "varchar(255)");
        tableEditor.dropColumn("users", "name");
        tableEditor.addColumn("users", "name", "varchar(255)");
        tableEditor.renameColumn("users", "name", "new_Name");
        tableEditor.close();


    }
}