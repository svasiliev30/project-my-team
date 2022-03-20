<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
  <title>Delete by login</title>
</head>
<style>
    input[type=text]{
       width:200px;
       height: 30px;
    }
</style>
<body>
<div class="delete">
  <form method="POST" action="">
    <h2>Удаление пользователя по Логину</h2>
    <div class="delclass">
      <input name="login" type="text" placeholder="Userlogin" autofocus="true"/>
      <button class="ulink" type="submit">Удалить</button>
    </div>
  </form>
  <br>
    <a href="/afterlogin" class="button24">Операционное меню</a> <a href="/logout" class="button24">Выход</a>
</div>
</body>
</html>