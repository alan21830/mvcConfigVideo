package configMVC.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import configMVC.model.Utenti;
import configMVC.repository.UtentiRepository;
import configMVC.services.UtentiServices;
 

@Controller
public class HomeController {

	@Autowired
	UtentiRepository utentiRepository;
	
	@Autowired
	UtentiServices utentiServices;
	
	
	@RequestMapping(value="/")
	public String home(Model model)
	{
		String label ="";
		String data="";
		//List<Utenti> users = utentiRepository.getUtenti();
		List<Utenti> users =utentiServices.findAll();
		for (Utenti utenti : users) {
			
			label+=("'"+utenti.getUsername()+"',");
			data+=(utenti.getQty()+",");
			}
			label = label.substring(0,label.length()-1);
			 data = data.substring(0,data.length()-1);
			 
			 model.addAttribute("label", label);
			 model.addAttribute("data", data);
		model.addAttribute("listautenti",users);
		
		return "home";
	}
	public String inserisci(Model model)
	{
		model.addAttribute("utente", new Utenti());
		return "inserisci";
	}
	public String insert(@ModelAttribute("utente") Utenti utenti ,Model model )
	{
		
		String sr;
		
		utentiRepository.inserisci(utenti.username,utenti.password,utenti.qty);
		
		return "redirect:/";
	}
	public String elimina(@RequestParam("id")int id ,Model model)
	{
	utentiRepository.elimina(id);
	
	return "redirect:/";
	}
	@GetMapping("/modifica/{id}")
	public String modifica(@PathVariable("id") int id,Model model)
	{
		
		model.addAttribute("utente",utentiRepository.findbyId(id));
		return "modifica";
	}
	public String modifica(@ModelAttribute("utente") Utenti utenti ,Model model )
	{
		
		String sr;
		
		utentiRepository.modifica(utenti);
		
		return "redirect:/";
	}
	
	
	
	
}
