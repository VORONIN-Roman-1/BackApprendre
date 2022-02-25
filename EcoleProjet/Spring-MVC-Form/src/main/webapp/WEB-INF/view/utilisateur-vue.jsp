<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Utilisateur - Vue</title>
</head>
<body>L'utilisateur est verifié <br/>
nom:${utilisateur.prenom} <br/>
prenom: ${utilisateur.nom} <br/>
        pays: ${utilisateur.pays}
<br>
OS: ${utilisateur.osPrefere}
<br>

compétences :
<ul>
    <c:forEach var="temp" items="${utilisateur.competences}">
        <li>${temp}</li>
    </c:forEach>
</ul>
        </body>
        </html>