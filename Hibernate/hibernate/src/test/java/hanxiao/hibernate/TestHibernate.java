package hanxiao.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestHibernate {
	
	@Test
	public void insert() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Product product = new Product();
		product.setName("apple");
		product.setPrice(10);
		session.save(product);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	@Test
	public void jdbc() throws Throwable {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hibernate?characterEncoding=UTF-8";
		String username = "root";
		String password = "root";
		Connection conn = (Connection) DriverManager.getConnection(url, username, password);
		
		Statement statement = conn.createStatement();
		ResultSet rst = statement.executeQuery("select * from product");
		rst.close();
	}

}
