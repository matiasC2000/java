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
 * Servlet implementation class LoginUsr
 */
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//nose si esta bien que esto este aca
	private Hashtable<String, String> logins;

    /**
     * Default constructor. 
     */
    public LoginUsr() {
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        logins = new Hashtable<>();
        
        Enumeration<String> paramNames = config.getInitParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = config.getInitParameter(paramName);
            logins.put(paramName, paramValue);
        }
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
		String usr = request.getParameter("nombre");
		String contr = logins.get(usr);
		if(contr != null) {
			if(contr.equals(request.getParameter("contrasenia"))) {
				//aca si tiene la contra
				HttpSession session = request.getSession();
				session.setAttribute("nombre", usr);
				session.setAttribute("contrasenia", contr);
				session.setAttribute("mail",request.getParameter("mail"));
				session.setAttribute("apellidoNombre", request.getAttribute("apellidoNombre"));
				response.sendRedirect("/Practica2Copia/Productos");
			}else {
				//no era la contra
				response.sendRedirect("login.html");
			}
		}
		doGet(request, response);
	}

}
