package br.jus.trt9.PjeMonitor.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.repository.RepositoryDefinition;

/*@
 * classe que lista as máquinas 
que utilizam o fidelis*/
@Entity
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8490813267291292074L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String tombo;

	@Column
	private String vara;
	
	public Client() {
		
	}

	public Client(Integer id, String tombo, String vara) {
		super();
		this.id = id;
		this.tombo = tombo;
		this.vara = vara;
	}

	public Client(String tombo, String vara) {
		this.tombo = tombo;
		this.vara = vara;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTombo() {
		return tombo;
	}

	public void setTombo(String tombo) {
		this.tombo = tombo;
	}

	public String getVara() {
		return vara;
	}

	public void setVara(String vara) {
		this.vara = vara;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
