package br.jus.trt9.PjeMonitor.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

import org.hibernate.loader.custom.Return;

public class JpaUtil {
	
private static EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("pjemidias");
	
public EntityManager getEntityManager() {
	return entityManagerFactory.createEntityManager();
}

}
