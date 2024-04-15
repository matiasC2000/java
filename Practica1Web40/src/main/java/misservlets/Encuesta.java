package misservlets;

import jakarta.servlet.http.*;
import java.io.*;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Encuesta
 */
@WebServlet("/Encuesta")
public class Encuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encuesta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init (ServletConfig config) throws ServletException{
    	super.init(config);
    	ServletContext context =  config.getServletContext();
    	int[] contadorMascotas = new int[5];
    	context.setAttribute("contadorMascotas", contadorMascotas);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] tiposAnimales = {"Perro", "Gato", "Tortuga"};
        ServletContext contexto = getServletContext();
		int[] contadorMascotas = (int[]) contexto.getAttribute("contadorMascotas");

        // Configurar el tipo de contenido de la respuesta
        response.setContentType("text/html");

        // Obtener un escritor para escribir la respuesta
        PrintWriter out = response.getWriter();

        // Escribir el contenido HTML de la respuesta
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Tabla de Votos de Animales</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Tabla de Votos de Animales</h2>");
        out.println("<table border='1'>"); // Inicia la tabla
        out.println("<tr><th>Mascota</th><th>Cantidad de Votos</th></tr>"); // Encabezados de la tabla

        // Iterar sobre los tipos de animales y sus votos asociados para crear filas en la tabla
        for (int i = 0; i < tiposAnimales.length; i++) {
            out.println("<tr>");
            out.println("<td>" + tiposAnimales[i] + "</td>");
            out.println("<td>" + contadorMascotas[i] + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<p><a href='mascota.html'>Ir a encuesta</a></p>");
        out.println("</body>");
        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext contexto = getServletContext();
		int[] contadorMascotas = (int[]) contexto.getAttribute("contadorMascotas");
        
		// Crear un diccionario
        Map<String, Integer> diccionario = new HashMap<>();
        
        String[]  mascotas = request.getParameterValues("mascota");

        // Agregar palabras y sus números correspondientes al diccionario
        diccionario.put("perro", 0);
        diccionario.put("gato", 1);
        diccionario.put("tortuga", 2);
        
        for (String mascota : mascotas) {
        	int iMascota = diccionario.get(mascota);
        	contadorMascotas[iMascota]=contadorMascotas[iMascota]+1;
        }
        
        doGet(request, response);        
	}

}
