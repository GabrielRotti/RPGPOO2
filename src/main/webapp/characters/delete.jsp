<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Apagar Personagem</title>

    <style>
        <%@include file="/WEB-INF/css/bootstrap-grid.min.css" %>
    </style>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
</head>
<body>
<section id="page-header">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1>Apagar Personagem</h1>
                <p>Você tem certeza que realmente deseja apagar <strong>${character.characterName}</strong>?</p>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <nav>
                    <ul>
                        <li><a href="./index.jsp">Início<span></span></a></li>
                        <li><a href="./races">Raças<span></span></a></li>
                        <li><a href="./characters">Personagens<span></span></a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</section>
<section id="character-erase">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form action="?params=erase" method="GET">
                    <input type="hidden" name="params" value="erase">
                    <input type="hidden" name="character_id" value="${character.id}">
                    <div class="form-group">
                        <input type="submit" value="Apagar">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
