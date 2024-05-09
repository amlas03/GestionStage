package com.jee.web;
import java.io.IOException; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.beans.Inscription;
import com.jee.beans.Stage;
import com.jee.beans.Stagiaire;
import com.jee.business.Facade;
import com.jee.dao.DataSource;
import com.jee.dao.MySQLDataSource;
import com.jee.dao.StageDB;

public class StageServlet extends HttpServlet{
	private Facade facade;
	
	@Override
	public void init() throws ServletException {
		facade=new Facade();
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String codeStage=req.getParameter("codeStage");
		Stage verification=facade.fromCode(codeStage);
		String uri=req.getRequestURI();
		
		if(uri.contains("ajouter")) {
			 List<Stagiaire> stagiaires=new ArrayList<Stagiaire>();
			try {
				stagiaires = facade.getAllStagiairesByPrenom();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             List<String> statuses=new ArrayList<String>();
			try {
				statuses = facade.getAllStatusesByStage(codeStage);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(verification);
             req.setAttribute("stage", verification);
             req.setAttribute("stagiaires", stagiaires);
             req.setAttribute("statuses", statuses);
             req.getRequestDispatcher("Inscription2.jsp").forward(req, resp); 
			
	        }
		else if(uri.contains("lister")) {
			String action=req.getParameter("action");
			
			switch (action) {
			case "parDate":
				List<Stage> ls=new ArrayList<Stage>();
				try {
					ls=facade.listerParDate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(ls);
				req.setAttribute("stages", ls);
				req.getRequestDispatcher("home.jsp").forward(req, resp);
				break;
				
		case "parType":
			List<Stage> ls2=new ArrayList<Stage>();
			try {
				ls2=facade.listerParType();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("stages2", ls2);
			req.getRequestDispatcher("homr2.jsp").forward(req, resp);
			break;
		
		case "code":
				System.out.println(verification);
				if(verification!=null) {
					req.setAttribute("stage", verification);
					req.getRequestDispatcher("registration.jsp").forward(req, resp);
				}
				else
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				break;
			}
		}
			else if(uri.contains("inscription")){                    
                    try {
                    // Extracting form data
                    String stagiaireId = req.getParameter("stagiaire");
                    String statut = req.getParameter("statut");

                    System.out.println(stagiaireId);
                    System.out.println(statut);
                    // Creating Inscription object
                    Inscription inscription = new Inscription();
                    inscription.setCodeStage(codeStage);
                    inscription.setDateInsc(verification.getDateDeb());
                    inscription.setIdStagiaire(Integer.parseInt(stagiaireId));
                    inscription.setStatut(statut);

                    // Saving inscription
                    facade.creerInscription(inscription);

                    // Redirecting to a success page
                    resp.sendRedirect("success.html");
                } catch (Exception e) {
                    e.printStackTrace();
                    resp.sendRedirect("failure.html");
                }
                }
            else if(uri.contains("stagiaire")){
                String action1 = req.getParameter("action");
                if (action1.equals("inserer")){
                    String nom = req.getParameter("nom");
                    String prenom = req.getParameter("prenom");
                    String diplome = req.getParameter("diplome");
                    String sexe = req.getParameter("sexe");

                    // Create Stagiaire object
                    Stagiaire stagiaire = new Stagiaire();
                    stagiaire.setNom(nom);
                    stagiaire.setPrenom(prenom);
                    stagiaire.setDiplome(diplome);
                    stagiaire.setSexe(sexe);

                    // Call facade method to create Stagiaire
                    try {
                        Facade facade = new Facade();
                        facade.creerStagiaire(stagiaire);
                        resp.sendRedirect("success1.html");
                    } catch (Exception e) {
                        e.printStackTrace();
                        resp.sendRedirect("failure1.html");
                    }
                }
            }
			}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}