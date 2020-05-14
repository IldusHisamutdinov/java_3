package Lesson_2;

// 1. Сделать методы для работы с БД (CREATE, UPDATE, DELETE, INSERT, SELECT)

import java.sql.*;

public class lesson2 {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC"); //инициализация драйвера
        connection = DriverManager.getConnection("jdbc:sqlite:maine.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            connect();
            ResultSet rs = stmt.executeQuery("SELECT id, name, score FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
            }

            stmt.executeUpdate("INSERT INTO users (name, score) VALUES ('Bob4', 40)");
            stmt.executeUpdate("UPDATE users SET score = score + 1");

  /*
            int res = stmt.executeUpdate(String.format("CREATE TABLE users (\n" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "score TEXT)"));

  */

            //           stmt.executeUpdate("DELETE FROM users");
//           stmt.executeUpdate("DROP TABLE IF EXISTS users");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }
}

