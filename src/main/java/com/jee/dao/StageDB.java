package com.jee.dao;
	
import com.jee.beans.Stage;
import com.jee.dao.DataBase;
import com.jee.dao.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

	public class StageDB extends DataBase {
		
		public StageDB() {
			
		}
	    public StageDB(DataSource ds) {
	        setDs(ds);
	    }
	    // Method to retrieve all stages from the database
	    public List<Stage> getAllStages() throws SQLException {
	    	try {
				String req="select * from stage;";
				Statement stm=cnx.createStatement();
				
				ResultSet rs=stm.executeQuery(req);
				
				List<Stage> stages=new ArrayList<Stage>();
				
				while(rs.next()) {
					 Stage stage = new Stage();
		                stage.setCode(rs.getString("CODE_STAGE"));
		                stage.setType(rs.getString("TYPE_STAGE"));
		                stage.setDateDeb(rs.getDate("DEBUT_STAGE"));
		                stage.setDateFin(rs.getDate("FIN_STAGE"));
		                stage.setNbrePlaces(rs.getInt("NBPLACE_STAGE"));
		                stage.setNbreInscrits(rs.getInt("NBINSCRIT_STAGE"));
		                stages.add(stage);
					
				}
				return stages;
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
		}
		}

	    public List<Stage> listerParDate() throws SQLException {
	        List<Stage> ls = new ArrayList<>();
	        try {
	            // Retrieve all stages from the database
	            ls = getAllStages();

	            // Sort the list by date
	            Collections.sort(ls, Comparator.comparing(Stage::getDateDeb));
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle SQL errors
	        }
	        return ls;
	    }
	    public List<Stage> ListerParType() throws SQLException {
	    List<Stage> ls = new ArrayList<>();
	    try {
	        // Retrieve all stages from the database
	        ls = getAllStages();

	        // Sort the list by type
	        Collections.sort(ls, Comparator.comparing(Stage::getType));
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle errors
	    }
	    return ls;
	    }
	    
	    public Stage fromCode(String code) {
	    	Stage stage = null;
	    	try {
	            String query = "SELECT * FROM stage where code_stage='"+code+"';";
	            Statement statement = cnx.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);

	            // Iterate through the result set and create Stage objects
	            while (resultSet.next()) {
	                stage = new Stage();
	                stage.setCode(resultSet.getString("CODE_STAGE"));
	                stage.setType(resultSet.getString("TYPE_STAGE"));
	                stage.setDateDeb(resultSet.getDate("DEBUT_STAGE"));
	                stage.setDateFin(resultSet.getDate("FIN_STAGE"));
	                stage.setNbrePlaces(resultSet.getInt("NBPLACE_STAGE"));
	                stage.setNbreInscrits(resultSet.getInt("NBINSCRIT_STAGE"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle SQL errors
	        } 
	        return stage;
	    }
	    
	}

