<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Seguro"%>
<%@page import="dominio.SeguroDAO"%>
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
	<a href="servletSeguro?opc=3"> Listar seguros</a>
	
	<h3>Agregar seguro</h3>
	<form method="get" action="servletSeguro">


<%  

	Seguro seguro = new Seguro();
	SeguroDAO seguroDAO = new SeguroDAO();
	seguro.getIdSeguro();
	int id = 0;
	ArrayList<Seguro> listaSeguro  = seguroDAO.obtenerTodosLosSeguros();
	

	for(Seguro seg : listaSeguro){ 	
	
		id = seg.getIdSeguro();
	
}
%>

<style>

label{
  display: inline-block;
  width: 170px;
  height: 25px;
}

	


</style>

	<div><label>Id Seguro</label> <%=id+1 %>  	<br></div>
	
	<div><label>Descripcion</label> 	<input type="text" name="txtDescripcion"> <br></div>
	
	<div>	<label>Tipo de seguro</label> 
	<select name="tipoSeguro">  
	<option value="1">Seguro de casas </option>  
	<option value="2">Seguro de vida </option> 
	<option value="3">Seguro de motos </option> 
	</select> <br></div>

	<div><label>Costo contratacíon</label> <input type="text" name="txtCostoContratacion"> <br></div>
	
	<div><label>Costo máximo asegurado</label> <input type="text" name="txtCostoAsegurado"><br><br></div>
	
	<div><input type="submit" name="btnAceptar" value="Aceptar"></div>
	
	</form>
	
	
	<%
	int filas = 0;
	
		

	if(request.getAttribute("cantFilas") != null)
		filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		
		
 %>
 <br>
 
 <%  if(filas == 1)
		 { %> 
			
			Seguro agregado con exito
			<%filas=0; %>		  
		<% } %>
		
		
 <% if(filas == 10)
 	{ %>
	
	 Ingrese correctamente los campos <%filas=0; %>	
	 <%
	 }
		
	%>
	
</body>
</html>