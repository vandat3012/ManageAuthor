package com.example.manageauthor.config;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
private static Connection connection;

private Connection() {
    }
public static  Connection getConnection() {
if (connection == null) {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_post",
                "root",
                "123456");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
return connection;
}
}
