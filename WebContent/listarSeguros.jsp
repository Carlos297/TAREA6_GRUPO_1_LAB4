<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Seguro"%>
<%@page import="dominio.SeguroDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar seguros</title>
</head>
<body>

	<a href="inicio.jsp"> Inicio</a>
	<a href="agregarSeguro.jsp"> Agregar seguro</a>
	<a href="servletSeguro?opc=3"> Listar seguros</a>	
	
	<h4> "Tipo de seguros de la base de datos" </h4>
	
<form method="get" action="servletSeguro">
	
	Busqueda por tipo de Seguros: 
	<select name="busquedaTipoSeguro">  
	<option value="1">Seguro de casas </option>  
	<option value="2">Seguro de vida </option> 
	<option value="3">Seguro de motos </option> 
	</select>
	
	<input type="submit" name="btnFiltrarSeguro" value="Filtrar" >
	<br><br>
	
	
	<% ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>(); 
	
		if(request.getAttribute("lista") != null)
		{
			listaSeguros = (ArrayList<Seguro>)request.getAttribute("lista");
		} else if(request.getAttribute("listaFiltrada") != null){
		
			listaSeguros = (ArrayList<Seguro>)request.getAttribute("listaFiltrada");
		}
		
	
	%>
	
	
	
	<table border=1>
	
	<tr> <th> ID seguro </th> <th> Descripción seguro </th> <th> Descripción tipo de seguro </th> <th> Costo contratación </th> <th> Costo máximo asegurado </th> </tr>
	
	<%	if(listaSeguros != null)
		{
			for(Seguro seg : listaSeguros)
			{ %>
			
			<tr> <th> <%=seg.getIdSeguro() %> </th> <th> <%=seg.getDescripcion() %> </th> <th> <%=seg.getTipoSeguro().getDescripcion() %> </th> <th> <%=seg.getCostoContratacion() %> </th> <th> <%=seg.getCostoAsegurado() %> </th> </tr>
						
			<%} 
	
		}
		
		
	%>
		
	</table>



</form>
	

</body>
</html>