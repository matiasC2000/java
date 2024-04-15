package misServlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServlet;

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
		ServletContextListener.super.contextInitialized(sce);
		ServletContext sc = sce.getServletContext();
		String ruta = sc.getInitParameter("stock");
		System.out.println(ruta);
		
	}
    
	
}
