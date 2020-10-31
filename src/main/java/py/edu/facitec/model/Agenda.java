 package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Agenda {

	@Id
	@GeneratedValue
	private String usuario;
@JsonManagedReference(value = "variableRelacionCS")
@OneToMany(mappedBy = "agenda")
private List<Contacto> contacto;
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public List<Contacto> getContacto() {
	return contacto;
}
public void setContacto(List<Contacto> contacto) {
	this.contacto = contacto;
}
@Override
public String toString() {
	return "Agenda [usuario=" + usuario + ", contacto=" + contacto + "]";
}

	
	
	
	
	
	

	
	
	}
	
	

