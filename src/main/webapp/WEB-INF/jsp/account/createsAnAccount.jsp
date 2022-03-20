<%--Author Sergey Vasiliev--%>
<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>User panel</title>
</head>
<body>
<div class="postform">
    <h1>Открытие счета</h1>

    <form action="/account/info/createAnAccount" method="get"">
        Логин клиента: ${userLogin}<br>
        Номер счета: ${accountNumber}<br>
    </form>

    <form action="/account/info/createAnAccount" method="post">
        Выберите тип счета:<br>
        (1 = CARD)<br>
        <input name="accountType"><br><br>
        Выберите валюту счета:<br>
        ( 1 = RUB)<br>
        <input name="currency"><br><br>
        <input class="ulink" type="submit"><br>
    </form>
<br>
<br>
<form>
    <input class="button24" name="userLogin" formaction="/clientinfo/${userLogin}" formmethod="get" type="submit" value="Информация о клиенте">
</form>
</div>
</body>
</html>