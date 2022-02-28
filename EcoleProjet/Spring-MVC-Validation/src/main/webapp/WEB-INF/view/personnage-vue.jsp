<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>personnage valide - vue</title>
</head>
<body>
Le personnage soumis est valide : ${personnage.nom} ${personnage.prenom}
<br><br>
Points de vie : ${personnage.pointsDeVie}
<br><br>
Code Postal valide: ${personnage.codePostal}
</body>
</html>