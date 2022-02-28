<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mon-css.css">--%>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<%--    <script src="${pageContext.request.contextPath}/resources/js/un-script.js"></script>--%>

</head>
<body>
<p>Hi</p>

<a href="personnages/afficheForm">Formulaire Personnage</a>


<br> <br>

<button type="button" class="btn btn-primary"> Premier bouton stylisé avec bootstrap</button>

<button type="button" class="btn btn-secondary"> Premier bouton stylisé avec bootstrap</button>



<!--  Bootstrap Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 		crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" 		crossorigin="anonymous"></script>

<button
        type="button" id="btn-popover" class="btn btn-warning"
        data-toggle="popover" title="The button popover"
        data-content="The content for popover comes here. Provide useful tip/information here?">
    Button Popover (Toggle)
</button>
<div class="alert alert-primary" role="alert">
    A simple primary alert—check it out!
</div>
<div class="alert alert-success" role="alert">
    A simple success alert with
    <a href="#" class="alert-link">an example link</a>
    Give it a click if you like.
</div>
<button type="button" class="btn btn-primary">Primary</button>
<button type="button" class="btn btn-secondary">Secondary</button>

<script>
$(document).ready(function(){
$('#btn-popover').popover();
});
</script>
</body>
</html>