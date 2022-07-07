package mx.com.warache.mvc.db.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mx.com.warache.mvc.entities.Cliente;
import mx.com.warache.mvc.entities.DetalleCliente;

public class HibernateRegistroApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetalleCliente.class)
				.buildSessionFactory();
		Session session = factory.openSession();

		Cliente cliente = new Cliente("Mamarre", "Yopihuactle","San Juan 13");
		DetalleCliente detalleCliente = new DetalleCliente("mamarre.com","55555555","Comentario 4");
		cliente.setDetalleCliente(detalleCliente);
		
		try {
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
			System.out.println("Cliente y detalles registrados!");

		} catch (HibernateException e) {
			// TODO: handle exception
		}finally {
			session.close();
			factory.close();}
	}

}
