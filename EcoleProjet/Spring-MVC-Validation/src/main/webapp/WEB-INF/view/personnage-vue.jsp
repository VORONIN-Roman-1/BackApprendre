<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>personnage valide - vue</title>
</head>
<body>
Le personnage soumis est valide : ${personnage.nom}${personnage.prenom}
<br><br>
Points de vie valide : ${personnage.pointsDeVie}
<br><br>
email valide : ${personnage.email}
<br><br>
serialNumber valide : ${personnage.serialNumber}
</body>
</html>