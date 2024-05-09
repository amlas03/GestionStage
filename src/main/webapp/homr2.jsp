 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jee.beans.Stage" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jee.dao.StageDB" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/registration.css">
</head>
<body>
    <form class="container" action="lister.do">
        <div class="background" id="background">
            <div class="content">
                <h1 class="title">Inscription à un stage</h1>
                <table id="dataTable">
                    <tr>
                        <th>code</th>
                        <th>Type</th>
                        <th>Debut</th>
                        <th>Fin</th>
                        <th>Places</th>
                        <th>Inscrits</th>
                    </tr>
                    <% List<Stage> stages=(List<Stage>)request.getAttribute("stages2");
                    
                    for(int i=0; i<stages.size(); i++){
                    %>
                    <tr>
                        <td><%=stages.get(i).getCode()%></td>
                        <td><%=stages.get(i).getType() %></td>
                        <td><%=stages.get(i).getDateDeb() %></td>
                        <td><%=stages.get(i).getDateFin() %></td>
                        <td><%=stages.get(i).getNbrePlaces() %></td>
                        <td><%=stages.get(i).getNbreInscrits() %></td>
                    </tr>
                    <%
                    	}
                    %>
                </table>
            </div>
            <div class="buttons">
                <button class="roundedButton" id="listerDate" type="submit" name="action" value="parDate">Par date</button>
                <button class="roundedButton" id="listerType" type="submit" name="action" value="parType">Par type</button>
                <button class="roundedButton" type="submit" name="action" value="code">S'inscrire</button>
                
            </div>
            <input type="text" placeholder="Entrez le code du stage" name="codeStage">
        </div>
        
    </form>
    <script src="script.js"></script>
</body>
</html>