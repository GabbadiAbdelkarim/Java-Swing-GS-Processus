package model.entities;

import java.util.Date;

public class Message {

	private int id_message;
	private Date date_envoie;
	private String text;
	private int id_employe_Emet	;
	private int id_employe_desti;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int id_message, Date date_envoie, String text, int id_employe_Emet, int id_employe_desti) {
		super();
		this.id_message = id_message;
		this.date_envoie = date_envoie;
		this.text = text;
		this.id_employe_Emet = id_employe_Emet;
		this.id_employe_desti = id_employe_desti;
	}
	public int getId_message() {
		return id_message;
	}
	public void setId_message(int id_message) {
		this.id_message = id_message;
	}
	public Date getDate_envoie() {
		return date_envoie;
	}
	public void setDate_envoie(Date date_envoie) {
		this.date_envoie = date_envoie;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId_employe_Emet() {
		return id_employe_Emet;
	}
	public void setId_employe_Emet(int id_employe_Emet) {
		this.id_employe_Emet = id_employe_Emet;
	}
	public int getId_employe_desti() {
		return id_employe_desti;
	}
	public void setId_employe_desti(int id_employe_desti) {
		this.id_employe_desti = id_employe_desti;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_envoie == null) ? 0 : date_envoie.hashCode());
		result = prime * result + id_employe_Emet;
		result = prime * result + id_employe_desti;
		result = prime * result + id_message;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (date_envoie == null) {
			if (other.date_envoie != null)
				return false;
		} else if (!date_envoie.equals(other.date_envoie))
			return false;
		if (id_employe_Emet != other.id_employe_Emet)
			return false;
		if (id_employe_desti != other.id_employe_desti)
			return false;
		if (id_message != other.id_message)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Message [id_message=" + id_message + ", date_envoie=" + date_envoie + ", text=" + text
				+ ", id_employe_Emet=" + id_employe_Emet + ", id_employe_desti=" + id_employe_desti + "]";
	}
	
	
}
