package com.jee.beans;

import java.sql.Date;

public class Inscription {
    private String codeStage;
    private int idStagiaire;
    private Date dateInsc;
    private String statut;
    
    
    public Inscription(){
        
    }

    public Inscription(String codeStage, int idStagiaire, Date dateInsc, String statut) {
        this.codeStage = codeStage;
        this.idStagiaire = idStagiaire;
        this.dateInsc = dateInsc;
        this.statut = statut;
    }

    public String getCodeStage() {
        return codeStage;
    }

    public void setCodeStage(String codeStage) {
        this.codeStage = codeStage;
    }

    public int getIdStagiaire() {
        return idStagiaire;
    }

    public void setIdStagiaire(int idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

    public Date getDateInsc() {
        return dateInsc;
    }

    public void setDateInsc(Date dateInsc) {
        this.dateInsc = dateInsc;
    }

    public String getStatut() {
        return statut;
    }
    

    public void setStatut(String statut) {
        this.statut = statut;
    }

    
    @Override
    public String toString() {
        return "Inscription{" + "codeStage=" + codeStage + ", idStagiaire=" + idStagiaire + ", dateInsc=" + dateInsc + ", statut=" + statut + '}';
    }
    
}
