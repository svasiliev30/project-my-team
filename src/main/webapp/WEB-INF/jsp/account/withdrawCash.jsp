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
<div class="postform">
	<h1>Информация о счете</h1>

	Введите сумму для снятия.

	<form action="/account/info/withdrawCash" method="get">
			Баланс:${newBalance} ${currency}
		${errorBalance}
	</form>
	<form action="/account/info/withdrawCash" method="post">
		Ввод суммы:<br>
		<input name="money"><br>
		<input class="ulink" type="submit"><br>
	</form>
	<br>
	<br>
	<form action="/account/info" method="get">
		<input class="button24" type="submit" value="Назад">
	</form>
	<div class="postform">
</body>
</html>