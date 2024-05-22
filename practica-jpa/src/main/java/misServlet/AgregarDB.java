package misServlet;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.ItemsPresupuestoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Item;

/**
 * Servlet implementation class AgregarDB
 */
public class AgregarDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Item> items = new ArrayList<>();

        // Agregar elementos a la lista
    	items.add(new Item("cantidad de invitados", 800.0));
    	items.add(new Item("Salón", 5000.0));
        items.add(new Item("Catering", 8000.0));
        items.add(new Item("Barra libre", 2000.0));
        items.add(new Item("Vino", 500.0));
        items.add(new Item("Champagne", 700.0));
        items.add(new Item("Torta", 1000.0));
        items.add(new Item("Animación de la boda y DJ", 1500.0));
        items.add(new Item("Ceremonia:", 3000.0));
        items.add(new Item("Invitaciones", 500.0));
        items.add(new Item("Alianzas", 2000.0));
        items.add(new Item("Servicio de Video y Fotografía", 2500.0));

        // Imprimir la lista
        for (Item item : items) {
            System.out.println("Nombre: " + item.getNombre() + ", Precio: " + item.getPrecio());
        }
        
        ItemsPresupuestoDAO.saveItems(items);
        
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
