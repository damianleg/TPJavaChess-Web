<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
String nrojuego = (String)request.getSession().getAttribute("nrojuego");
String jugador1 = (String)request.getSession().getAttribute("jugador1");
String jugador2 = (String)request.getSession().getAttribute("jugador2");
String turno = (String)request.getSession().getAttribute("turno");
String piezasblancas = (String)request.getSession().getAttribute("piezasblancas");
String piezasnegras = (String)request.getSession().getAttribute("piezasnegras");
String mov = (String)request.getSession().getAttribute("mov");
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajedrez - Juego</title>
</head>

<body style="font-family: sans-serif;background-color: gray;">
	
	<form action="ChessServlet" method="post">
	<table style="margin-left: auto;margin-right: auto;background-color: white; text-align: center;">
		<tr>
			<td><a href="/TPJavaChessWeb/newGame.jsp">Nuevo Juego</a></td>
			<td><a href="/TPJavaChessWeb/loadGame.jsp">Cargar Juego</a></td>
		</tr>

		<tr>		
			<td colspan="2" style="color:white; background-color: blue;">Juego</td>
		</tr>		
		
		<tr>
			<td style="color:white; background-color: black;">Juego nro</td>
			<td><%=nrojuego %></td>
		</tr>
		<tr>
			<td style="color:white; background-color: black;">Jugador 1</td>
			<td><%=jugador1%></td>
		</tr>
		
		<tr>		
			<td style="color:white; background-color: black;">Jugador 2</td>
			<td><%=jugador2%></td>
		</tr>
		
		<tr>
			<td style="color:white; background-color: black;">Turno:</td>
			<td> <%=turno %></td>
		</tr>
		
		<tr>
			<td colspan="2" style="color:white; background-color: black;">Piezas</td>
		</tr>
		
		<tr>		
			<td><%=piezasblancas%></td>
			<td><%=piezasnegras%></td>
		</tr>

		<tr>		
			<td colspan="2" style="color:white; background-color: blue;">Movimiento</td>
		</tr>

		<tr>		
			<td colspan="2"><%=mov %></td>
		</tr>

		<tr>
			<td>
				Desde:<select name="columnadesde" id="columnadesde">
					<option value="a">a</option>
					<option value="b">b</option>
					<option value="c">c</option>
					<option value="d">d</option>
					<option value="e">e</option>
					<option value="f">f</option>
					<option value="g">g</option>
					<option value="h">h</option>
				</select><select name="filadesde" id="filadesde">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
				</select>
			</td>
			<td>
				Hasta:<select name="columnahasta" id="columnahasta">
					<option value="a">a</option>
					<option value="b">b</option>
					<option value="c">c</option>
					<option value="d">d</option>
					<option value="e">e</option>
					<option value="f">f</option>
					<option value="g">g</option>
					<option value="h">h</option>
				</select><select name="filahasta" id="filahasta">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
				</select> 
			</td>
		</tr>
		

		
		<tr>
			<td colspan="2"><input type="submit" name="submitGame" value="Mover"></td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align: right;"><input type="submit" name="submitGame" value="Guardar Juego"></td>
		</tr>
	</table>
	
	</form>
</body>
</html>