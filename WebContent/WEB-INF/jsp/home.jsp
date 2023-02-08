<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="${PageContext.request.contextPath}/css/styles.css" />

<title>Empréstimo de Livros></title>
</head>
<body>
	<h3>
		Olá, <%= request.getSession().getAttribute("user") %>
	</h3>
	<div class="central">
		<table border='1'>
		  <tr><th>Menu</th></tr>
		  <tr><td><a href="?a=ExibirFormCadastro">Cadastrar contato</a></td></tr>
		  <tr><td><a href="?a=ListarContatos">Listar Contatos</a></td></tr>
		  <tr><td>
		  	<form method="post">
				<input type="hidden" name='a' value="Sair" />
				<input type="submit" value="Sair"/>
			</form>
		  </td></tr>
		  </table>
	</div>

	
</body>


</html>