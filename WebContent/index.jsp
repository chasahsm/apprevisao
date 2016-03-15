<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Logar na app</title>
	</head>
	<body>
		<form action="/apprevisao/servletController" method="post">
			<label for="login">Login:</label>
			<input type="text" id="login" name="login" /><br><br>
			<label for="senha">Senha:</label>
			<input type="password" id="senha" name="senha" /><br><br>
			<button type="submit">Entrar</button>
		</form>
	</body>
</html>