<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<p>Os dados de senha estão sendo mostrados por razões de estudo. O correto seria criptografar as senhas.</p>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="users" items="${users}">
        <tr>
            <td>${users.id}</td>
            <td>${users.name}</td>
            <td>${users.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>
<nav>
    <ul>
        <li><a href="./users?params=create">Adicionar um usuário</a></li>
        <li><a href="./index.jsp">Início</a></li>
    </ul>
</nav>
</body>
</html>
