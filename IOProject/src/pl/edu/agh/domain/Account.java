package pl.edu.agh.domain;

import java.io.Serializable;

import pl.edu.agh.domain.databasemanagement.DatabaseProperties;

@SuppressWarnings("serial")
public class Account implements Serializable {
	
	private long id = DatabaseProperties.UNSAVED_ENTITY_ID;
	private String login;
	private String password;
	private String email;
	
	public Account() {
		super();
	}

	public Account(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", password="
				+ password + ", email=" + email + "]";
	}
	
	
}
