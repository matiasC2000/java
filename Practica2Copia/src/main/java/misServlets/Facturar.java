package misServlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Facturar
 */
@WebServlet("/Facturar")
public class Facturar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Facturar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		if (sesion.isNew()) {
			response.sendRedirect("login.html");
		}
		
		//Recupero la cantidad de golosinas totales
		int cant = (int) sesion.getAttribute("cantidadTotal");
		
		// Guardo en la sesion todas las cantidades de golosinas que selecciono el usuario
		int[] golosinasSeleccionadas = new int[cant];
		int gol;
		for (int i = 0; i < cant; i++) {
			gol = Integer.parseInt(request.getParameter("cant"+i));
			golosinasSeleccionadas[i] = gol;
			sesion.setAttribute("cant"+i, gol);
		}
		
		//Inicializo la variable para sumar el valor total
		int total = 0;
		
		// Genera la respuesta HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Productos</title></head>");
		out.println("<body>");
		out.println("<h1>Seleccione los productos</h1>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th> Nombre </th>");
		out.println("<th> Cantidad Comprada </th>");
		out.println("<th> Precio total </th>");
		out.println("</tr>");
		
		//Itera para generar las filas que se hayan comprado por lo menos una golosina
		for (int i = 0; i < cant; i++) {
			if (golosinasSeleccionadas[i] > 0) {
				out.println("<tr>"); 
			   	out.println("<td>"+ sesion.getAttribute("produ"+i) +"</td>");
			   	out.println("<td>"+ golosinasSeleccionadas[i] +"</td>");
			   	out.println("<td>"+ golosinasSeleccionadas[i] * (Integer) sesion.getAttribute("pu"+i) +"</td>");
			   	out.println("</tr>");
			   	total += golosinasSeleccionadas[i] * (Integer) sesion.getAttribute("pu"+i);
			}
		};
		out.println("</table>");
		out.println("<br>");
		out.println("<br>");
		// Expresa el valor final de la compra
		out.println("<h3> Total general: "+total+"</h3>");
		out.println("<a href=\"Productos\"> Seguir comprando </a>");
		out.println("<br>");
		out.println("<br>");
		out.println("<a href=\"TerminarSesion\"> Salir </a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	
	}

}
