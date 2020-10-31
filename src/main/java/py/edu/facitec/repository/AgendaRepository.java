package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.facitec.model.Agenda; 



public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
