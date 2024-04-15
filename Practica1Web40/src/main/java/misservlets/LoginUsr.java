package misservlets;

import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginUsr
 */
@WebServlet("/LoginUsr")
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String contra="123", user="user";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsr() {
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
		// TODO Auto-generated method stub
		if(request.getParameter("nombre").equals(user) && request.getParameter("contrasenia").equals(contra)) {
			PrintWriter out = response.getWriter();
			//Escribir el contenido HTML de la respuesta
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Página de Respuesta del Servlet</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>¡Bienvenido al Servlet!</h1>");
	        out.println("<p>Esta es la página generada por el servlet.</p>");

	        out.println("</body>");
	        out.println("</html>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Página de Respuesta del Servlet</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>¡Todo mal!</h1>");
	        // Agregar un enlace a otro archivo HTML
	        out.println("<p><a href='login.html'>Ir a otro archivo HTML</a></p>");
	        out.println("</body>");
	        out.println("</html>");
		}
	}

}
