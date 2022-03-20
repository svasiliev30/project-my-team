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
    <h1 class="utitle">Информация о клиенте</h1>
    <form class="formusers">
        Логин: ${client.userLogin}<br>
        Имя: ${client.firstName}<br>
        Отчество: ${client.middleName}<br>
        Фамилия: ${client.lastName}<br>
        Дата рождения: ${client.birthday}<br>
        Номер паспорта: ${client.passport}<br>
        Организация выдавшая паспорт: ${client.passportOrg}<br>
        Дата выдачи: ${client.passportDate}<br>
        E-mail: ${client.email}<br>
        Номер телефона: ${client.phone}<br>
        <br>
        <table border="1" width="1500" class="usertable">
            <caption>Открытые счета и карты:</caption>
            <tr bgcolor="Gainsboro">
                <td class="zag">Номер счета</td>
                <td class="zag">Валюта счета</td>
                <td class="zag">Тип счета</td>
                <td class="zag">Номер карты</td>
                <td class="zag">Платежная система</td>
                <td class="zag">Баланс</td>
                <td class="zag"></td>
            </tr>
            <c:forEach items="${accounts}" var="acc">
                <tr>
                    <td>${acc.key.numberAccount}</td>
                    <td>${acc.key.currency}</td>
                    <td>${acc.key.accountType}</td>
                    <td>${acc.value.cardNumber}</td>
                    <td>${acc.value.paymentSystem}</td>
                    <td>${acc.key.balance}</td>
                    <td><input class="ulink" name="accountNumber" formaction="/account/info/${acc.key.numberAccount}" formmethod="get" type="submit" value="Информация по счету"></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <td><input class="button25" name="userLogin" formaction="/account/add/${client.userLogin}" formmethod="get" type="submit" value="Открыть новый счет"></td>
        <br><br>
        <a href="/showall" class="button24">К списку клиентов</a> <a href="/logout" class="button24">Выход</a>
    </form>
</body>
</html>