<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Raças</title>

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
                <h1>Lista de Raças</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <nav>
                    <ul>
                        <li><a href="./index.jsp">Início<span></span></a></li>
                        <li><a href="./characters">Personagens<span></span></a></li>
                        <li><a href="races?params=create">Adicionar uma raça<span></span></a></li>
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
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="race" items="${races}">
                        <tr>
                            <td>${race.id}</td>
                            <td>${race.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
</body>
</html>
