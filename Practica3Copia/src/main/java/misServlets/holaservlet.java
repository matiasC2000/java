package misServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class holaservlet
 */
public class holaservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public holaservlet() {
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
        // Recuperar el valor del parámetro 'nombre' del formulario
        String nombre = request.getParameter("nombre");
        
        // Construir el HTML de la respuesta
        String htmlResponse = "<!DOCTYPE html>"
                            + "<html lang=\"es\">"
                            + "<head>"
                            + "<meta charset=\"UTF-8\">"
                            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                            + "<title>Bienvenido</title>"
                            + "</head>"
                            + "<body>"
                            + "<h1>Bienvenido, " + nombre + "!</h1>"
                            + "</body>"
                            + "</html>";
        
        // Configurar el tipo de contenido de la respuesta y escribir el HTML en la respuesta
        response.setContentType("text/html");
        response.getWriter().println(htmlResponse);
	}

}
