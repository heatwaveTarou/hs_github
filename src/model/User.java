package model;

import java.io.Serializable;

public class User implements Serializable{

	private String account;
	private String pass;
	private String name;
	private String addre;
	private String mail;

	public User() {}
	public User(String account, String pass, String name, String addre, String mail) {
		this.account = account;
		this.pass = pass;
		this.name = name;
		this.addre = addre;
		this.mail = mail;
	}
	public String getAccount() {return account;}
	public String getPass() {return pass;}
	public String getName() {return name;}
	public String getAddre() {return addre;}
	public String getMail() {return mail;}
}
