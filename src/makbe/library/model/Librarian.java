package makbe.library.model;

import makbe.library.constants.Gender;

import java.util.Date;

public class Librarian {
	private String id;
	private String name;
	private String email;
	private Gender gender;
	private String password;
	private Date addedDate;

	public Librarian() {
	}

	public Librarian(String id, String name, String email, Gender gender, String password) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.gender = gender;
		this.password = password;
	}

	public Librarian(String id, String name, String email, Gender gender, String password, Date addedDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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
}
