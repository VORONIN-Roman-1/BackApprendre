<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style> .error{color:red} </style></head>
<body>
<form:form action="processForm" modelAttribute="personnage">
    Prénom: <form:input path="prenom" />
    <br><br>
    Nom: <form:input path="nom" />
    <form:errors path="nom" cssClass="error"/>
    <br><br>
    points de vie : <form:input path="pointsDeVie"/>
    <form:errors path="pointsDeVie" cssClass="error" />
    <br><br>

    Code Postal : <form:input path="codePostal"/>
    <form:errors path="codePostal" cssClass="error" />
    <br><br>
    email : <form:input path="email"/>
    <form:errors path="email" cssClass="error" />
    <br><br>
    serial number : <form:input path="serialNumber"/>
    <form:errors path="serialNumber" cssClass="error" />
    <br><br>
    <input type="submit" value="Valider" />
</form:form>
</body>
</html>