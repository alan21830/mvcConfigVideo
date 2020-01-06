package configMVC.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
			
			label+=("'"+utenti.getQty()+"',");
			data+=(utenti.getQty()+",");
			}
			label = label.substring(0,label.length()-1);
			 data = data.substring(0,data.length()-1);
			 
			 model.addAttribute("label", label);
			 model.addAttribute("data", data);
		model.addAttribute("listautenti",users);
		
		return "home";
	}
	@GetMapping("/inserisci")
	public String inserisci(Model model)
	{
		model.addAttribute("utente", new Utenti());
		return "inserisci";
	}
	@PostMapping("/inserisciUtente")
	public String insert(@ModelAttribute("utente") Utenti utenti ,Model model )
	{
		
		String sr;
		
		//utentiRepository.inserisci(utenti.username,utenti.password,utenti.qty);
		utentiServices.inserisci(utenti);
		return "redirect:/";
	}
	@GetMapping("/elimina")
	public String elimina(@RequestParam("id")int id ,Model model)
	{
	utentiServices.elimina(id);
	
	return "redirect:/";
	}
	@GetMapping("/modifica/{id}")
	public String modifica(@PathVariable("id") int id,Model model)
	{
		
		model.addAttribute("utente",utentiServices.findById(id));
		return "modifica";
	}
	@PostMapping("/modifica")
	public String modifica(@ModelAttribute("utente") Utenti utenti ,Model model )
	{
		
		String sr;
		
		utentiServices.inserisci(utenti);
		//utentiRepository.modifica(utenti);
		
		return "redirect:/";
	}
	@GetMapping("/find")
	public String cerca(Model model,HttpServletRequest request)
	{
		
		List<Utenti> users= new ArrayList<Utenti>();
		
		String label = "";
		String data = "";
		String messaggio = request.getParameter("filter");
		users = utentiServices.findByContaining(messaggio);
		if(users.size()==0)
		{
			 model.addAttribute("label", label);
			 model.addAttribute("data", data);
		//model.addAttribute("listautenti",users);
		
		return "home";
		}
				for (Utenti utenti : users) {
					
				 	label+=("'"+utenti.getQty()+"',");
					data+=(utenti.getQty()+",");
					}
					label = label.substring(0,label.length()-1);
					 data = data.substring(0,data.length()-1);
					 
					 model.addAttribute("label", label);
					 model.addAttribute("data", data);
				model.addAttribute("listautenti",users);
				
				return "home";
	}
	
	//SELECT * FROM `utenti` WHERE PASSWORD LIKE '%bellissima%
	
}
