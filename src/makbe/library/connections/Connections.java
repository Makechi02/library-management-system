package makbe.library.connections;

import makbe.library.model.Librarian;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Connections {
	private static final String PROPERTIES_FILE = "database.properties";

	private static Connections instance;

	private Connections() {

	}

	public static synchronized Connections getInstance() {
		if (instance == null) {
			instance = new Connections();
		}
		return instance;

	}

	private Connection getConnection() {
		Connection connection;
		try {
			Properties properties = getDatabaseProperties();

			String database = properties.getProperty("db.name");
			String url = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false &serverTimezone=UTC";
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			throw new RuntimeException(e);
		}

		return connection;
	}

	private Properties getDatabaseProperties() throws IOException {
		Properties properties = new Properties();
		try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE)) {
			properties.load(fileInputStream);
		}
		return properties;
	}

	private boolean authenticateUser(String id, String password, String query) {
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean authenticateStudent(String regNo, String password) {
		String query = "SELECT * FROM students WHERE reg_no = ? AND password = ?";
		return authenticateUser(regNo, password, query);
	}

	public boolean authenticateLibrarian(String id, String password) {
		String query = "SELECT * FROM librarians WHERE id = ? AND password = ?";
		return authenticateUser(id, password, query);
	}

	public boolean authenticateAdmin(String username, String password) {
		String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
		return authenticateUser(username, password, query);
	}

	public int saveLibrarian(Librarian librarian) {
		String query = "INSERT INTO librarians (id, name, email, password) VALUES (?, ?, ?, ?)";
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, librarian.getId());
			statement.setString(2, librarian.getName());
			statement.setString(3, librarian.getEmail());
			statement.setString(4, librarian.getPassword());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Librarian getLibrarianById(String id) {
		Librarian librarian = new Librarian();
		String query = "SELECT * FROM librarians WHERE id = ?";
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				librarian.setId(resultSet.getString("id"));
				librarian.setName(resultSet.getString("name"));
				librarian.setEmail(resultSet.getString("email"));
				librarian.setPassword(resultSet.getString("password"));
				librarian.setAddedDate(resultSet.getDate("added_date"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return librarian;
	}

	public int updateAdminPassword(String username, String newPassword) {
		String query = "UPDATE admin SET password = ? WHERE username = ?";
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newPassword);
			statement.setString(2, username);

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
