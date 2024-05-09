package com.jee.business;

import java.sql.SQLException; 
import java.util.List;

import com.jee.beans.Inscription;
import com.jee.beans.Stage;
import com.jee.beans.Stagiaire;
import com.jee.dao.DataSource;
import com.jee.dao.InscriptionDB;
import com.jee.dao.MySQLDataSource;

import com.jee.dao.StageDB;
import com.jee.dao.StagiaireDB;

public class Facade {

	private StageDB stage;
	private StagiaireDB stagiaire;
	private InscriptionDB inscription;
	
	public Facade() {
		stage=new StageDB(new MySQLDataSource("gestag"));
		stagiaire=new StagiaireDB(new MySQLDataSource("gestag"));
		inscription=new InscriptionDB(new MySQLDataSource("gestag"));
	}
	
	
	public List<Stage> getAllStages() throws SQLException{
		return stage.getAllStages();
	}
	
	public List<Stage> listerParDate() throws SQLException{
		return stage.listerParDate();
	}
	
	public List<Stage> listerParType() throws SQLException{
		return stage.ListerParType();
	}
	
	public Stage fromCode(String code){
		return stage.fromCode(code);
	}
	
	public List<Stagiaire> getAllStagiairesByPrenom() throws SQLException{
		return stagiaire.getAllStagiairesByPrenom();
	}
	
	public int creerStagiaire(Stagiaire s) throws SQLException{
        return stagiaire.creerStagiaire(s);
    }
	
	public List<Stagiaire> listerStagiaire(String code) throws SQLException{
        return inscription.listerStagiaire(code);
    }
    public Stage listerStage(String code) throws SQLException{
        return inscription.listerStage(code);
    }
    public int creerInscription(Inscription inscriptionObj) throws SQLException{
        return inscription.creerInscription(inscriptionObj);
    }
    public List<String> getAllStatusesByStage(String code) throws SQLException{
        return inscription.getAllStatusesByStage(code);
    }
}
