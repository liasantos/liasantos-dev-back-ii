<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="UsuarioDAO, Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css">
<title>Lista de usuários</title>
</head>
<body>
<% 	
	Usuario u = (Usuario) request.getAttribute("usuario");
%>

	<div class='central'>
		<h1>Exibir usuários</h1>
		
		<h2> <%
		
		if(request.getAttribute("msg")!= null)
			out.print(request.getAttribute("msg"));
		%> </h2>
		
		<form action='mvc'>
		<input type='hidden' 	name = 'a' value='EditarUsuario'/><br />
		<input type='hidden' 	name = 'id' value='<% out.print(u.getId()); %>'/><br />
		Nome: 		<input type='text' 	name = 'nome' value='<% out.print(u.getNome());%>'/><br />
		CPF: 	<input type='text' 	name = 'cpf' value='<% out.print(u.getCpf()); %>'/><br />
		Telefone: 	<input type='text'	name = 'telefone' value='<% out.print(u.getTelefone());%>'/><br />
		Senha: 	<input type='text'	name = 'senha' value='<% out.print(u.getSenha());%>'/><br />

			<input type='submit' value = 'Editar'/>
		</form>
		<a href="${request.contextPath}">Ir para home</a>
	</div>
</body>
</html>

