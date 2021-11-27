<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Empresa - VenturaHR</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container p-3 my-3 border bg-primary">
		<header>
			<h1 class="display-5 text-center">VenturaHR</h1>
		</header>
	</div>
	<hr>
	<div class="container">
		<h4>Inserir Dados</h4>
		<form action="cadastro" method="post">
			<div class="form-group">
				<label>Nome da Empresa:</label> <input type="text"
					class="form-control" name="nome" placeholder="Inserir Nome" value="Empresa X"
					maxlength="75" >
			</div>
			<div class="form-group">
				<label>Email:</label> <input type="email" class="form-control"
					name="email" placeholder="Inserir Email" value="x@x.com" maxlength="50" >
			</div>
			<div class="form-group">
				<label>Endereco:</label> <input type="text" class="form-control"
					name="endereco" placeholder="Inserir Endereco" value="Empresa 7" maxlength="250" >
			</div>
			<div class="form-group">
				<label>Telefone (Apenas Números):</label> <input type="text"
					class="form-control" name="telefone" placeholder="Inserir Telefone"
					value="1122334455" maxlength="11" minlength="10" required>
			</div>
			<div class="form-group">
				<label>Razão Social:</label> <input type="text" class="form-control"
					name="razaoSocial" placeholder="Inserir Razão Social" value="Empresa X LTDA" maxlength="75"  >
			</div>
			<div class="form-group">
				<label>CNPJ (Apenas Números):</label> <input type="text"
					class="form-control" name="cnpj" placeholder="Inserir CNPJ" value="11223344556677" maxlength="14" minlength="14"
					>
			</div>
			<div class="form-group">
				<label>Senha:</label> <input type="password" class="form-control"
					name="senha" placeholder="Inserir Senha" value="aa" >
			</div>
			<div class="form-group">
				<label>Confirmar Senha:</label> <input type="password"
					class="form-control" name="senhaConf" placeholder="Inserir Senha" value="aa"
					>
			</div>
			<input type="hidden" name="tipo" value="E">

			<div>
				<input type="submit" value="Cadastrar"
					class="btn btn-primary">
			</div>
		</form>
		<div>
			<c:if test="${not empty erros}">
				<h5> Erros: </h5>
				<c:forEach var="e" items="${erros}">
					<div class="alert alert-warning">
						<h5> ${e} </h5>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>

	<hr>
	<div class="container">
		<footer>
			<h6 class="text-center small">Todos os direitos Reservados</h6>
		</footer>
	</div>

</body>
</html>