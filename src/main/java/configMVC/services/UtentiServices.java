package configMVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import configMVC.model.Utenti;
import configMVC.repository.UtentiRepositoryJPA;

@Service
public class UtentiServices {

	@Autowired
	UtentiRepositoryJPA utentiRepositoryJPA;
	
	public List<Utenti> findAll()
	{
		return utentiRepositoryJPA.findAll();		
	}
	
}
