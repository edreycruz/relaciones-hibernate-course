package mx.com.warache.mvc.db.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mx.com.warache.mvc.entities.Cliente;
import mx.com.warache.mvc.entities.DetalleCliente;

public class HibernateEliminacionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetalleCliente.class)
				.buildSessionFactory();

		System.out.println("Eliminando cliente...");
		try (Session session = factory.openSession();) {

			session.beginTransaction();

			Cliente cliente = session.get(Cliente.class, 1);

			if (cliente != null) {
				session.delete(cliente);
				System.out.println("Cliente eliminado!");
			}
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
