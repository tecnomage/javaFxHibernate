package br.jus.trt9.PjeMonitor;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.jus.trt9.PjeMonitor.Model.Client;

/*TODO essa classe deve implementar o CrudRepository
que vem do spring-DATA-core
*/
@Repository
public interface ClientRepo extends CrudRepository<Client, Serializable>{
	
}
