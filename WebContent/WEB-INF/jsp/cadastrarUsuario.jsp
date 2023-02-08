<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<meta charset="UTF-8">
<title>Cadastrar Usuário</title>
</head>
<body>
<body>
	<div class='central'>
		<h1>Castrando novo usuário</h1>
	    <form action="mvc">
	    	<input type='hidden' 	name = 'a' value='CadastrarUsuario'/><br />
	    	Nome: 		<input type="text" 	name = "nome"/><br />
	    	CPF: 	<input type="text" 	name = "cpf"/><br />
	    	Telefone: 	<input type="text"	name = "telefone"/><br />
	    	Email: <input type="text" name = "email"/><br />
	    	Senha: <input type="text" name = "senha"/><br />
	    	<input type="submit" value = "Gravar"/>
	    </form>
   		<a href='?a=ListarUsuarios'>Voltar</a>
    </div>
</body>
</html>