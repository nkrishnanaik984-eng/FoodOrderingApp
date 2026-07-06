<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Ordering - Login</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{

    height:100vh;

    display:flex;

    justify-content:center;

    align-items:center;

    background:linear-gradient(135deg,#ff6b35,#ff914d,#ffd166);

}

.container{

    width:380px;

    background:rgba(255,255,255,0.95);

    padding:40px;

    border-radius:20px;

    box-shadow:0 10px 30px rgba(0,0,0,0.25);

    text-align:center;

}

.logo{

    font-size:60px;

    margin-bottom:10px;
}

h2{

    color:#ff6b35;

    margin-bottom:8px;
}

.subtitle{

    color:#777;

    margin-bottom:30px;

    font-size:15px;
}

.input-box{

    margin-bottom:18px;

    text-align:left;
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

    transition:0.3s;
}

.input-box input:focus{

    outline:none;

    border-color:#ff6b35;

    box-shadow:0 0 8px rgba(255,107,53,0.4);
}

button{

    width:100%;

    padding:13px;

    border:none;

    border-radius:8px;

    background:#ff6b35;

    color:white;

    font-size:17px;

    cursor:pointer;

    transition:.3s;
}

button:hover{

    background:#e65c2d;

    transform:translateY(-2px);
}

.signup{

    margin-top:20px;

    color:#555;
}

.signup a{

    text-decoration:none;

    color:#ff6b35;

    font-weight:bold;
}

.signup a:hover{

    text-decoration:underline;
}

.footer{

    margin-top:25px;

    font-size:13px;

    color:#888;
}

</style>

</head>

<body>

<div class="container">

<div class="logo">🍔</div>

<h2>Food Ordering App</h2>

<p class="subtitle">
Login to order your favourite food
</p>

<form action="login" method="post">

<div class="input-box">

<label>Username</label>

<input type="text"
name="username"
placeholder="Enter Username"
required>

</div>

<div class="input-box">

<label>Password</label>

<input type="password"
name="password"
placeholder="Enter Password"
required>

</div>

<button type="submit">

Login

</button>

</form>

<div class="signup">

New User?

<a href="signup.jsp">

Create Account

</a>

</div>

<div class="footer">Made with using Java, JSP & Servlets</div>
Made with using Java, JSP & Servlets

</div>

</div>

</body>
</html>