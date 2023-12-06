<%--
  Created by IntelliJ IDEA.
  User: rafae
  Date: 12/5/2023
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Criar Usuário</h1>
<form action="?params=insert" method="GET">
    <input type="hidden" name="params" value="insert">

    <div class="form-group">
        <label for="name">Nome</label>
        <input type="text" name="name" id="name">
    </div>
    <div class="form-group">
        <label for="password">Senha</label>
        <input type="password" name="password" id="password">
    </div>
    <div class="form-group">
        <input type="submit" value="cadastrar">
    </div>
</form>
<ul>
    <li>
        <a href="?params=find-all">Voltar</a>
    </li>
</ul>
</body>
</html>
