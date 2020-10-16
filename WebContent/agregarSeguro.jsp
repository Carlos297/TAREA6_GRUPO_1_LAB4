<%@page import="dominio.Seguro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar seguro</title>
</head>
<body>
	
	<a href="inicio.jsp"> Inicio</a>
	<a href="agregarSeguro.jsp"> Agregar seguro</a>
	<a href="listarSeguros.jsp"> Listar seguros</a>
	
	<h3>Agregar seguro</h3>
	<form method="get" action="servletSeguro">
	
	
	<!-- Hay que traer el id del seguro siguiente y mostrarlo por pantalla -->
	<label>Id Seguro</label>  	<br>
	<label>Descripcion</label> 	<input type="text" name="txtDescripcion" > <br>
	<!-- Faltan traer los tipos de seguro -->
	<label>Tipo de seguro</label> <select name="tipoSeguro">  <option> </option>  </select> <br>
	<label>Costo contratacíon</label> <input type="text" name="txtCostoContratacion"> <br>
	<label>Costo máximo asegurado</label> <input type="text" name="txtCostoAsegurado"><br><br>
	
	<input type="submit" name="btnAceptar" value="Aceptar">
	</form>
	
	
	<%
	int filas = 0;
	
	if(request.getAttribute("cantFilas") != null)
		filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		
		
 %>
 <br>
 <%  if(filas == 1)
		 { %> 
			
			Usuario agregado con exito
		  
		<% } %>
	
</body>
</html>