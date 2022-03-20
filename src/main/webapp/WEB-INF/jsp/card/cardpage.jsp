<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Card info</title>
</head>
<body>
    <div class="postform2">
        <h1>Информация по карте</h1>
        <form>
            Логин: ${account.userLogin}<br>
            Номер счета: ${account.numberAccount} <br>
            Номер карты: ${card.cardNumber} <br>
            Платежная система: ${card.paymentSystem}<br>
            Дата открытия карты: ${card.expirationDate} <br>
            Имя на карте: ${card.cardHolderName} <br>
            Статус карты: ${card.cardStatus} <br>
            Баланс: ${account.balance} ${account.currency} <br>
            <br>
            <input class="button24" name="userLogin" formaction="/clientinfo/${account.userLogin}" formmethod="get" type="submit" value="Информация о клиенте">
        </form>
    </div>
</body>
</html>