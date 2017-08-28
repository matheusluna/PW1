<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SisPlace</title>
	<!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
	<div class="container">
      <div class="container">
        <div class="container">
          <div class="container">
            <div class="row center-align">
              <img class="circle" src="img/logo.png" height="200px" alt="">
            </div>
            <div class="row">
              <form class="col s12" action="Login" method="post">
                <div class="row input-field col s12">
                  <input id="email" type="text" name="email">
                  <label for="email">E-mail</label>
                </div>
                <div class="row input-field col s12">
                  <input id="senha" type="password" name="senha">
                  <label for="senha">Senha</label>
                </div>
                <div class="row col s12">
                	<p class="red-text"><%=request.getAttribute("erro")%></p>
                  <p>Não tem conta? <a href="cadastro.html">Clique aqui</a></p>
                </div>
                <div class="row center-align">
                  <input class="btn teal darken-3" type="submit" value="Login">
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
</body>
</html>