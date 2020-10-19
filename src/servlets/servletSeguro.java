package servlets;

import java.awt.print.Printable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Message;

import dominio.Seguro;
import dominio.SeguroDAO;
import dominio.TipoSeguro;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SeguroDAO seguroDAO = new SeguroDAO();
		String valorSelect = " ";
		int filas = 0;
		String descripcion = request.getParameter("txtDescripcion");
		String costoContratacion = String.valueOf(request.getParameter("txtCostoContratacion"));
		String costoAsegurado = String.valueOf(request.getParameter("txtCostoAsegurado"));
		
		if(request.getParameter("btnAceptar") != null)
		{
						
			Seguro seguro = new Seguro();
			if (request.getParameter("txtDescripcion") !="")
				     seguro.setDescripcion(request.getParameter("txtDescripcion"));
						
			valorSelect = request.getParameter("tipoSeguro");
			TipoSeguro tipoSeguro = new TipoSeguro();
			tipoSeguro.setId(Integer.parseInt(valorSelect));
			seguro.setTipoSeguro(tipoSeguro);
			
			if(request.getParameter("txtCostoContratacion") != "" && validarDouble(request.getParameter("txtCostoContratacion")))
			{
				seguro.setCostoContratacion(Double.parseDouble(request.getParameter("txtCostoContratacion")));
			}
				
			if(request.getParameter("txtCostoAsegurado") != "" && validarDouble(request.getParameter("txtCostoAsegurado")))
				seguro.setCostoAsegurado(Double.parseDouble(request.getParameter("txtCostoAsegurado")));
			
			
			
			if(request.getParameter("txtDescripcion") != "" && request.getParameter("txtCostoContratacion") != "" && request.getParameter("txtCostoAsegurado") != "" && esParametroValido(descripcion) && validarDouble(costoContratacion) && validarDouble(costoAsegurado)) 
			{
						filas = seguroDAO.agregarSeguro(seguro);
				
			}
			else
			{
				filas=10; //Puse un nro cualquiera para que NO GRABE EN LA DB
			}
			
				request.setAttribute("cantFilas", filas);
				
				RequestDispatcher rd = request.getRequestDispatcher("/agregarSeguro.jsp");  				  
				rd.forward(request, response);
				
					
		}
		
		
		if(request.getParameter("opc") != null) {
			
			ArrayList<Seguro> listaSeguro = seguroDAO.obtenerTodosLosSeguros();
			
			request.setAttribute("lista", listaSeguro);
			
			RequestDispatcher rd = request.getRequestDispatcher("/listarSeguros.jsp");  				  
			rd.forward(request, response);
			
		}
		
		
		if(request.getParameter("btnFiltrarSeguro") != null) {
			
			valorSelect = request.getParameter("busquedaTipoSeguro");
			
			ArrayList<Seguro> listaSeguro = seguroDAO.obtenerTodosLosSegurosFiltrados(Integer.parseInt(valorSelect));
			
			
			request.setAttribute("listaFiltrada", listaSeguro);
			
			RequestDispatcher rd = request.getRequestDispatcher("/listarSeguros.jsp");  				  
			rd.forward(request, response);
			
			
		}
		
	}
	
	//VALIDACIONES 
	private boolean esParametroValido(String descripcion) 
	{
		for (int x = 0; x < descripcion.length(); x++) {
	        char c = descripcion.charAt(x);
	        // Si no está entre a y z, ni entre A y Z, ni es un espacio
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
	            return false;
	        }
	    }
	    return true;
	}
	
	private boolean validarDouble(String cadena) 
	{
		for (int x = 0; x < cadena.length(); x++) {
	        char c = cadena.charAt(x);
	        // Si esta entre 0 y el + . o ,
	        if ((c >= '0' && c <= '9') || (c == '.') || (c== ','))
	        {
	            return true;
	        }
	    }
	    return false;
    }
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
