package com.jee.dao;

import java.sql.SQLException;

import com.jee.beans.Stagiaire;
import com.jee.business.Facade;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		Facade c=new Facade();
		
		System.out.println(c.creerStagiaire(new Stagiaire("alaoui","nada","DATA","F")));
	}
}
