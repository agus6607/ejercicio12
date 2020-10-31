package py.edu.facitec.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Contacto extends General{

	private String nombre;
	private Integer numero;
	@JsonBackReference(value = "variableRelacionCS")
	@ManyToOne
	private Agenda agenda;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	
	
	}
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", numero=" + numero + ", agenda=" + agenda + "]";
	}
	
	
	
	
	
}
