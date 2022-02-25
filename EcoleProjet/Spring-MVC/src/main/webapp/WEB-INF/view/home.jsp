<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/mon-css.css">
    <script src="${pageContext.request.contextPath}/resources/js/un-script.js">
    </script>
</head>
<body>
Welcome to the spring body index home page !

une resource static ici :
<img src="${pageContext.request.contextPath}/resources/images/spring.png">
<hr>un bouton sur lequel j'ai un script js dans les resources statiques
<input type="button" onclick="jsMethodeName()" value="js test button"/>
<div> un paragraphe mis en forme avec mon-css.css</div>
</body>
</html>
</html>