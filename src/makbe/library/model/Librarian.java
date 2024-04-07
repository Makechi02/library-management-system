package makbe.library.model;

import java.util.Date;
import java.util.Objects;

public class Librarian {
	private String id;
	private String name;
	private String email;
	private String password;
	private Date addedDate;

	public Librarian() {
	}

	public Librarian(String id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Librarian(String id, String name, String email, String password, Date addedDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.addedDate = addedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Librarian librarian = (Librarian) o;
		return Objects.equals(id, librarian.id) && Objects.equals(name, librarian.name) && Objects.equals(email, librarian.email) && Objects.equals(password, librarian.password) && Objects.equals(addedDate, librarian.addedDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, email, password, addedDate);
	}

	@Override
	public String toString() {
		return "Librarian {" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", addedDate=" + addedDate +
				'}';
	}
}
