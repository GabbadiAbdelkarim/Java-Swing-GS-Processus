package model.entities;

public class Admin {

	private int id_admin;
	private String nom;
	private String prenom;
	private int id_profile;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int id_admin, String nom, String prenom, int id_profile) {
		super();
		this.id_admin = id_admin;
		this.nom = nom;
		this.prenom = prenom;
		this.id_profile = id_profile;
	}
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getId_profile() {
		return id_profile;
	}
	public void setId_profile(int id_profile) {
		this.id_profile = id_profile;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_admin;
		result = prime * result + id_profile;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Admin other = (Admin) obj;
		if (id_admin != other.id_admin)
			return false;
		if (id_profile != other.id_profile)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + ", nom=" + nom + ", prenom=" + prenom + ", id_profile=" + id_profile
				+ "]";
	}
	
	
}

