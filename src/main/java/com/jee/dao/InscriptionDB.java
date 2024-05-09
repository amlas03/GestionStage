package com.jee.dao;

import com.jee.beans.Inscription;
import com.jee.beans.Stage;
import com.jee.beans.Stagiaire;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class InscriptionDB extends DataBase{
    public InscriptionDB(DataSource ds){
        super(ds);
    }
    public List<Stagiaire> listerStagiaire(String code) throws SQLException {
    List<Stagiaire> ls = new ArrayList<>();
    try {
        Connection connection = this.getConnection();
        String req = "SELECT s.nom_stagiaire, s.prenom_stagiaire FROM stagiaire s JOIN inscription i ON i.num_stagiaire = s.num_stagiaire where i.code_stage="+code;
        PreparedStatement statement = connection.prepareStatement(req);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            Stagiaire s = new Stagiaire();
            s.setNom(resultSet.getString("nom_stagiaire"));
            s.setPrenom(resultSet.getString("prenom_stagiaire"));
            ls.add(s);
        }
    } catch (SQLException e) {
        // Handle SQL errors
        e.printStackTrace();
    }
    return ls;
}
    public Stage listerStage(String code) throws SQLException {
    Stage s = new Stage();
    try {
        Connection connection = this.getConnection();
        String req = "SELECT s.type_stage, s.debut_stage, s.fin_stage FROM stage s JOIN inscription i ON i.code_stage = s.code_stage WHERE i.code_stage = ?";
        PreparedStatement statement = connection.prepareStatement(req);
        statement.setString(1, code); // Set the code parameter
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            s.setType(resultSet.getString("type_stage"));
            s.setDateDeb(resultSet.getDate("debut_stage"));
            s.setDateFin(resultSet.getDate("fin_stage"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return s;
}
    public int creerInscription(Inscription inscription) throws SQLException {
    	
        try {
           
            String req = "INSERT INTO INSCRIPTION (CODE_STAGE, NUM_STAGIAIRE, DATE_INSCRIP, STATUT_INSCRIP) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = cnx.prepareStatement(req);

            
            
            // Paramétrer les valeurs pour la requête
            statement.setString(1, inscription.getCodeStage());
            statement.setInt(2, inscription.getIdStagiaire());
            statement.setDate(3, inscription.getDateInsc());
            statement.setString(4, inscription.getStatut());

            // Exécuter la requête
            int rowsAffected = statement.executeUpdate();

            // Fermer les ressources
            

            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    
    private boolean isDateInStageRange(Connection cnx, String codeStage, Date dateInsc) throws SQLException {
        String query = "SELECT DEBUT_STAGE, FIN_STAGE FROM STAGE WHERE CODE_STAGE = ?";
        PreparedStatement statement = cnx.prepareStatement(query);
        statement.setString(1, codeStage);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Date debutStage = resultSet.getDate("DEBUT_STAGE");
            Date finStage = resultSet.getDate("FIN_STAGE");
            statement.close();
            // Vérifier si la date d'inscription est comprise entre la date de début et la date de fin du stage
            return dateInsc.after(debutStage) && dateInsc.before(finStage);
        } else {
            // Si aucun stage n'est trouvé pour le code_stage donné, renvoyer false
            return false;
        }
    }
    
    public List<String> getAllStatusesByStage(String code) {
        List<String> statuses = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT statut_inscrip FROM inscription WHERE code_stage = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, code);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String status = resultSet.getString("statut_inscrip");
                statuses.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return statuses;
}
}
