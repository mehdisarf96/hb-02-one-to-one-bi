package com.mehdisarf.hibernate.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

    private final static String URL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
    private final static String USERNAME = "hbstudent";
    private final static String PASS = "hbstudent";

    public static void main(String[] args) {
        try (

                Connection connection = DriverManager.getConnection(URL, USERNAME, PASS);
        ) {
            System.out.println("Successful Connecting. ");

        } catch (SQLException e) {
            System.out.println(e.getSQLState() + " " + e.getErrorCode());
        }
    }
}
