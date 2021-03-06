<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html lang="en">
 <head>
<%--     <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">--%>
     <meta charset="UTF-8">
    <title>Sign Up</title>
    <SCRIPT TYPE="text/javascript">
	function clearStatus() { status = ""; }

	function checkRegistration() {
		var login = document.registerForm.login;
		if (login.value == "") {
			alert("Missing login.");
		return(false);
		}
		if (login.value.length < 2) {
			alert("Wrong login length.");
		return(false);
        }

		var password = document.registerForm.password;
		if (password.value == "") {
			alert("Missing password.");
		return(false);
		}
		if (password.value.length < 5) {
			alert("Wrong password length.");
		return(false);
        }
		var name = document.registerForm.name;
		if (name.value == "") {
			alert("Missing name.");
		return(false);
		}
		if (name.value.length < 2) {
			alert("Wrong name length.");
		return(false);
        }

		var middlename = document.registerForm.middlename;
		if (middlename.value == "") {
			alert("Missing middlename.");
		return(false);
		}


		var lastname = document.registerForm.lastname;
		if (lastname.value == "") {
			alert("Missing lastname.");
		return(false);
		}
		if (lastname.value.length < 2) {
			alert("Wrong lastname length.");
		return(false);
        }

        var birthday = document.registerForm.birthday
        if (birthday.value == "") {
        			alert("Missing birthday.");
        		return(false);
        }
		if (birthday.value.length < 10) {
			alert("Wrong birthday length.");
		return(false);
        }

        var passportdate = document.registerForm.passportdate
         if (passportdate.value == "") {
                	alert("Missing passportdate.");
            return(false);
         }
   		if (passportdate.value.length < 10) {
      			alert("Wrong passportdate length.");
      		return(false);
        }

		var email = document.registerForm.email;
		if (email.value == "") {
			alert("Missing email.");
		return(false);
		}

        if ( !/^[a-zA-Z][a-zA-Z0-9._-]*@[a-zA-Z][a-zA-Z0-9._-]*\.[a-zA-Z][a-zA-Z0-9]*$/.test(email.value) ) {
				alert("Wrong email format.");
			return(false);
		}
		var phone = document.registerForm.phone;
		if (phone.value == "") {
			alert("Missing phone.");
		return(false);
		}
        if ( !/^(\+?7|8)\d{10}$/.test(phone.value) ) {
			alert("Wrong phone format.");
		return(false);
		}
		return(true);
	}
	</SCRIPT>

 <style type="text/css">
	body {
    		height: 100%;
    		background: radial-gradient(circle farthest-corner at 100px 50px, aqua, darkblue ); //aqua, darkblue #FBF2EB, #352A3B
    		background-repeat: no-repeat;
    		background-size: cover;
    		background-attachment: fixed;
    	}

    	.box {
    		overflow: hidden;
    		position: absolute;
    		top: 0px;
    		left: 0px;
    		width: 100%;
    		height: 100%;
    		padding: 250px 600px;
    		cursor: move;
    		box-sizing: border-box;
    	}


	.h-form-item {
		position: relative;
		z-index: 100;
		font-size: 20px;
		margin-bottom: 5px; /* ???????????? ?????????? */
	}

	.field {
		clear:both;
		text-align:right;
		line-height:25px;
	}
	.main {float:left}

	input{
		z-index: 100;
		font-family: "Roboto Slab", serif;
		font-size: 17px;
		width: 280px; /* ???????????? ?????????? ?? ?????????????? */
		margin-left: 10px; /* ???????????????????? ?????????? ?????????? ?? ?????????????? */
		border: 1px solid #abadb3; /* ?????????? ???????????? ???????????????????? ???????? */
		border-radius: 4px;
		margin-bottom: 5px; /* ???????????? ?????????? */
	}
	.field_signup{
		font-family: "Roboto Slab", serif;
		font-size: 17px;
		width: auto; /* ???????????? ?????????? ?? ?????????????? */
		margin-left: 10px; /* ???????????????????? ?????????? ?????????? ?? ?????????????? */
		margin-top: 50px; /* ???????????? ?????????? */
		text-align:right;
	}

    .button24{
      display: inline-block;
      color: white;
      text-decoration: none;
      padding: .5em 2em;
      outline: none;
      border-width: 2px 0;
      border-style: solid none;
      border-color: #FDBE33 #000 #D77206;
      border-radius: 6px;
      background: linear-gradient(#F3AE0F, #E38916) #E38916;
      transition: 0.2s;
    }
    .button24:hover { background: linear-gradient(#f5ae00, #f59500) #f5ae00; }
    .button24:active { background: linear-gradient(#f59500, #f5ae00) #f59500; }
    </style>
</head>

<body class="body2">
<div class = "box">
    <form action="" method="POST" NAME="registerForm" onSubmit="return(checkRegistration())">
        <div class="h-form-item">
            <div class="main">
                <div class="field">
                    <label for="login">?????????? :</label>
                    <input type="text" name="userlogin"  id="login" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="Password">???????????? :</label>
                    <input type="Password" name="password" id="password" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="name">?????? :</label>
                    <input type="text" name="firstname" id="firstname" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="middlename">???????????????? :</label>
                    <input type="text" name="middlename" id="middlename" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="lastname">?????????????? :</label>
                    <input type="text" name="lastname" id="lastname" onBlur="clearStatus()"/>
                </div>

                <div class="field">
                    <label for="birthday">???????? ????????????????(yyyy-MM-dd):</label>
                    <input type="text" name ="birthday" id ="birthday" onBlur="clearStatus()"/>
                </div>

                <div class="field">
                    <label for="passport">?????????? ????????????????:</label>
                    <input type="text" name ="passport" id ="passport" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="passportorg">???????????????? ??????????????????????:</label>
                    <input type="text" name ="passportorg" id ="passportorg" onBlur="clearStatus()"/>
                </div>

                <div class="field">
                    <label for="passportdate">???????? ???????????? (yyyy-MM-dd):</label>
                    <input type="text" name ="passportdate" id ="passportdate" onBlur="clearStatus()"/>
                </div>

                <div class="field">
                    <label for="email">E-mail :</label>
                    <input type="text" id="email" name="email" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="Phone">?????????? ???????????????? :</label>
                    <input type="text" id ="Phone" name="telephone" onBlur="clearStatus()"/>
                </div>
                <div class="field_signup">
                    <input class="button24" type="submit" value="????????????????????????????????" />
                    <br>
                    <br>
                    <a href="/afterlogin" class="button24">???????????????????????? ????????</a> <a href="/logout" class="button24">??????????</a>
                </div>
            </div>
        </div>
    </form>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
</body>
</html>