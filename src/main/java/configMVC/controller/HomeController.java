package configMVC.controller;

import java.util.List;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
import configMVC.services.StoricoService;
import configMVC.services.UtentiServices;


@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UtentiRepository utentiRepository;

	@Autowired
	UtentiServices utentiServices;


	@Autowired 
	StoricoService storicoService;

	@GetMapping(value="/" )
	public String home(Model model, @RequestParam(value = "page" ,defaultValue = "0") int page)//,HttpServletRequest request  )

	{
		//		System.out.println("request id ---------------------->"+request.getRemoteAddr());
		//		System.out.println("request id ---------------------->"+request.getAuthType());
		//		System.out.println("request id ---------------------->"+request.getContextPath());
		//		System.out.println("request id ---------------------->"+request.getHeader("HTTP_X_FORWARDED_FOR"));
		//		System.out.println("request id ---------------------->"+request.getHeader("Client-IP"));
		//		System.out.println("request id ---------------------->"+request.getHeader("X-Forwarded-For"));


		//@RequestParam (name = "page" , defaultValue ="1") int page

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

		List<StoricoCasi> sc = new ArrayList<>();
		sc= storicoService.findAll();

		for(j = 1 ; j< 32; j++)
		{
			Date dateMarzo = new Date(date.getYear()-1,02,j);
			dataLine+=("'"+formatter.format(dateMarzo)+"',");
			try {
				//storicoFilter =String.valueOf(storicoService.findByData(dateMarzo).getCasiOggi());
				storicoFilter =String.valueOf(
						sc.stream().filter(s->s.getData().compareTo(dateMarzo)==0)
						.collect(Collectors.toList()).get(0).casiOggi);


			}catch (Exception e) {
				labelLine+="'"+""+"',";
			}
			labelLine+="'"+storicoFilter+"',";
		}
		//aprile

		for (i = 1; i <31 ; i++)
		{
			StoricoCasi storico = null; 
			Date d = new Date(date.getYear()-1,03,i);
			//			System.out.print("instanza date ===================" +new  Date());
			//			System.out.print("data get Date ===================" +d);
			dataLine+=("'"+formatter.format(d)+"',");



			try {
				//storicoFilter =String.valueOf(storicoService.findByData(d).getCasiOggi());
				storicoFilter =String.valueOf(
						sc.stream().filter(s->s.getData().compareTo(d)==0)
						.collect(Collectors.toList()).get(0).casiOggi);

				
				//listStoricoCasis.stream().filter(st -> st.getData().equals(obj) ).collect(Collectors.toList());
				//	logger.info(storicoFilter);
			}catch (Exception e) {
				labelLine+="'"+""+"',";
			}
			labelLine+="'"+storicoFilter+"',";
			//	logger.info(labelLine);
		}
		//maggio
		for (int k =1 ; k < 31 ; k++ )
		{
			try {
				StoricoCasi storico = null; 
				Date d = new Date(date.getYear(),04,k);
				dataLine+=("'"+formatter.format(d)+"',");

				//storicoFilter =String.valueOf(storicoService.findByData(d).getCasiOggi());
				storicoFilter =String.valueOf(
						sc.stream().filter(s->s.getData().compareTo(d)==0)
						.collect(Collectors.toList()).get(0).casiOggi);
				labelLine+="'"+storicoFilter+"',";
			}catch (Exception e) {
				labelLine+="'"+""+"',";
			}
			labelLine+="'"+storicoFilter+"',";
		}
		//giugno
		for (int k =1 ; k < 31 ; k++ )
		{
			try {
				StoricoCasi storico = null; 
				Date d = new Date(date.getYear(),05,k);
				dataLine+=("'"+formatter.format(d)+"',");

				//storicoFilter =String.valueOf(storicoService.findByData(d).getCasiOggi());
				storicoFilter =String.valueOf(
						sc.stream().filter(s->s.getData().compareTo(d)==0)
						.collect(Collectors.toList()).get(0).casiOggi);
				labelLine+="'"+storicoFilter+"',";
			}catch (Exception e) {
				labelLine+="'"+""+"',";
			}
			labelLine+="'"+storicoFilter+"',";
		}
		//luglio
		for (int k =1 ; k < 32 ; k++ )
		{
			try {
				StoricoCasi storico = null; 
				Date d = new Date(date.getYear(),06,k);
				dataLine+=("'"+formatter.format(d)+"',");

			//	storicoFilter =String.valueOf(storicoService.findByData(d).getCasiOggi());
				
				storicoFilter =String.valueOf(
						sc.stream().filter(s->s.getData().compareTo(d)==0)
						.collect(Collectors.toList()).get(0).casiOggi);
				labelLine+="'"+storicoFilter+"',";
			}catch (Exception e) {
				labelLine+="'"+""+"',";
			}
			labelLine+="'"+storicoFilter+"',";
		}
		//agosto
		for (int k =1 ; k < day ; k++ )
		{
			try {
				StoricoCasi storico = null; 
				Date d = new Date(date.getYear(),07,k);
				dataLine+=("'"+formatter.format(d)+"',");

				//storicoFilter =String.valueOf(storicoService.findByData(d).getCasiOggi());
				
				storicoFilter =String.valueOf(
						sc.stream().filter(s->s.getData().compareTo(d)==0)
						.collect(Collectors.toList()).get(0).casiOggi);
				labelLine+="'"+storicoFilter+"',";
			}catch (Exception e) {
				labelLine+="'"+""+"',";
			}
		}

		dataLine = dataLine.substring(0,dataLine.length()-1);
		labelLine.substring(0, labelLine.length()-1);


		String response = execute();

		Gson gson = new Gson(); 

		ArrayList<Countries> listcovid = gson.fromJson(response, new TypeToken<ArrayList<Countries>>() {}.getType());

		listcovid = (ArrayList<Countries>) listcovid.stream().sorted(Comparator.comparingInt(Countries::getCases).reversed()).collect(Collectors.toList());



		List<StoricoCasi> listStoricoCasis=storicoService.findDistinct()
				.stream().sorted(Comparator.comparing(StoricoCasi::getData))
				.collect(Collectors.toList());

		Page<StoricoCasi> listaPaginata = storicoService.findPageSort(page, 30);
		List<StoricoCasi> listapaginatas= listaPaginata.getContent();
		int tot=listaPaginata.getTotalPages();




		int totale=0;
		int decessi=0;
		int casiOggi=0;
		for (Countries countries : listcovid) {
			label+=("'"+countries.country+"',");
			data+=(countries.cases+",");
			if(countries.getCountry().equals("World"))
			{
				totale+= 0;
				decessi+=0;
				casiOggi+=0;
			}
			else
			{
				totale += countries.cases;
				decessi += countries.getDeaths();
				casiOggi += countries.getTodayCases();
			}

		}

		StoricoCasi storicocasi = new StoricoCasi();
		model.addAttribute("page",page );
		model.addAttribute("tot",tot );
		model.addAttribute("listapaginatas",listapaginatas );
		model.addAttribute("listStoricocasis",listStoricoCasis );
		label = label.substring(0,label.length()-1);
		data = data.substring(0,data.length()-1);
		model.addAttribute("label", label);
		model.addAttribute("listacovid",listcovid);
		model.addAttribute("data", data);
		model.addAttribute("totale",totale);
		model.addAttribute("decessi",decessi);
		model.addAttribute("casiOggi",casiOggi);
		model.addAttribute("dataLine",dataLine);
		model.addAttribute("labelLine",labelLine);
		model.addAttribute("storicocasi",storicocasi);
		return "home";

	}

	@PostMapping("/inserisci")
	public String insert(@ModelAttribute("storicocasi") StoricoCasi sc ,Model model )
	{

		String sr;

		//utentiRepository.inserisci(utenti.username,utenti.password,utenti.qty);
		storicoService.insCaso(sc);
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
			con.addRequestProperty("User-Agent", "Mozilla");


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
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}
}
