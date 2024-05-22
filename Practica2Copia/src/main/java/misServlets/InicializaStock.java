package misServlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class InicializaStock
 *
 */
@WebListener
public class InicializaStock implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicializaStock() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String ruta = context.getInitParameter("stock");
		System.out.println(ruta);
		// Obtener un InputStream del archivo de texto utilizando getResourceAsStream()
        InputStream inputStream = context.getResourceAsStream(ruta);

        // Crear un InputStreamReader a partir del InputStream para convertirlo en un Reader
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        // Crear un BufferedReader a partir del InputStreamReader para leer el archivo línea por línea
        BufferedReader reader = new BufferedReader(inputStreamReader);
        int i=0;

        String line;
            try {
				while ((line = reader.readLine()) != null) {
				    // Dividir la línea en nombre y valor utilizando el delimitador ","
				    String[] parts = line.split(",");
				    String nombre = parts[0].trim();
				    String valor = parts[1].trim();
				    
				    // Hacer algo con los datos leídos (por ejemplo, imprimirlos)
				    context.setAttribute("golo"+i,nombre);
				    context.setAttribute("pu"+i,valor);
				    
				    i++;
				}
				context.setAttribute("cantidadTotal",i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
	}
	
}
/*
    public void init(FilterConfig config) throws ServletException {
    	this.config = config;
    }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = this.config.getServletContext();
		String ruta = sc.getInitParameter("stock");
		System.out.println(ruta);
	}
*/

