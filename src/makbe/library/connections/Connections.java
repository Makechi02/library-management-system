package makbe.library.connections;

import java.sql.*;

public class Connections {

    public Connection connection;
    public Statement statement;

    public Connections() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library?useSSL=false" + "&serverTimezone=UTC","vee","vi");
            statement = connection.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean confirmPassword(String user, String password) {
        String query =
                "SELECT * FROM login " +
                        "WHERE username = '" + user + "' AND password = '" + password + "' ";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePassword(String user, String oldPassword, String newPassword) {
        if (confirmPassword(user, oldPassword)) {
            int result;
            String query2 =
                    "UPDATE login " +
                    "SET password = '" + newPassword + "' " +
                    "WHERE username = '" + user + "' ";
            try {
                result = statement.executeUpdate(query2);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return result == 1;
        } else {
            return false;
        }
    }

}