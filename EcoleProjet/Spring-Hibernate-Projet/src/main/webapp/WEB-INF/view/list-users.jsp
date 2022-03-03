<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des users</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - gestionnaire d'Utilisateur</h2>
		</div>
	</div>
	
	<input type="button" value="Ajout User"
	onclick="window.location.href='montrerFormulaireCreate'; return false;" class="add-button"/>
	
	<div id="container">
		<div id="content">
		<!-- ajouter le tableau html ici -->
			<table>
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
		
				<c:forEach var="temp" items="${users}">
			  		<c:url var="deleteLien" value="/users/deleteById">
						<c:param name="id" value="${temp.id}"/>
					</c:url> 
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
				 			
				<td> <a href="${pageContext.request.contextPath}/users/montrerFormulaireEdition?id=${temp.id}">Update</a>
				     <td>
				      <a href="${deleteLien}"
				     onclick="if(!(confirm('Souhaitez-vous réellement supprimer cet Utilisateur ?'))) return false">
				     
				      Delete</a> 
				     </td>	
				</tr>
				</c:forEach>
		
			</table>
		</div>
	</div>
</body>
</html>