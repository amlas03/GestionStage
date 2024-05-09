
package com.jee.dao;

import com.jee.beans.Stagiaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StagiaireDB extends DataBase{
    public StagiaireDB(DataSource ds) {
        // You may initialize your data source here if necessary
        super(ds);
    }
    public int creerStagiaire(Stagiaire s) throws SQLException{
        try{
            String req = "Insert into stagiaire (nom_stagiaire,prenom_stagiaire,sexe_stagiaire,diplo_stagiaire) values(?,?,?,?)";
            Connection cnx = this.getConnection();
            
            PreparedStatement statement = cnx.prepareStatement(req);
            
            statement.setString(1,s.getNom());
            statement.setString(2,s.getPrenom());
            statement.setString(3,s.getSexe());
            statement.setString(4, s.getDiplome());
            
            int rowsAffected = statement.executeUpdate();
            return rowsAffected;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    public List<Stagiaire> getAllStagiairesByPrenom() throws SQLException {
    List<Stagiaire> ls = new ArrayList<>();
    try {
        Connection connection = this.getConnection();
        String req = "SELECT num_stagiaire,prenom_stagiaire, nom_stagiaire FROM Stagiaire";
        PreparedStatement statement = connection.prepareStatement(req);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            Stagiaire stagiaire = new Stagiaire();
            stagiaire.setId(resultSet.getString("num_stagiaire"));
            stagiaire.setPrenom(resultSet.getString("prenom_stagiaire"));
            stagiaire.setNom(resultSet.getString("nom_stagiaire"));
            ls.add(stagiaire);
        }
        
        
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle SQL errors
    }
    return ls;
}

}
