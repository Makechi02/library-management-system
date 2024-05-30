package makbe.library.connections;

import makbe.library.constants.Gender;
import makbe.library.model.Admin;
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
		try {
			Properties properties = getDatabaseProperties();

			String database = properties.getProperty("db.name");
			String url = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false &serverTimezone=UTC";
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");

			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			throw new RuntimeException(e);
		}
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

	//	ADMIN

	public boolean authenticateAdmin(String username, String password) {
		String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
		return authenticateUser(username, password, query);
	}

	public int saveAdmin(Admin admin) {
		String query = "INSERT INTO admin (id, username, password) VALUES (?, ?, ?)";
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, admin.id());
			statement.setString(2, admin.username());
			statement.setString(3, admin.password());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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


	//	LIBRARIAN

	public boolean authenticateLibrarian(String id, String password) {
		String query = "SELECT * FROM librarians WHERE id = ? AND password = ?";
		return authenticateUser(id, password, query);
	}

	public int saveLibrarian(Librarian librarian) {
		String query = "INSERT INTO librarians (id, name, email, gender, password) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, librarian.getId());
			statement.setString(2, librarian.getName());
			statement.setString(3, librarian.getEmail());
			statement.setString(4, librarian.getGender().name());
			statement.setString(5, librarian.getPassword());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Librarian getLibrarianById(String id) {
		Librarian librarian = null;
		String query = "SELECT * FROM librarians WHERE id = ?";
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				librarian = new Librarian(
						resultSet.getString("id"),
						resultSet.getString("name"),
						resultSet.getString("email"),
						Gender.valueOf(resultSet.getString("gender")),
						resultSet.getString("password"),
						resultSet.getDate("added_date")
				);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return librarian;
	}

	public int updateLibrarianPassword(String id, String newPassword) {
		String query = "UPDATE librarians SET password = ? WHERE id = ?";
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newPassword);
			statement.setString(2, id);

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//	STUDENT

	public boolean authenticateStudent(String regNo, String password) {
		String query = "SELECT * FROM students WHERE reg_no = ? AND password = ?";
		return authenticateUser(regNo, password, query);
	}

	public int updateStudentPassword(String regNo, String newPassword) {
		String query = "UPDATE students SET password = ? WHERE reg_no = ?";
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newPassword);
			statement.setString(2, regNo);

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
