package misServlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Productos
 */
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Hashtable<String, String>  producnombres = new Hashtable<String, String>();
	Hashtable<String, Integer>  producprecios = new Hashtable<String, Integer>();
	Hashtable<String, Integer>  cantidades = new Hashtable<String, Integer>(); 
	private int cant;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cant = Integer.parseInt(config.getInitParameter("cantidadTotal"));
        for (int i = 0; i < cant; i++) {
        	producnombres.put("golo"+i, config.getInitParameter("golo"+i));
        	producprecios.put("pu"+i, Integer.parseInt(config.getInitParameter("pu"+i)));
        }
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		if (sesion.isNew()) {
			response.sendRedirect("login.html");
		}
		
		// Guardo la cantidad total de golosinas en la sesion
		if (sesion.getAttribute("cantidadTotal") == null) {
			sesion.setAttribute("cantidadTotal", cant);
		}
		
		// Guardo los precio y productos de la sesion
		for (int i = 0; i < cant; i++) {
			if(sesion.getAttribute("produ"+i) == null) {
				sesion.setAttribute("produ"+i, producnombres.get("golo"+i));
			}
			if(sesion.getAttribute("pu"+i) == null) {
				sesion.setAttribute("pu"+i, producprecios.get("pu"+i));
			}
		}
		
		// Guardo las cantidades de la sesion
		for ( int i = 0; i < cant; i++) {
			if(sesion.getAttribute("cant"+i) == null) {
				cantidades.put("cant"+i, 0);
			} else {
				cantidades.put("cant"+i, (Integer) sesion.getAttribute("cant"+i));
			}
		}
		
		// Genera la respuesta HTML
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head><title>Productos</title></head>");
		out.println("<body>");
		out.println("<h1>Seleccione los productos</h1>");
		out.println("<form action=\"Facturar\" method=\"post\">");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Nombre</th>");
		out.println("<th>Precio</th>");
		out.println("<th>Cantidad</th>");
		out.println("</tr>");

		// Iterar sobre los productos y generar las filas de la tabla
		for (int i = 0; i < cant; i++) {
			out.println("<tr>");
		    out.println("<td>" + producnombres.get("golo"+i) + "</td>");
		    out.println("<td>" + producprecios.get("pu"+i) + "</td>");
		    out.println("<td><input type=\"number\" name=\"cant" + i + "\" value=\"" + cantidades.get("cant"+i) + "\" min=\"0\"></td>");
		    out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<input type=\"submit\" value=\"Facturar\">");
		out.println("</form>");
		out.println("<a href=\"TerminarSesion\">Salir</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
