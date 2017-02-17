package br.jus.trt9.PjeMonitor.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao<T extends Serializable> {

	private Class<T> clazz;

	@PersistenceContext
	EntityManager manager;

	public final void setClazz( Class<T> clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	
	public void save(T entity) {
		manager.persist(entity);
	}
}
