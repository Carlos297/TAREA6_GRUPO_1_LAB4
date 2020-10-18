package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String valorSelect = "";
		int filas = 0;
		
		if(request.getParameter("btnAceptar") != null)
		{
						
			Seguro seguro = new Seguro();
			if(request.getParameter("txtDescripcion") != "")
				seguro.setDescripcion(request.getParameter("txtDescripcion"));
			valorSelect = request.getParameter("tipoSeguro");
			TipoSeguro tipoSeguro = new TipoSeguro();
			tipoSeguro.setId(Integer.parseInt(valorSelect));
			seguro.setTipoSeguro(tipoSeguro);
			
			if(request.getParameter("txtCostoContratacion") != "")
				seguro.setCostoContratacion(Double.parseDouble(request.getParameter("txtCostoContratacion")));
			if(request.getParameter("txtCostoAsegurado") != "")
				seguro.setCostoAsegurado(Double.parseDouble(request.getParameter("txtCostoAsegurado")));
			
			
			
			if(request.getParameter("txtDescripcion") != "" && request.getParameter("txtCostoContratacion") != "" && request.getParameter("txtCostoAsegurado") != "") 
			{
				filas = seguroDAO.agregarSeguro(seguro);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
