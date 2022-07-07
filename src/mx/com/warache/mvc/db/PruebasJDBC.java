package mx.com.warache.mvc.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/relacioneshibernate?useSSL=false";
		String user = "springcourse";
		String password = "springcourse";
		
		System.out.println("Conectando con la BD " + jdbcUrl);
		try(Connection conn = DriverManager.getConnection(jdbcUrl, user, password);) {
			System.out.println("¡Conexión exitosa!");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
