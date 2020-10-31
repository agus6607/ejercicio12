package py.edu.facitec.controller;


import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat;

import py.edu.facitec.model.Agenda;
import py.edu.facitec.repository.AgendaRepository;





//todos los metodos contenidos a esta clase solisitara a esta solisitud
@RequestMapping("/agenda")

@RestController

public class AgendaController {
	//inyeccion de independencia
	@Autowired
	private AgendaRepository agendaRepository;
	
	@GetMapping
	private List<Agenda>getAgendas(){
		
		System.out.println("listando todos los agenda");
		
		return agendaRepository.findAll();
		
	}
	//suscritos/3
	@GetMapping(value = "/{codigo}")
	public Optional<Agenda>getAgenda(@PathVariable long codigo){
		
	Optional<Agenda> retorno =agendaRepository.findById(codigo);
	
	System.out.println("esta presente? "+retorno.isPresent());
	
	return retorno;
		
	}
	//suscrito GET
	//suscrito/3 GET
	//suscrito POST
	//suscrito/eliminar/3 DELETE
	
	@PostMapping //JSON --> JAVA
	public Agenda  guardarAgenda(@RequestBody Agenda agenda) {
	
	Agenda retorno=agendaRepository.save(agenda);
	
	System.out.println("Registro Correcto "+retorno);
		
	return	retorno;
	
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public void eliminarAgenda(@PathVariable long codigo) {
		
		System.out.println("El ID a eliminar "+codigo);
		
		agendaRepository.deleteById(codigo);
		}
	
	
	
	
	
	
	public String metodo() {
		
		
		return "agenda/inicio";
	}
	@RequestMapping(value = "/registrar_agenda", method= RequestMethod.POST)
	
	//nombre y correo
	//resibe los datos del formulario
	
	public ModelAndView registrar(Agenda agenda) {
		//registra suscrito
		agendaRepository.save(agenda);
		
		System.out.println("Registrado con exito "+agenda);
		
		
		return new ModelAndView("redirect:form_agenda");
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate fecha;
}
