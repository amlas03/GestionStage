package com.jee.beans;

import java.sql.Date;

public class Stage {
    private String code;
    private String type;
    private Date dateDeb;
    private Date dateFin;
    private int nbrePlaces;
    private int nbreInscrits;
    
    public Stage(){
    }
    public Stage(String code, String type, Date dateDeb,Date dateFin,int nbrePlaces){
        this.code=code;
        this.type=type;
        this.dateDeb=dateDeb;
        this.dateFin=dateFin;
        this.nbrePlaces=nbrePlaces;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrePlaces() {
        return nbrePlaces;
    }

    public void setNbrePlaces(int nbrePlaces) {
        this.nbrePlaces = nbrePlaces;
    }
    public void setNbreInscrits(int nbreInscrits){
        this.nbreInscrits=nbreInscrits;
    }
    public int getNbreInscrits(){
        return nbreInscrits;
    }
	@Override
	public String toString() {
		return "Stage [code=" + code + ", type=" + type + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin
				+ ", nbrePlaces=" + nbrePlaces + ", nbreInscrits=" + nbreInscrits + "]";
	}

    
}
