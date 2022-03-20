<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Manager Menu</title>
</head>
<body>
<div class = "box">
    <form action="" method="POST" NAME="registerForm">
                <div class="field">
                    <p>Операционное меню</p>
                </div>
               <div class="field_signup">
                    <a href="/showall" class="button2">Все клиенты</a>
               </div>
               <div class="field_signup">
                    <a href="/add" class="button2">Регистрация клиента</a>
               </div>
                <div class="field_signup">
                      <a href="/delete" class="button2">Удаление клиента</a>
                </div>
                <div class="field_signup">
                    <a href="/clients/main" class="button2">Поиск и изменение данных о клиенте</a>
                </div>
                <br>
                <div class="field_signup">
                     <a href="/logout" class="button24">Выход</a>
                </div>
    </form>
</body>
</html>
