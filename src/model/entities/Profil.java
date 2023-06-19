package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Profil {

	private int id_profile;
	private String login, mot_de_passe;
	private int idEmploye;
	private Role role;
	
	public Profil() {	}

	public Profil(int id_profile, String login, String mot_de_passe, int idEmploye, Role role) {
		super();
		this.id_profile = id_profile;
		this.login = login;
		this.mot_de_passe = mot_de_passe;
		this.idEmploye = idEmploye;
		this.role = role;
	}

	public int getId_profile() {
		return id_profile;
	}

	public void setId_profile(int id_profile) {
		this.id_profile = id_profile;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmploye;
		result = prime * result + id_profile;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mot_de_passe == null) ? 0 : mot_de_passe.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Profil other = (Profil) obj;
		if (idEmploye != other.idEmploye)
			return false;
		if (id_profile != other.id_profile)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mot_de_passe == null) {
			if (other.mot_de_passe != null)
				return false;
		} else if (!mot_de_passe.equals(other.mot_de_passe))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profil [id_profile=" + id_profile + ", login=" + login + ", mot_de_passe=" + mot_de_passe
				+ ", idEmploye=" + idEmploye + ", role=" + role + "]";
	}

	
	
	
}
