<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.text.SimpleDateFormat,modelo.Contato, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/styles.css">
	<meta charset="UTF-8">
	<title>Salvando o contato</title>
</head>
<body>
	<h3>
		Olá, <%= request.getSession().getAttribute("user") %>
	</h3>
	<div class='central'>
		<table border='1'>
			<thead>
				<tr>
					<td>Nome</td><td>e-mail</td><td>Endereço</td><td>Data Nascimento</td><td>Editar</td><td>Excluir</td>
				</tr>
			</thead>
			<tbody>
			<%
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			for(Contato aux: (List<Contato>)request.getAttribute("contatos") ) {
			%>
				<tr>
					<td><% out.println(aux.getNome()); %></td>
					<td><% out.println(aux.getEmail()); %></td>
					<td><% out.println(aux.getEndereco()); %></td>
					<td><% out.println(formatador.format(aux.getDataNascimento().getTime())); %></td>
					<td><a href='?a=ExibirContato&id=<% out.print(aux.getId()); %>'>Editar</a></td>
					<td><a href='?a=RemoverContato&id=<% out.print(aux.getId()); %>'>Excluir</a></td>
				</tr>
			<%} %>
			</tbody>
		</table>
		<a href="/dev-back-ii-2022-2">Ir para home</a>
	</div>
</body>
</html>

