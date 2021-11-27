<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Página Inicial - VenturaHR</title>
</head>
<body>
	<div class="container p-3 my-3 border bg-primary">
		<header>
			<h1 class="display-6 text-center">VenturaHR</h1>
		</header>
	</div>
	<hr>
	<div class="container">
		<h5>Realizar Login</h5>
		<form action="/login" method="Post">
			<div class="form-group">
				<label>Email:</label> 
				<input type="email" class="form-control" name="email"placeholder="Seu email aqui">
			</div>
			<div class="form-group">
				<label>Senha:</label> 
				<input type="password" class="form-control" name="senha" placeholder="Sua senha aqui" >
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox"> Lembrar
				</label>
			</div>
			<div>
				<input type="submit" value="Login" class="btn btn-primary">
			</div>
			<div>
				<c:if test="${not empty erro}">
					<div class="alert alert-warning">
						<h3> ${erro} </h3>
					</div>
				</c:if>

			</div>
		</form>
	</div>
	<hr>
	<div class="container">
		<h5>Realizar Cadastro</h5>
		
		<a href="/empresa" class="btn btn-link" role="button">Empresa</a>
		<a href="/candidato" class="btn btn-link" role="button">Candidato</a>
	</div>
	<hr>
	<div class="container">
		<footer>
			<h6 class="text-center small">Todos os direitos Reservados</h6>
		</footer>
	</div>
</body>
</html>