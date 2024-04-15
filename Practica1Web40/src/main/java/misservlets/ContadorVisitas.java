package misservlets;

import jakarta.servlet.http.*;
import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
/**
 * Servlet implementation class ContadorVisitas
 */
@WebServlet("/ContadorVisitas")
public class ContadorVisitas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContadorVisitas() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init (ServletConfig config) throws ServletException{
    	super.init(config);
    	ServletContext context =  config.getServletContext();
    	int contadorVisitas=0;
    	context.setAttribute("contadorVisitas", contadorVisitas);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtiene la cantidad de visitas almacenada en el atributo de solicitud
    	ServletContext contexto = getServletContext();
        int visitas = (int) contexto.getAttribute("contadorVisitas");
        
        // Incrementa la cantidad de visitas
        visitas++;
        
        contexto.setAttribute("contadorVisitas", visitas);
        // Prepara la respuesta HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Contador de Visitas</title></head><body>");
        out.println("<h1>Este servlet lo : " + visitas + " usuario/s</h1>");
        out.println("</body></html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//incremento la variable y llamo al get para mostralo
		doGet(request, response);
	}

}
