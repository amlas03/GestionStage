<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.jee.beans.Stagiaire"%>
        <%@page import="com.jee.beans.Stage"%>
    
    <%@ page import="java.util.List" %>

<jsp:useBean id="StagiaireDB" class="com.jee.business.Facade" />

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="css/registration.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <form class="container" action="ajouter.do">
        <div class="background" id="background">
            <div class="content">
                <h1 class="title">Inscription à un stage</h1>
                <div class="input-container">
                <div class="labeled-text">
                        <label for=""codeStage"">Code</label>
                        <input name="codeStage" type="text" id="codeStage">
                    </div>
                    <div class="labeled-text">
                        <label for="stage">Stage</label>
                        <input name="stage" type="text" id="stage">
                    </div>
                    <div class="labeled-text">
                        <label for="debut">Du</label>
                        <input name="debut" type="text" id="debut" placeholder="yyyy-mm-dd">
                    </div>
                    <div class="labeled-text">
                        <label for="fin">Au</label>
                        <input name="fin" type="text" id="fin" placeholder="yyyy-mm-dd">
                    </div>
                </div>
            </div>
            <div class="buttons">
                <button class="roundedButton" id="nouvelleInscription" type="submit">Nouvelle inscription</button>
                
            </div>
            <button class="roundedButton" id="retour"><a href="index.jsp">Retour</a></button>
            <div class="inscrits-container">
                <h2>Liste des inscrits:</h2>
                <table id="dataTable">
                    <tr>
                        <th>Nom</th>
                        <th>Prenom</th>
                    </tr>
                    <% List<Stagiaire> stages=StagiaireDB.getAllStagiairesByPrenom();
                    for(int i=0; i<stages.size(); i++){
                    %>
                    <tr>
                        <td><%=stages.get(i).getNom() %></td>
                        <td><%=stages.get(i).getPrenom() %></td>
                        
                       
                    </tr>
                    <%
                    	}
                    %>
                </table>
            </div>
        </div>
    </form>
    
</body>
	<% Stage stg=(Stage)request.getAttribute("stage"); %>
    <script >
    	stage=document.getElementById("stage").value='<%= stg.getType() %>';
    	debut=document.getElementById("debut").value='<%= stg.getDateDeb() %>';
    	fin=document.getElementById("fin").value='<%= stg.getDateFin() %>';
    	codeStage=document.getElementById("codeStage").value='<%= stg.getCode() %>';
    </script>
</html>
