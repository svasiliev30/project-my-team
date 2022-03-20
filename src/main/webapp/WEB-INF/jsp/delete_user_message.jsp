<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Error Add Info</title>
</head>
<body>
    <div class="delete">
        <h2>Удаление клиента: клиент с логином ${userlogin} ${message}</h2>
        <br><br>
        <a href="/afterlogin" class="button24">Вернуться</a>
    </div>
</body>
</html>

<!--
<input type="button" value="Go back" onclick="window.location.href='/afterlogin';"/>
-->