<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Novo Personagem</title>
</head>
<body>
<h1>Criar Personagem</h1>
<form action="?params=insert" method="GET">
  <input type="hidden" name="params" value="insert">

  <div class="form-group">
    <label for="name">Nome</label>
    <input type="text" name="name" id="name">
  </div>
  <div class="form-group">
    <label for="lvl">Nível</label>
    <input type="number" name="lvl" id="lvl" min="1" max="20">
  </div>
  <div class="form-group">
    <label for="str">Força</label>
    <input type="number" name="str" id="str" min="8">
  </div>
  <div class="form-group">
    <label for="dex">Dextreza</label>
    <input type="number" name="dex" id="dex" min="8">
  </div>
  <div class="form-group">
    <label for="con">Constituição</label>
    <input type="number" name="con" id="con" min="8">
  </div>
  <div class="form-group">
    <label for="wis">Sabedoria</label>
    <input type="number" name="wis" id="wis" min="8">
  </div>
  <div class="form-group">
    <label for="cha">Carisma</label>
    <input type="number" name="cha" id="cha" min="8">
  </div>
  <div class="form-group">
    <label for="smt">Inteligência</label>
    <input type="number" name="smt" id="smt" min="8">
  </div>
  <div class="form-group">
    <label for="user_id">Usuário</label>
    <select name="user_id" id="user_id">
      <c:forEach items="${users}" var="user">
        <option value="${user.id}">${user.name}</option>
      </c:forEach>
    </select>
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
