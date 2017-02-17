package br.jus.trt9.PjeMonitor.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.jus.trt9.PjeMonitor.Model.Client;

@Repository
public interface ClientDao extends CrudRepository<Client, Integer>{

}
