<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ru">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<script type="text/javascript">
    //New client
    async function NewClient(form) {
        let newClient = {
            "userLogin": clientForm.userLogin.value,
            "firstName": clientForm.firstName.value,
            "lastName": clientForm.secondName.value,
            "middleName": clientForm.middleName.value,
            "birthday": clientForm.birthDay.value,
            "passport": clientForm.passport.value,
            "passportOrg": clientForm.passportOrg.value,
            "passportDate": clientForm.passportDate.value,
            "email": clientForm.mail.value,
            "phone": clientForm.telephone.value
        };

        fetch('../clients/create', {
            method: 'POST',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newClient)
        });
    }
    //Find client by FIO
    async function findFIO(form) {
        let newClient = {
            "userLogin": clientForm.userLogin.value,
            "firstName": clientForm.firstName.value,
            "lastName": clientForm.secondName.value,
            "middleName": clientForm.middleName.value,
            "birthday": clientForm.birthDay.value,
            "passport": clientForm.passport.value,
            "passportOrg": clientForm.passportOrg.value,
            "passportDate": clientForm.passportDate.value,
            "email": clientForm.mail.value,
            "phone": clientForm.telephone.value
        };

        fetch('../clients/find_fio', {
            method: 'POST',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newClient)
        });
    }
</script>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
	<title>Bank financial processing system</title>
</head>
<body>
	<div class="postform2">
		<div id="header" class="cf">
			<h1>Поиск и редактирование клиентов</h1>
		</div>
		<div id="main" class="cf">
			<div id="content-2">
                <table>
                    <tr>
                        <td>
                            <div id="content-2-1">

                            <div class="form-group">
                                <p>

                                <fieldset>
                                        <legend>Поиск/удаление клиента по логину</legend>
                                    <form action="../clients/find" method="GET" >
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="userLogin">Имя входа клиента</label>
                                            <div class="col-md-4">
                                                <input id="login" name="userLogin" type="input" placeholder="userLogin" class="form-control input-md" value="${userData.userLogin}"> [NN U]
                                            </div>
                                        </div>
                                        <P>
                                            <button class="ulink" class="btn btn-default">Найти</button>

                                        </P>
                                    </form>
                                    <form action="../clients/main" method="POST" >
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="userLogin">Имя входа клиента</label>
                                            <div class="col-md-4">
                                                <input id="loginDel" name="userLogin" type="input" placeholder="userLogin" class="form-control input-md" value="${userData.userLogin}"> [NN U]
                                            </div>
                                        </div>
                                        <P>
                                            <button class="ulink" class="btn btn-default">Удалить</button>
                                        </P>
                                    </form>
                                </fieldset>
                            </div>

                            <p>

                            <fieldset>
                                <legend>Поиск клиента по ФИО</legend>
                                    <form action="../clients/find_fio" method="GET" >
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="firstName">Имя </label>
                                            <div class="col-md-4">
                                                <input id="irstName" name="firstName" type="input" placeholder="Имя" class="form-control input-md" value="${userData.firstName}"> [NN]

                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="secondName">Фамилия </label>
                                            <div class="col-md-4">
                                                <input id="econdName" name="secondName" type="input" placeholder="Фамилия" class="form-control input-md"  value="${userData.lastName}"> [NN]

                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="middleName">Отчество</label>
                                            <div class="col-md-4">
                                                <input id="iddleName" name="middleName" type="input" placeholder="Отчество" class="form-control input-md" value="${userData.middleName}">

                                            </div>
                                        </div>

                                        <p><button class="ulink" type="submit"> Найти по ФИО </button></p>
                                    </form>
                            </fieldset>
                            </p>
                            <p>
                                <form action="../clients/all" method="GET">
                                    <button class="button24" id="all" name="all" class="btn btn-default">
                                        Получить всех!
                                    </button>
                                </form>
                            </p>

                        </div>
                        </td>
                        <td>
                            <div id="content-2-2">
                            <p></p>

                            <fieldset>
                                <legend>Редактирование данных клиента</legend>
                                <form name="clientForm" class="form-horizontal" onsubmit="NewClient(this)">
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="userLogin">Имя входа клиента</label>
                                    <div class="col-md-4">
                                        <input id="userLogin" name="userLogin" type="input" placeholder="userLogin" class="form-control input-md" value="${userData.userLogin}"> [NN U]
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="firstName">Имя </label>
                                    <div class="col-md-4">
                                        <input id="firstName" name="firstName" type="input" placeholder="Имя" class="form-control input-md" value="${userData.firstName}"> [NN]

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="secondName">Фамилия </label>
                                    <div class="col-md-4">
                                        <input id="secondName" name="secondName" type="input" placeholder="Фамилия" class="form-control input-md"  value="${userData.lastName}"> [NN]

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="middleName">Отчество</label>
                                    <div class="col-md-4">
                                        <input id="middleName" name="middleName" type="input" placeholder="Отчество" class="form-control input-md" value="${userData.middleName}">

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="birthDay">День рождения </label>
                                    <div class="col-md-4">
                                        <input id="birthDay" name="birthDay" type="input" placeholder="День рождения" class="form-control input-md" value="${userData.birthday}"> [NN]

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="passport">Паспорт </label>
                                    <div class="col-md-4">
                                        <input id="passport" name="passport" type="input" placeholder="Паспорт" class="form-control input-md" value="${userData.passport}"> [NN U]

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="passportOrg">Паспорт выдан </label>
                                    <div class="col-md-4">
                                        <input id="passportOrg" name="passportOrg" type="input" placeholder="Паспорт выдан" class="form-control input-md" value = "${userData.passportOrg}"> [NN]

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="passportDate">Дата выдачи </label>
                                    <div class="col-md-4">
                                        <input id="passportDate" name="passportDate" type="input" placeholder="Дата выдачи" class="form-control input-md" value="${userData.passportDate}"> [NN]

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="mail">Электронная почта</label>
                                    <div class="col-md-4">
                                        <input id="mail" name="mail" type="input" placeholder="Электронная почта" class="form-control input-md" value="${userData.email}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="telephone">Телефон</label>
                                    <div class="col-md-4">
                                        <input id="telephone" name="telephone" type="input" placeholder="Телефон" class="form-control input-md" value="${userData.phone}">
                                    </div>
                                </div>
                                <p><button class="ulink" type="submit" class="btn btn-primary" value="save">Изменить данные</button></p>
                            </form>
                            </fieldset>
                            <p>
                        </div>
                        </td>
                    </tr>
                </table>
			</div>
		</div>
		<div id="footer" class="cf">
			<p>
                <a href="/afterlogin" class="button24">Операционное меню</a> <a href="/logout" class="button24">Выйти</a>
<%--                <p>Список:</p>--%>
                <c:forEach items="${clientsList}" var="clients">
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
</body></html>