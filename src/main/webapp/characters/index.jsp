<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personagens</title>

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
                <h1>Lista de Personagens</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <nav>
                    <ul>
                        <li><a href="./index.jsp">Início<span></span></a></li>
                        <li><a href="./races">Raças<span></span></a></li>
                        <li><a href="./characters?params=create">Criar personagem<span></span></a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</section>
<section id="characters-section">
    <div class="container">
        <div class="row character-list">
            <c:forEach var="character" items="${characters}">
                <div class="col-12 col-md-6 col-xl-4">
                    <div class="character-box">
                        <figure>
                            <img src="https://avatarfiles.alphacoders.com/120/120828.jpg"
                                 alt="${character.characterName}" width="80" height="80">
                        </figure>
                        <div class="character-title">
                            <h2>${character.characterName}</h2>
                            <h6>${character.title}</h6>
                        </div>
                        <div class="character-stats">
                            <div class="character-stat">
                                <div class="character-stat-label">Nível:</div>
                                <div class="character-stat-value">${character.lvl}</div>
                            </div>
                                <%--                            <div class="character-stat">--%>
                                <%--                                <div class="character-stat-label">Raça:</div>--%>
                                <%--                                <div class="character-stat-value">${character.race_id}</div>--%>
                                <%--                            </div>--%>
                        </div>
                        <hr class="divisor">
                        <div class="character-attributes">
                            <div class="character-attribute">
                                <div class="character-attribute-label">Força</div>
                                <div class="character-attribute-value">${character.str}</div>
                            </div>
                            <div class="character-attribute">
                                <div class="character-attribute-label">Destreza</div>
                                <div class="character-attribute-value">${character.dex}</div>
                            </div>
                            <div class="character-attribute">
                                <div class="character-attribute-label">Constituição</div>
                                <div class="character-attribute-value">${character.con}</div>
                            </div>
                            <div class="character-attribute">
                                <div class="character-attribute-label">Carisma</div>
                                <div class="character-attribute-value">${character.cha}</div>
                            </div>
                            <div class="character-attribute">
                                <div class="character-attribute-label">Sabedoria</div>
                                <div class="character-attribute-value">${character.wis}</div>
                            </div>
                            <div class="character-attribute">
                                <div class="character-attribute-label">Inteligência</div>
                                <div class="character-attribute-value">${character.smt}</div>
                            </div>
                        </div>
                        <hr>
                        <div class="character-actions">
                            <a href="./characters?params=edit&character_id=${character.id}">Editar</a>
                            <a href="./characters?params=delete&character_id=${character.id}">Deletar</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<br><br>
</body>
</html>
