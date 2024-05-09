<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.jee.beans.Stagiaire" %>
<%@ page import="com.jee.beans.Stage" %>

<jsp:useBean id="StageDB" class="com.jee.business.Facade" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inscription a un Stage</title>
<link rel="stylesheet" href="css/inscription.css"/>
</head>
<body>
  <div class="container">
    <h2 style="text-align: center;">Inscription a un Stage</h2>
    <form action="inscription.do" method="get">
      <div class="form-group">
        <label for="codeStage">Code:</label>
        <input type="text" id="codeStage" name="codeStage">
        <label for="stage">Stage:</label>
        <input type="text" id="stage" name="stage">
        <label for="du">Du:</label>
        <input type="text" id="du" name="du">
        <label for="au">Au:</label>
        <input type="text" id="au" name="au">
      </div>
      <div class="form-group">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom">
        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom">
      </div>
      <div class="form-group">
        <label for="stagiaire">Selection Stagiaire:</label>
        <select id="stagiaire" name="stagiaire">
          <%
            List<Stagiaire> stagiaires = (List<Stagiaire>) request.getAttribute("stagiaires");
            for (Stagiaire stagiaire : stagiaires) {
          %>
          <option value="<%= stagiaire.getId() %>"><%= stagiaire.getNom() %></option>
          <%
            }
          %>
        </select>
      </div>
      <div class="form-group">
        <label for="statut">Statut:</label>
        <select id="statut" name="statut">
          <%
            List<String> statuses = (List<String>) request.getAttribute("statuses");
            for (String status : statuses) {
          %>
          <option value="<%= status %>"><%= status %></option>
          <%
            }
          %>
        </select>
      </div>
      <div style="text-align: center;">
        <button type="submit" id="creerInscription" class="btn">Validation</button>
        <button class="btn"><a href="stagiaire.html">Nouveau Stagiaire</a></button>
        <button class="btn"><a href="registration.jsp" target="target">Retour Stage</a></button>
      </div>
    </form>
  </div>
</body>
        <% Stage stg=(Stage)request.getAttribute("stage"); %>
    <script >
    	stage=document.getElementById("stage").value='<%= stg.getType() %>';
    	debut=document.getElementById("du").value='<%= stg.getDateDeb() %>';
    	fin=document.getElementById("au").value='<%= stg.getDateFin() %>';
    	codeStage=document.getElementById("codeStage").value='<%= stg.getCode() %>';
    </script>
</html>
