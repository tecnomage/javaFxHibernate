package br.jus.trt9.PjeMonitor.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import br.jus.trt9.PjeMonitor.Model.Client;

@Repository
public class DaoClient extends GenericDao<Client>{
	
	public DaoClient() {
		setClazz(Client.class);
		
	}
	

}
