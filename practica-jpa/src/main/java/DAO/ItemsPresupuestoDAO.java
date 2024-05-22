package DAO;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelos.Item;

public class ItemsPresupuestoDAO {
	public static List<Item> getItems(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("practica-jpa");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		EntityManager manager = emf.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>)manager.createQuery("from Item").getResultList();
		return list;
	}
	

    public static void saveItems(List<Item> items) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager manager = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            for (Item item : items) {
                manager.persist(item); // Guardar cada item en la base de datos
            }

            transaction.commit(); // Confirmar la transacción
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Deshacer la transacción si hay errores
            }
            e.printStackTrace();
        } finally {
            manager.close(); // Cerrar el EntityManager
            emf.close(); // Cerrar el EntityManagerFactory
        }
    }
}
