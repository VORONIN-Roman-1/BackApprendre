<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="processForm" modelAttribute="utilisateur" >
    Prenom: <form:input  path="prenom"/>
    Nom: <form:input  path="nom"/>
    Pays:
    <form:select path="pays">
        <form:options items="${laListeDesPays}"/>

    </form:select>
    OS favori:<br>
    <form:radiobuttons path="osPrefere" items="${osOptions}" />

    compétences:
    Programmation <form:checkbox path="competences" value="programation" />
    Conception <form:checkbox path="competences" value="conception" />
    Test<form:checkbox path="competences" value="test"/>
    DBA<form:checkbox path="competences" value="dba"/>
    <input type="submit" value="valider"/>
</form:form>