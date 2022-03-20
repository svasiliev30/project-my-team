<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
</head>
<body>
    <form class="formusers">
        <h1>Список клиентов на дату: ${todaydata}</h1>
        <table border="1" width="1500" class="usertable"> <!-- Задаём границу в 1 пиксель и ширину в 300 пикселей -->
           <tr bgcolor="Gainsboro">  <!-- Задаём цвет ячеек для всей первой строки -->
                            <td class="zag">Логин</td>
                            <td class="zag">Имя</td>
                            <td class="zag">Отчество<br>
                            <td class="zag">Фамилия</td>
                            <td class="zag">День рождения</td>
                            <td class="zag">Номер паспорта</td>
                            <td class="zag">Организация</td>
                            <td class="zag">Дата выдачи</td>
                            <td class="zag">E-mail</td>
                            <td class="zag">Телефон</td>
           </tr>
           <c:forEach items="${userList}" var="user">
           <tr>
                       <td>${user.userLogin}</td>
                       <td>${user.firstName}</td>
                       <td>${user.middleName}<br>
                       <td>${user.lastName}</td>
                       <td>${user.birthday}</td>
                       <td>${user.passport}</td>
                       <td>${user.passportOrg}</td>
                       <td>${user.passportDate}</td>
                       <td>${user.email}</td>
                       <td>${user.phone}</td>
                       <td><input class="ulink" name="userLogin" formaction="/clientinfo/${user.userLogin}" formmethod="get" type="submit" value="Счета клиента"></td>
           </tr>
           </c:forEach>

        </table>
            <br>
            <a href="/afterlogin" class="button24">Операционное меню</a> <a href="/logout" class="button24">Выход</a>
    </form>
</body>
</html>
