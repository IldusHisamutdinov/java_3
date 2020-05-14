package Lesson_2.NetworkServer.src.ru.geekbrains.java2.server;


import Lesson_2.NetworkServer.src.ru.geekbrains.java2.server.networkserver.auth.AuthService;

import java.sql.*;


public class ServerApp {

    private static final int PORT = 8189;
    private static Connection connection;
    private static Statement stmt;
    public static void main(String[] args) {
        AuthService.MyServer server = new AuthService.MyServer(8189);
        try {
            connect();

            stmt.executeUpdate("INSERT INTO uses (name) VALUES ('Server is running')");
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM uses");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("created_at"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        server.start();
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC"); //инициализация драйвера
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }
}
