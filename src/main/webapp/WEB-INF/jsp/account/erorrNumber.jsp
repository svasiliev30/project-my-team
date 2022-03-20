<%--Author Sergey Vasiliev--%>
<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <title>Erorr</title>
</head>
<body>
    <div class="postform2">
        <h1>Ошибка!!!</h1>
        Вы вводите неверный номер счета или такого счета не существует.<br>
        Пожалуйста, проверьте свой номер или создайте новый номер счета.
        <form action="/account/info" method="get">
            <input class="button24" type="submit" value="Информация по счету">
        </form>
    </div>
</body>
</html>