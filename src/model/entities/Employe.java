package model.entities;

import java.util.Date;

public class Employe {

	private int Id_Employe;
	private String Nom, Prénom,Cin,Adresse,Email,Telephone;
	private Date Date_Recrutement, Date_Naissance;
	private Sexe sexe;
	
	
	public Employe() {
		super();
	}


	public Employe(int id_Employe, String nom, String prénom, String cin, String adresse, String email,
			String telephone, Date date_Recrutement, Date date_Naissance, Sexe sexe) {
		super();
		Id_Employe = id_Employe;
		Nom = nom;
		Prénom = prénom;
		Cin = cin;
		Adresse = adresse;
		Email = email;
		Telephone = telephone;
		Date_Recrutement = date_Recrutement;
		Date_Naissance = date_Naissance;
		this.sexe = sexe;
	}
	public Employe(int id_Employe, String nom, String prénom) {
		super();
		Id_Employe = id_Employe;
		Nom = nom;
		Prénom = prénom;
	}

	public int getId_Employe() {
		return Id_Employe;
	}


	public void setId_Employe(int id_Employe) {
		Id_Employe = id_Employe;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getPrénom() {
		return Prénom;
	}


	public void setPrénom(String prénom) {
		Prénom = prénom;
	}


	public String getCin() {
		return Cin;
	}


	public void setCin(String cin) {
		Cin = cin;
	}


	public String getAdresse() {
		return Adresse;
	}


	public void setAdresse(String adresse) {
		Adresse = adresse;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getTelephone() {
		return Telephone;
	}


	public void setTelephone(String telephone) {
		Telephone = telephone;
	}


	public Date getDate_Recrutement() {
		return Date_Recrutement;
	}


	public void setDate_Recrutement(Date date_Recrutement) {
		Date_Recrutement = date_Recrutement;
	}


	public Date getDate_Naissance() {
		return Date_Naissance;
	}


	public void setDate_Naissance(Date date_Naissance) {
		Date_Naissance = date_Naissance;
	}


	public Sexe getSexe() {
		return sexe;
	}


	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Adresse == null) ? 0 : Adresse.hashCode());
		result = prime * result + ((Cin == null) ? 0 : Cin.hashCode());
		result = prime * result + ((Date_Naissance == null) ? 0 : Date_Naissance.hashCode());
		result = prime * result + ((Date_Recrutement == null) ? 0 : Date_Recrutement.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + Id_Employe;
		result = prime * result + ((Nom == null) ? 0 : Nom.hashCode());
		result = prime * result + ((Prénom == null) ? 0 : Prénom.hashCode());
		result = prime * result + ((Telephone == null) ? 0 : Telephone.hashCode());
		result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
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
		Employe other = (Employe) obj;
		if (Adresse == null) {
			if (other.Adresse != null)
				return false;
		} else if (!Adresse.equals(other.Adresse))
			return false;
		if (Cin == null) {
			if (other.Cin != null)
				return false;
		} else if (!Cin.equals(other.Cin))
			return false;
		if (Date_Naissance == null) {
			if (other.Date_Naissance != null)
				return false;
		} else if (!Date_Naissance.equals(other.Date_Naissance))
			return false;
		if (Date_Recrutement == null) {
			if (other.Date_Recrutement != null)
				return false;
		} else if (!Date_Recrutement.equals(other.Date_Recrutement))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Id_Employe != other.Id_Employe)
			return false;
		if (Nom == null) {
			if (other.Nom != null)
				return false;
		} else if (!Nom.equals(other.Nom))
			return false;
		if (Prénom == null) {
			if (other.Prénom != null)
				return false;
		} else if (!Prénom.equals(other.Prénom))
			return false;
		if (Telephone == null) {
			if (other.Telephone != null)
				return false;
		} else if (!Telephone.equals(other.Telephone))
			return false;
		if (sexe != other.sexe)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return Id_Employe + " " + Nom + " " + Prénom + "-" + Cin
				+ ", Adresse=" + Adresse + ", Email=" + Email + ", Telephone=" + Telephone + ", Date_Recrutement="
				+ Date_Recrutement + ", Date_Naissance=" + Date_Naissance + ", sexe=" + sexe + "]";
	}

	
	
}
