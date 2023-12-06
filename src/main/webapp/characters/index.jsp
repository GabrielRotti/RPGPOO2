<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personagens</title>
</head>
<body>
<h1>Lista de Personagens</h1>
<div class="character-list">
    <c:forEach var="character" items="${characters}">
        <div class="character-box">
            <div class="character-title">
                <h2>${character.characterName}</h2>
                <h6>The Orc</h6>
            </div>
            <figure>
                <img src="https://avatarfiles.alphacoders.com/120/120828.jpg" alt="Orc" width="80" height="80">
            </figure>
            <div class="character-stats">
                <div class="character-stat">
                    <div class="character-stat-label">Nível:</div>
                    <div class="character-stat-value">${character.lvl}</div>
                </div>
            </div>
            <div class="character-attributes">
                <div class="character-attribute">
                    <div class="character-attribute-label">Força:</div>
                    <div class="character-attribute-value">${character.str}</div>
                </div>
                <div class="character-attribute">
                    <div class="character-attribute-label">Destreza:</div>
                    <div class="character-attribute-value">${character.dex}</div>
                </div>
                <div class="character-attribute">
                    <div class="character-attribute-label">Constituição:</div>
                    <div class="character-attribute-value">${character.con}</div>
                </div>
                <div class="character-attribute">
                    <div class="character-attribute-label">Carisma:</div>
                    <div class="character-attribute-value">${character.cha}</div>
                </div>
                <div class="character-attribute">
                    <div class="character-attribute-label">Sabedoria:</div>
                    <div class="character-attribute-value">${character.wis}</div>
                </div>
                <div class="character-attribute">
                    <div class="character-attribute-label">Inteligência:</div>
                    <div class="character-attribute-value">${character.smt}</div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<br><br>
<nav>
    <ul>
        <li><a href="./characters?params=create">Criar personagem</a></li>
        <li><a href="./index.jsp">Início</a></li>
    </ul>
</nav>
</body>
</html>
