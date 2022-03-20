<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration User</title>
</head>
<body>
<h3>Data create :${todaydata}</h3>
<form method ="POST"  action="">
    <div>
        login:<input type="text" name ="userlogin">
    </div>
    <div>
        password:<input type="password" name ="password">
    </div>
    <div>
        firstname:<input type="text" name ="firstname">
    </div>
    <div>
        middlename:<input type="text" name ="middlename">
    </div>
    <div>
        lastname:<input type="text" name ="lastname">
    </div>
    <div>
        birthday ("yyyy-MM-dd"):<input  type="text" name ="birthday">
    </div>
    <div>
        passport:<input  type="text" name ="passport">
        passportorg: <input  type="text" name ="passportorg">
        passportdate:<input  type="text" name ="passportdate">
    </div>
    <div>
        email:<input type="text" name ="email">
    </div>
    <div>
        telephone:<input type="text" name ="telephone">
    </div>
    <div>
    <h4><input type="submit" value="Registration user"></h4>
    <br><br>
        <input type="button" value="Admin Menu" onclick="window.location.href='/afterlogin';"/>
        <h4><a href="/logout">Logout</a></h4>
    </div>
</form>
</body>
</html>