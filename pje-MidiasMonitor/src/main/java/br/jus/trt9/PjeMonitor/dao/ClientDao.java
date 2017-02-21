package br.jus.trt9.PjeMonitor.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.jus.trt9.PjeMonitor.Model.Client;
import br.jus.trt9.PjeMonitor.Util.HibernateUtil;

//FIXME create the CRUD
public class ClientDao {
	
	public ClientDao() {
		
	}

	private static Session session = HibernateUtil.getSession();
	Transaction tx;
	
	
	public void salva(Client client) {
		
		tx = session.beginTransaction();
		session.save(client);
		tx.commit();
		session.close();
		
	}
	

}
