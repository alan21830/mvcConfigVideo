package configMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import configMVC.model.Utenti;

@Repository
public interface UtentiRepositoryJPA extends JpaRepository<Utenti, Integer> {

	 List<Utenti> findByPasswordContaining(String message);
	
}
