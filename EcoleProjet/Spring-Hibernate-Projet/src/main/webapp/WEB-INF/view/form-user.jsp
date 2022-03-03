<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enregistrer Utilisateur</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-user-style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header"> 
		<h2>CRM - Utilisateur web manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3> Sauvegarder Utilisateur</h3>
	
		<form:form action="sauvegarderUser" modelAttribute="user" method="POST">
		
		   <form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>FirstName : </label></td>
						<td><form:input path="firstName"  /></td>
					</tr>
					
					<tr>
						<td><label>LastName : </label></td>
						<td><form:input path="lastName"  /></td>
					</tr>
					
					<tr>
						<td><label>Email : </label></td>
						<td><form:input path="email"  /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Enregistrer" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		<p><a href="${pageContext.request.contextPath}/users/list">Retour à la liste</a>

	</div>
</body>
</html>