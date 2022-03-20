<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Create card page</title>
</head>
<body>
    <div class="postform">
        <div class="header">
            <form>
                Логин: ${account.userLogin} <br>
                Номер счета: ${account.numberAccount} <br>
            </form>
        </div>
        <div>
            <form action="/card/add" method="post" th:object="${card}">
                <div>
                    Введите имя для надписи на карте: <input type="text"name="holderName" value="${card.cardHolderName}"/>
                </div>
                <div class="form-group">
                    Выберите тип платежной системы:<br>
                    (1 = VISA | 2 = MC | 3 = МИР)<br>
                    <input name="cardType"><br>
                </div>
                <br>
                <button class="button24" class="btn btn-primary" type="submit">Отправить</button>
            </form>
        </div>
    </div>
</body>
</html>