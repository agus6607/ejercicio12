package py.edu.facitec.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Contacto;
import py.edu.facitec.repository.ContactoRepository;



//todos los metodos contenidos en esta clase responderan a esta solicitud
@RequestMapping("/contacto")

//Arquitectura Rest
@RestController
public class ContactoController {

	@Autowired
	private ContactoRepository contactoRepository;
	
	@GetMapping
	public List<Contacto> getContactos(){
		System.out.println("LISTA DE TODOS LOS CONTACTOS");
		return contactoRepository.findAll();
	}
	
	@GetMapping(value = "/{codigo}")
	public Optional<Contacto> getContacto(@PathVariable Long codigo){
		
		
	Optional<Contacto>	retorno =	contactoRepository.findById(codigo);
		
	System.out.println("Esta presente? "+retorno.isPresent());

	return retorno;
	}
	
	@PostMapping //json --> spring --> java
	public Contacto guardarContacto(@RequestBody Contacto contacto) {
		
		Contacto retorno = contactoRepository.save(contacto);
		
		System.out.println("REGISTRO CORRECTO "+retorno );
		
		return retorno;
		
		
	}
	@DeleteMapping("/eliminar/{codigo}")
	public void eliminarContacto(@PathVariable Long codigo) {
		
		System.out.println("EL ID A ELIMINAR "+codigo);
		
		contactoRepository.deleteById(codigo);
		
	}

	
}
