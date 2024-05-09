package com.jee.beans;

import java.sql.Date;

public class Stagiaire {
    private String id;
    private String nom;
    private String prenom;
    private String diplome;
    private String sexe;
    private static String femme ="F";
    private static String homme="H";
    private Date dateNaissance;
    public Stagiaire(){
        
    }

    public Stagiaire(String id, String nom, String prenom, String diplome, String sexe, Date dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.diplome = diplome;
        if(sexe==femme|| sexe==homme){
            this.sexe=sexe;
        }
        else{
            this.sexe=homme;
        }
        this.dateNaissance = dateNaissance;
    }
    
    public Stagiaire(String nom, String prenom, String diplome, String sexe, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.diplome = diplome;
        if(sexe==femme|| sexe==homme){
            this.sexe=sexe;
        }
        else{
            this.sexe=homme;
        }
        this.dateNaissance = dateNaissance;
    }
    
    public Stagiaire(String nom, String prenom, String diplome, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.diplome = diplome;
        if(sexe==femme|| sexe==homme){
            this.sexe=sexe;
        }
        else{
            this.sexe=homme;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        if(sexe == femme|| sexe==homme){
            this.sexe=sexe;
        }
        else{
            this.sexe=homme;
        }
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", diplome=" + diplome + ", sexe=" + sexe
				+ ", dateNaissance=" + dateNaissance + "]";
	} 
    
    
}

