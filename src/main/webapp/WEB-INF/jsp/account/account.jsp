<%--Author Sergey Vasiliev--%>
<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
	<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
	<title>User panel</title>
</head>
<body>
<div class="postform2">
	<h1>Информация о счете</h1>
	<form action="/account/info" method="get">
			Логин клиента: ${login}<br>
			Номер счета: ${accountNumber} <br>
			Номер карты: ${card}<br>
			Дата открытия счета: ${dateOpen} <br>
			Действующий: ${activityStatus}<br>
			Баланс: ${balance} ${currency}<br>
	</form>
	<br>
	<form action="/account/info" method="post">
		Поиск по номеру счета (введите номер счета):<br>
		<input name="numberAccount"><br>
		<input class="ulink" type="submit" value="Искать"><br>
	</form>
	<br>
    <table>
        <tr>
            <td>
                <form action= "/account/info/createAnAccount" method="get" >
                    <input class="ulink" type="submit" value="Создать новый счет">
                </form>
            </td>
            <td>
                <form action="/account/info/updateDeposit" method="get" >
                    <input class="ulink" type="submit" value="Внести деньги">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="/card/info" method="get">
                    <input class="ulink" name="accountNumber" formaction="/card/add/${accountNumber}" formmethod="get" type="submit" value="Открыть карту"></td>
                </form>
            </td>
            <td>
                <form action="/account/info/withdrawCash" method="get">
                    <input class="ulink" type="submit" value="Снять деньги">
                </form>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form action="/account/info/accountStatement" method="get">
                    <button class="ulink">Выписка</button>
                </form>
            </td>
        </tr>
    </table>
	<br>
	<form>
		<input class="button24" name="userLogin" formaction="/clientinfo/${login}" formmethod="get" type="submit" value="Информация о клиенте">
	</form>
	<br>
	<a href="/showall" class="button24">К списку клиентов</a>
</div>
</body>
</html>