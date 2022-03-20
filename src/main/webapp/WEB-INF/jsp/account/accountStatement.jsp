<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <title>List transaction</title>
</head>
<body>
<div>
    <h1>Список транзакций:</h1>
            <form action="/account/info/accountStatement" method="get">
            Логин: ${login} <br>
            Номер счета: ${accountNumber} <br>
            Баланс: ${balance} ${currency}<br>
                <br>
    <c:forEach items="${transactionList}" var="item">
        <hr>
        Номер трензакции: ${item.terminalId} <br>
        Дата транзакции: ${item.dateTransaction} <br>
        Тип транзакции: ${item.operationType} <br>
        Сумма транзакции: ${item.sumTransaction} ${item.currencyType}<br>
        <hr>
    </c:forEach>
            </form>
    <br>
    <br>
    <form action="/account/info" method="get">
        <input class="button24" type="submit" value="Назад">
    </form>
</div>
</body>
</html>