<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nova Raça</title>
</head>
<body>
<h1>Criar nova raça</h1>
<form action="?params=insert" method="GET">
    <input type="hidden" name="params" value="insert">

    <div class="form-group">
        <label for="name">Nome</label>
        <input type="text" name="name" id="name">
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
