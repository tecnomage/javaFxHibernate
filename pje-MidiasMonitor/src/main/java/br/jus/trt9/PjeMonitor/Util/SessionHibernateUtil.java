package br.jus.trt9.PjeMonitor.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHibernateUtil {

	Configuration cfg = new Configuration();

	SessionFactory factory = cfg.buildSessionFactory();
	

}
