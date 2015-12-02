<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<%
String msgerror;
if (request.getAttribute("errormsg")!=null){
	msgerror = (String) request.getParameter("msgerror");
}
else{
	msgerror = ""; 
}
	%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajedrez - Nuevo Juego</title>
</head>

<script type="text/javascript">
  var opcion;
  function carga(){
	  document.getElementById("dni1").focus();
  }
  
  function validaDatos(){
	  var jugador1 = document.getElementById("jugador1");
	  var jugador2 = document.getElementById("jugador2");
	  if (jugador1.value==""){
		  alert("Ingrese DNI 1");
		  jugador1.focus();
		  return false;
	  }
	  if (jugador2.value==""){
		  alert("Ingrese DNI 2");
		  jugador2.focus();
		  return false;
	  }
  }
  
  // Tomado de http://www.cambiaresearch.com/articles/39/how-can-i-use-javascript-to-allow-only-numbers-to-be-entered-in-a-textbox
  function isNumberKey(evt)
  {
     var charCode = (evt.which) ? evt.which : event.keyCode
     if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;

     return true;
  }
  
</script>
  
<body style="font-family: sans-serif;background-color: gray;" onload="cargar();">
	<form action="NewGameServlet" method="post" onsubmit="return validaDatos();">
	
	<table style="margin-left: auto;margin-right: auto;background-color: white;">
	
		<tr>
			<td style="text-align: center;"><a href="/TPJavaChessWeb/inicio.html">Inicio</a></td>
			<td style="text-align: center;"><a href="/TPJavaChessWeb/loadGame.jsp">Cargar Juego</a></td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align: center;color:white; background-color: blue;">	Nuevo Juego - Ingrese DNI	</td>
		</tr>
		
		<tr>
			<td style="text-align: right;">DNI 1: </td>
			<td><input type="text" onkeypress="return isNumberKey(event)" onpaste="return false;" name="jugador1" id="jugador1" value=""></td>
		</tr>
		
		<tr>
			<td style="text-align: right;">DNI 2: </td>
			<td><input type="text" onkeypress="return isNumberKey(event)" onpaste="return false;" name="jugador2" id="jugador2" value=""></td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align: center;"><input type="submit" name="submitStart" value="Iniciar Juego"></td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align: center;color: red;"><%=msgerror %></td>
		</tr>
		
	</table>
	
	</form>
</body>

</html>