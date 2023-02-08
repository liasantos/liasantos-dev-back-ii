<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${PageContext.request.contextPath}/css/styles.css" />
		  <link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
		<title>Área restrita</title>
		<!-- 
		<style type="text/css">
			body{
				background: #ff0000;
			}
		
		</style>
		 -->
	</head>
<body>
	
	<div class='central'>
	<h3>
	<% 
		if(request.getAttribute("msg")!=null){
			out.print(request.getAttribute("msg"));
		}else{
			out.print("");
		}
	%>
	</h3>
		<form action="#" method="post">
			<input type="hidden" name="a" value="CheckLogin" />
			<label>Login</label>
				<input type="text" name="login" /> <br /> 
			<label>Senha</label>
				<input type="password" name="senha" /> <br /> 
				<input type="submit" value="entrar" />
		</form>
	</div>
</body>
</html>
