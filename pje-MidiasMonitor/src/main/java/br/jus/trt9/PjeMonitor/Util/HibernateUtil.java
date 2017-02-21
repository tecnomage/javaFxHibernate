package br.jus.trt9.PjeMonitor.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.jus.trt9.PjeMonitor.Model.Client;

public class HibernateUtil {

	
//	public static void main(String[] args) {
//		
//		Session session = getSession();
//		Transaction tx = session.beginTransaction();
//		
//		
//		Client client = new Client("123", "18 vt");
//		session.save(client);
//		
//		tx.commit();
//		session.close();
//		
//		
//	}
	
	
	
	
	public static Session getSession() {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().addAnnotatedClass(Client.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		// Transaction tx = session.beginTransaction();
		return session;

	}

	/*
	 * private static Configuration getConfiguration() { Configuration cfg = new
	 * Configuration(); cfg.addAnnotatedClass(Client.class);
	 * cfg.setProperty("hibernate.connection.driver_class",
	 * "org.postgresql.Driver"); cfg.setProperty("hibernate.connection.url",
	 * "jdbc:postgresql://127.0.0.1:5432/testdb");
	 * cfg.setProperty("hibernate.connection.username", "postgres");
	 * cfg.setProperty("hibernate.connection.password", "postgres");
	 * cfg.setProperty("hibernate.show_sql", "true");
	 * cfg.setProperty("hibernate.dialect",
	 * "org.hibernate.dialect.PostgreSQLDialect");
	 * cfg.setProperty("hibernate.hbm2ddl.auto", "update");
	 * cfg.setProperty("hibernate.cache.provider_class",
	 * "org.hibernate.cache.NoCacheProvider");
	 * cfg.setProperty("hibernate.current_session_context_class", "thread"); //
	 * - See more at: //
	 * http://www.devx.com/Java/Article/48193/0/page/2#sthash.bc68RjSm.dpuf
	 * return cfg; }
	 */

}
