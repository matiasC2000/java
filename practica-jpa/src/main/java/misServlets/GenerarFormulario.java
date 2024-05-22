package misServlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Item;
import DAO.ItemsPresupuestoDAO;

/**
 * Servlet implementation class GenerarFormulario
 */
public class GenerarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> items = ItemsPresupuestoDAO.getItems();
		for(Item item:items) {
			System.out.print(item.toString());
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<h1 style=\"text-align:center;\">Seleccione opciones</h1>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<CENTER>");
		out.println("<form action=\"GenerarPresupuesto\" method=\"POST\">");
		out.println("<TR> <TD ALIGN=\"right\">Usuario: </TD><TD><INPUT TYPE=\"Text\" NAME=\"nombre\" ALIGN=\"LEFT\" SIZE=\"15\"></TD><TR>");
		out.println("<br><br>");
		out.println("<TR> <TD ALIGN=\"right\">Email: </TD><TD><INPUT TYPE=\"Text\" NAME=\"email\" ALIGN=\"LEFT\" SIZE=\"15\"></TD>");
		out.println("<br>");
		for(Item item:items) {
			 out.println("<br>");
			 out.println("<TR><TD style=\"text-align:center;\"><label><input type=\"checkbox\" name=\"items\" value="+item.getNombre()+">"+item.getNombre()+"</label> </TD><TD ALIGN=\"right\">"+"  $"+item.getPrecio()+"</TD><TR>" );
		}
		out.println("<br><br>");
		out.println("</tr>");
		out.println( "</table>");
		out.println("<INPUT TYPE=\"Submit\" VALUE=\"Facturar\"></input>");
		out.println("<form>");
		out.println("</CENTER>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
