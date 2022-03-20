<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ru">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bank financial processing system</title>
</head>
<body>
	<div class="postform2">
		<div id="header" class="cf">
			<h2>${message}</h2>
		</div>
		<div id="main" class="cf">
			<div id="content-2">
                <table>
                    <tr>
                        <td>
                            <div id="content-2-1">
                                <div class="form-group">
                                    <p>
                                        <c:forEach items="${clientsList1}" var="clients">
                                            Логин: ${clients.userLogin} <br>
                                            Имя: ${clients.firstName} <br>
                                            Отчество: ${clients.middleName} <br>
                                            Фамилия: ${clients.lastName} <br>
                                            День рождения: ${clients.birthday} <br>
                                            Номер паспорта: ${clients.passport} <br>
                                            Организация: ${clients.passportOrg} <br>
                                            Дата выдачи: ${clients.passportDate} <br>
                                            E-mail: ${clients.email} <br>
                                            Телефон: ${clients.phone} <br>
                                            <hr>
                                        </c:forEach>
                                    </p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div id="content-2-2">
                                <p>
                                    <c:forEach items="${clientsList2}" var="clients">
                                        Логин: ${clients.userLogin} <br>
                                        Имя: ${clients.firstName} <br>
                                        Отчество: ${clients.middleName} <br>
                                        Фамилия: ${clients.lastName} <br>
                                        День рождения: ${clients.birthday} <br>
                                        Номер паспорта: ${clients.passport} <br>
                                        Организация: ${clients.passportOrg} <br>
                                        Дата выдачи: ${clients.passportDate} <br>
                                        E-mail: ${clients.email} <br>
                                        Телефон: ${clients.phone} <br>
                                        <hr>
                                    </c:forEach>
                                </p>
                                <p><form class="form-horizontal"></form></p>
                            </div>
                        </td>
                    </tr>
                </table>
			</div>
		</div>
		<div id="footer" class="cf">
            <form action="../clients/main" method="GET" >
                <button class="button24" name="find" class="btn btn-default" value="all">
                    К поиску клиентов
                </button>
            </form>
            <br>
            <a href="/afterlogin" class="button24">Операционное меню</a> <a href="/logout" class="button24">Выход</a>
		</div>
	</div>
</body></html>