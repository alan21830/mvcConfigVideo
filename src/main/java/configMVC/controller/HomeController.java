package configMVC.controller;

import java.util.List;
 
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONArray;
import org.json.JSONObject;
 
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import configMVC.model.Countries;
import configMVC.model.StoricoCasi;
import configMVC.model.Utenti;
import configMVC.repository.StoricoRepositoryJPA;
import configMVC.repository.UtentiRepository;
import configMVC.services.UtentiServices;
import configMVC.services.storicoService;
 

@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UtentiRepository utentiRepository;
	
	@Autowired
	UtentiServices utentiServices;
  
	
	@Autowired storicoService storicoService;
	
	@RequestMapping(value="/")
	public String home(Model model)
	{
		String label ="";//torta
		String data="";
		String labelLine="";
		String dataLine="";
		String storicoFilter = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
		Date date = new Date();
		int day = date.getDate();
		 
		int i=0;
		int j=0;
		
		for(j = 1 ; j< 32; j++)
		{
			Date dateMarzo = new Date(date.getYear(),02,j);
			dataLine+=("'"+formatter.format(dateMarzo)+"',");
			try {
				storicoFilter =String.valueOf(storicoService.findByData(dateMarzo).getCasiOggi());
			
			
			
			}catch (Exception e) {
				labelLine+="'"+""+"',";
			}
			labelLine+="'"+storicoFilter+"',";
		}
		//aprile
		if(date.getMonth()==3 ) {
		for (i = 1; i <day ; i++)
		{
			StoricoCasi storico = null; 
			Date d = new Date(date.getYear(),date.getMonth(),i);
//			System.out.print("instanza date ===================" +new  Date());
//			System.out.print("data get Date ===================" +d);
			dataLine+=("'"+formatter.format(d)+"',");
			
			List<StoricoCasi> listStoricoCasis=storicoService.findAll();
			
			try {
			storicoFilter =String.valueOf(storicoService.findByData(d).getCasiOggi());
			//listStoricoCasis.stream().filter(st -> st.getData().equals(obj) ).collect(Collectors.toList());
			logger.info(storicoFilter);
			}catch (Exception e) {
				labelLine+="'"+""+"',";
			}
			labelLine+="'"+storicoFilter+"',";
			logger.info(labelLine);
		}
		}
		dataLine = dataLine.substring(0,dataLine.length()-1);
		labelLine.substring(0, labelLine.length()-1);
	//	dataLine=formatter.format(date);
		
		//List<Utenti> users = utentiRepository.getUtenti();
	//	List<Utenti> users =utentiServices.findAll();
		//for (Utenti utenti : users) {
//			
//			label+=("'"+utenti.getQty()+"',");
//			data+=(utenti.getQty()+",");
//			}
//			label = label.substring(0,label.length()-1);
//			 data = data.substring(0,data.length()-1);
//			 
//			 model.addAttribute("label", label);
//			 model.addAttribute("data", data);
			 
			 String response = execute();
			//	JSONArray jsonCovid = response.getJSONArray("country");
				Gson gson = new Gson(); 
		//		String json = jsonCovid.toString();
				ArrayList<Countries> listcovid = gson.fromJson(response, new TypeToken<ArrayList<Countries>>() {}.getType());
 	model.addAttribute("listacovid",listcovid);
	int totale=0;
	int decessi=0;
	int casiOggi=0;
 	for (Countries countries : listcovid) {
 		label+=("'"+countries.country+"',");
 		data+=(countries.cases+",");
 		totale += countries.cases;
 		decessi += countries.getDeaths();
 		casiOggi += countries.getTodayCases();
 	}
 	label = label.substring(0,label.length()-1);
	 data = data.substring(0,data.length()-1);
	 model.addAttribute("label", label);
  model.addAttribute("data", data);
  model.addAttribute("totale",totale);
  model.addAttribute("decessi",decessi);
  model.addAttribute("casiOggi",casiOggi);
  model.addAttribute("dataLine",dataLine);
  model.addAttribute("labelLine",labelLine);
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
	
	public String execute( )
			  {

		try {
			// Set the url path for the service
			URL url = new URL("https://coronavirus-19-api.herokuapp.com/countries");

			// Open connection
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			 
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);

		 

			// Retrieve the response
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}

			return  response.toString();

		} catch (Exception e) {
			 
		}
		return null;
	}
	
}
