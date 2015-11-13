<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajedrez - Inicio</title>
</head>

<body style="font-family: sans-serif;" onload="cargar();">
	<form action="ChessServlet" method="post" onsubmit="return validaDatos();">
	
	<table style="margin-left: auto;margin-right: auto;">
		<tr>
			<td colspan="2" style="text-align: center;">
			<input type="radio" name="opcion" value="nuevo" checked>Ingrese DNI
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">DNI 1: </td>
			<td><input type="text" name="dni1" id="dni1"></td>
		</tr>
		<tr>
			<td style="text-align: right;">DNI 2: </td>
			<td><input type="text" name="dni2" id="dni2"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
			<input type="radio" name="opcion" value="cargar">o cargue un juego
			</td>
		</tr>
		<tr>
			<td>Nro de juego: </td>
			<td><input type="text" name="nrojuego" id="nrojuego"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"><input type="submit" value="Aceptar"></td>
		</tr>
	</table>
	
	</form>
</body>

</html>