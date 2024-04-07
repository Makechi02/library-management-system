package makbe.library.connections;

import java.sql.*;

public class ConnectionsII {
	public Connection connection;
	public Statement statement;

	public ConnectionsII() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system?useSSL=false" +
					"&serverTimezone=UTC", "makbe", "makbe02");
			statement = connection.createStatement();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
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

	public boolean confirmPassword(String user, String password) {
		String query = "SELECT * FROM login WHERE username = '" + user + "' AND password = '" + password + "' ";
		try {
			ResultSet resultSet = statement.executeQuery(query);
			return resultSet.next();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean authenticateAdmin(String username, String password) {
		String query = "SELECT * FROM librarians WHERE username = ? AND password = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}