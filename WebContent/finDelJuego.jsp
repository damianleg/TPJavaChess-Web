<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String mov = (String)request.getAttribute("mov");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fin del Juego</title>
</head>

<body style="font-family: sans-serif;background-color: gray;">

<table style="margin-left: auto;margin-right: auto;background-color: white; text-align: center;">
		<tr><td style="text-align: center;"><a href="/TPJavaChessWeb/inicio.html">Inicio</a></td>
		<tr><td colspan="2" style="color:white; background-color: blue;">Fin del Juego</td></tr>
		<tr><td><%=mov %></td></tr>	
		<tr><td>¿Quiere <a href="/TPJavaChessWeb/newGame.jsp">empezar un juego nuevo</a></td></tr>
		<tr><td>o <a href="/TPJavaChessWeb/loadGame.jsp">cargar otro juego?</a></td></tr>
		
</table>
</body>
</html>