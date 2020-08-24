package configMVC.services;

import java.util.List;
import java.util.Optional;

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
	public void inserisci(Utenti utente)
	{
		utentiRepositoryJPA.save(utente);
	}
	public void elimina(int id)
	{
		 utentiRepositoryJPA.deleteById(id);
	}
	public Optional<Utenti> findById(int id)
	{
		return utentiRepositoryJPA.findById(id);
	}
	public List<Utenti> findByContaining(String messaggio)
	{
		
		return utentiRepositoryJPA.findByPasswordContaining(messaggio);
	}
}
