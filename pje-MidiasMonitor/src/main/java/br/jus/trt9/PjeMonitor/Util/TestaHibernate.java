package br.jus.trt9.PjeMonitor.Util;

import javax.persistence.EntityManager;

import br.jus.trt9.PjeMonitor.Model.Client;

public class TestaHibernate {
	
	
	public static void main(String[] args) {
		
	Client client = new Client("cta123", "23 vt"); 
		
		EntityManager manager = new JpaUtil().getEntityManager();
		
		
		manager.getTransaction().begin();
		
		manager.persist(client);
		
		manager.getTransaction().commit();
		
		manager.close();
		
				
	}
}
