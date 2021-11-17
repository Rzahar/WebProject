package models;

public class User {
	private String UID;
	private String pseudo;
	private String mail;
	private String status;

	public User (String UID, String pseudo, String mail, String status) {
		this.UID = UID;
		this.pseudo = pseudo;
		this.mail = mail;
		this.status = status;
	}
	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
