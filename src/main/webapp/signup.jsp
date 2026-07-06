<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Ordering - Signup</title>

<style>

*{
	margin:0;
	padding:0;
	box-sizing:border-box;
	font-family:Arial, Helvetica, sans-serif;
}

body{

	background:linear-gradient(135deg,#ff6b35,#ff914d,#ffd166);

	min-height:100vh;

	display:flex;

	justify-content:center;

	align-items:center;

	padding:30px;
}

/* Signup Card */

.container{

	width:450px;

	background:rgba(255,255,255,.96);

	padding:35px;

	border-radius:18px;

	box-shadow:0 10px 25px rgba(0,0,0,.25);

	text-align:center;
}

/* Logo */

.logo{

	font-size:60px;

	margin-bottom:10px;
}

h2{

	color:#ff6b35;

	margin-bottom:8px;
}

.subtitle{

	color:#666;

	margin-bottom:25px;

	font-size:15px;
}

/* Input Fields */

.input-box{

	text-align:left;

	margin-bottom:16px;
}

.input-box label{

	display:block;

	margin-bottom:6px;

	font-weight:bold;

	color:#444;
}

.input-box input{

	width:100%;

	padding:12px;

	border:1px solid #ccc;

	border-radius:8px;

	font-size:15px;

	transition:.3s;
}

.input-box input:focus{

	outline:none;

	border-color:#ff6b35;

	box-shadow:0 0 8px rgba(255,107,53,.4);
}

/* Button */

button{

	width:100%;

	padding:13px;

	background:#28a745;

	color:white;

	font-size:17px;

	border:none;

	border-radius:8px;

	cursor:pointer;

	transition:.3s;
}

button:hover{

	background:#218838;

	transform:translateY(-2px);
}

/* Login Link */

.login{

	margin-top:20px;

	color:#555;
}

.login a{

	text-decoration:none;

	color:#ff6b35;

	font-weight:bold;
}

.login a:hover{

	text-decoration:underline;
}

/* Footer */

.footer{

	margin-top:25px;

	font-size:13px;

	color:#888;
}

</style>

</head>

<body>

<div class="container">

<div class="logo">

🍔

</div>

<h2>Create Your Account</h2>

<p class="subtitle">

Join us and enjoy delicious food delivered to your doorstep!

</p>

<form action="signup" method="post">

<div class="input-box">

<label>Full Name</label>

<input
type="text"
name="name"
placeholder="Enter your full name"
required>

</div>

<div class="input-box">

<label>Username</label>

<input
type="text"
name="username"
placeholder="Choose a username"
required>

</div>

<div class="input-box">

<label>Email</label>

<input
type="email"
name="email"
placeholder="Enter your email"
required>

</div>

<div class="input-box">

<label>Password</label>

<input
type="password"
name="password"
placeholder="Create a password"
required>

</div>

<div class="input-box">

<label>Phone Number</label>

<input
type="text"
name="phone"
placeholder="Enter your phone number"
required>

</div>

<div class="input-box">

<label>Address</label>

<input
type="text"
name="address"
placeholder="Enter your address"
required>

</div>

<button type="submit">

🚀 Create Account

</button>

</form>

<div class="login">

Already have an account?

<a href="login.jsp">

Login Here

</a>

</div>

<div class="footer">Made with  using Java, JSP, Servlets & MySQL</div>
Made with ❤️ using Java, JSP, Servlets & MySQL

</div>

</div>

</body>
</html>