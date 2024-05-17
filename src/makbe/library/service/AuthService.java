package makbe.library.service;

import makbe.library.connections.Connections;

public class AuthService {
	private final Connections connections = Connections.getInstance();

	public boolean authenticateAdmin(String username, String password) {
		return connections.authenticateAdmin(username, password);
	}

	public boolean authenticateLibrarian(String librarianId, String password) {
		return connections.authenticateLibrarian(librarianId, password);
	}

	public boolean authenticateStudent(String regNo, String password) {
		return connections.authenticateStudent(regNo, password);
	}

	public boolean updateAdminPassword(String username, String newPassword) {
		int results = connections.updateAdminPassword(username, newPassword);
		return results >= 1;
	}

	public boolean updateLibrarianPassword(String librarianId, String newPassword) {
		int results = connections.updateLibrarianPassword(librarianId, newPassword);
		return results >= 1;
	}

	public boolean updateStudentPassword(String regNo, String newPassword) {
		int results = connections.updateStudentPassword(regNo, newPassword);
		return results >= 1;
	}
}
