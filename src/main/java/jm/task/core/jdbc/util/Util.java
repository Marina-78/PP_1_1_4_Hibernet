package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    private static String url = "jdbc:mysql://localhost/mydb?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "root";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory () {
        if (sessionFactory == null) {
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.url", url);
            properties.setProperty("hibernate.connection.username", username);
            properties.setProperty("hibernate.connection.password", password);
            properties.setProperty("hibernate.show_sql", "true");
            properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

            sessionFactory = new Configuration()
                    .addPackage("jm.task.core.jdbc.model")
                    .addProperties(properties)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();

        } return sessionFactory;
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
