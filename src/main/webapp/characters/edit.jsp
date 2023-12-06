<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar personagem</title>

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
                <h1>Editar ${character.characterName}</h1>
                <p>Consulte o livro de regras para editar seu personagem.</p>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <nav>
                    <ul>
                        <li><a href="./index.jsp">Início<span></span></a></li>
                        <li><a href="./characters">Personagens<span></span></a></li>
                        <li><a href="./races">Raças<span></span></a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form class="row" action="?params=update" method="GET">
                    <input type="hidden" name="params" value="update">
                    <input type="hidden" name="character_id" value="${character.id}">

                    <div class="col-12 stats-data">
                        <div class="row">
                            <div class="col-12 col-lg-6">
                                <div class="form-group">
                                    <label for="name">Nome</label>
                                    <input type="text" name="name" id="name" value="${character.characterName}" required>
                                </div>
                            </div>
                            <div class="col-12 col-lg-6">
                                <div class="form-group">
                                    <label for="race_id">Raça</label><br>
                                    <select name="race_id" id="race_id" required>
                                        <c:forEach items="${races}" var="race">
                                            <c:if test="${character.raceId == race.id}">
                                                <option value="${race.id}" selected>${race.name}</option>
                                            </c:if>
                                            <c:if test="${character.raceId != race.id}">
                                                <option value="${race.id}">${race.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 col-lg-6">
                                <div class="form-group">
                                    <label for="lvl">Nível</label>
                                    <input type="number" name="lvl" id="lvl" min="1" max="20" value="${character.lvl}" required>
                                </div>
                            </div>
                            <div class="col-12 col-lg-6">
                                <div class="form-group">
                                    <label for="user_id">Usuário</label><br>
                                    <select name="user_id" id="user_id" required>
                                        <c:forEach items="${users}" var="user">
                                            <option value="${user.id}">${user.name}</option>
                                            <c:if test="${character.userId == user.id}">
                                                <option value="${user.id}" selected>${user.name}</option>
                                            </c:if>
                                            <c:if test="${character.userId != race.id}">
                                                <option value="${user.id}">${user.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group">
                                    <label for="title">Título</label>
                                    <input type="text" name="title" id="title" value="${character.title}" placeholder="Deixe em branco para preencher com um título aleatório." required>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <hr>
                    </div>
                    <div class="col-12 attribute-list">
                        <div class="row">
                            <div class="col-12 col-lg-4">
                                <div class="form-group">
                                    <label for="str">Força</label>
                                    <input type="number" name="str" id="str" min="1" value="${character.str}" required>
                                </div>
                            </div>
                            <div class="col-12 col-lg-4">
                                <div class="form-group">
                                    <label for="dex">Dextreza</label>
                                    <input type="number" name="dex" id="dex" min="1" value="${character.dex}" required>
                                </div>
                            </div>
                            <div class="col-12 col-lg-4">
                                <div class="form-group">
                                    <label for="con">Constituição</label>
                                    <input type="number" name="con" id="con" min="1" value="${character.con}" required>
                                </div>
                            </div>
                            <div class="col-12 col-lg-4">
                                <div class="form-group">
                                    <label for="wis">Sabedoria</label>
                                    <input type="number" name="wis" id="wis" min="1" value="${character.wis}" required>
                                </div>
                            </div>
                            <div class="col-12 col-lg-4">
                                <div class="form-group">
                                    <label for="cha">Carisma</label>
                                    <input type="number" name="cha" id="cha" min="1" value="${character.cha}" required>
                                </div>
                            </div>
                            <div class="col-12 col-lg-4">
                                <div class="form-group">
                                    <label for="smt">Inteligência</label>
                                    <input type="number" name="smt" id="smt" min="1" value="${character.smt}" required>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-12">
                        <input type="submit" value="Atualizar">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
