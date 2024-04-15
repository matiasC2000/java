package misServlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class controla
 */
public class controla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controla() {
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
	    // Recuperar el valor del parámetro 'nombre'
	    String nombre = request.getParameter("nombre");
	    
	    // Recuperar el valor del parámetro 'opcion'
	    String opcion = request.getParameter("opcion");
	    
        ServletContext currentContext = getServletContext();

	    
	    // Realizar acciones en función de la opción seleccionada
	    if (opcion != null) {
    		HttpSession sesion = request.getSession(true);
	        if (opcion.equals("Servlet Hola")) {
				sesion.setAttribute("nombre", nombre);
				//lo puedo mandar por la sesion o por el request
				ServletContext ctx=this.getServletContext();
				RequestDispatcher dispatcher=ctx.getRequestDispatcher("/holaservlet");
				if (dispatcher!=null) dispatcher.forward(request,response);

	        } else if (opcion.equals("Productos")) {
	            // Como usar el CrossContext
	        	response.sendRedirect("http://localhost:8080/Practica2Copia/login.html");
	        } else if (opcion.equals("Google")) {
	        	response.sendRedirect("https://google.com/");
	        }
	    }
	    else {
        	response.sendRedirect("/pruebas/inicio.html");
        }
	    
	    // Tu lógica adicional aquí
	    
	    // Por ejemplo, enviar una respuesta al cliente
	    response.setContentType("text/html");
	    response.getWriter().println("<h1>¡Hola, " + nombre + "!</h1>");
	    response.getWriter().println("<p>Seleccionaste la opción: " + opcion + "</p>");
	}
}
