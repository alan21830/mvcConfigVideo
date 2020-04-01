package configMVC.configuration;



import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import configMVC.controller.HomeController;
import configMVC.model.Countries;
import configMVC.model.StoricoCasi;
import configMVC.repository.StoricoRepositoryJPA;
import configMVC.services.EmailService;

@Configuration
@EnableAsync
@EnableScheduling

public class QuarzConfiguration {

	private final Logger logger = LoggerFactory.getLogger(QuarzConfiguration.class);

	@Autowired
	StoricoRepositoryJPA storicoRepositoryJPA;

	@Autowired
	EmailService emailService;

	@Bean
	public JavaMailSender getJavaMailSender() 
	{
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(25);

		mailSender.setUsername("alessandrolaselva@gmail.com");
		mailSender.setPassword("9MAGGIo80znttvbznttvbznttvb");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	@Bean
	public SimpleMailMessage emailTemplate()
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("a0000@live.com");
		message.setFrom("alessandrolaselva@gmail.com");
		message.setText("FATAL - Application crash. Save your job !!");
		return message;
	}

 

	@Scheduled(cron = "0 10 22 1/1 * *")
	public void doSomething() throws MessagingException {
		// something that should execute periodically
		
		String htmlTable= "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				" <head>\r\n" + 
				"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
				"  <title>Demystifying Email Design</title>\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n" + 
				"</head>"+
				"<body>"
				
				+ "<table style=\"width:100%\">\r\n" + 
				"  <tr>\r\n" + 
				"    <th>country</th>\r\n" + 
				"    <th>cases</th>\r\n" + 
				"    <th>todayCases</th>\r\n" + 
				"<th>deaths</th>\r\n" + 
				"<th>todayDeaths</th>\r\n" + 
				"<th>recovered</th>\r\n" + 
				"<th>active</th>\r\n" + 
				"<th>critical</th>\r\n" + 

				"  </tr>\r\n" + 
				"  <tr>\r\n" + 
				"    <td>COUNTRY</td>\r\n" + 
				"    <td>CASES</td>\r\n" + 
				"    <td>TODAYC</td>\r\n" + 
				"    <td>DEATHS</td>\r\n" + 
				"    <td>TDEA</td>\r\n" + 
				"    <td>RECOVERED</td>\r\n" + 
				"    <td>ACTIVE</td>\r\n" + 
				"    <td>CRITICAL</td>\r\n" + 
				
				"  </tr>\r\n" + 
			     "</table>"+
				"</body>\r\n" + 
			 "</html>";
		
		logger.info("Start task :"+ new Date());
		System.out.println(new Date()+"Start scheduler send email + save todayCase ");
		StoricoCasi storicoCasi = new StoricoCasi();

		HomeController h= new HomeController();
		Gson gson = new Gson();
		String response = h.execute();
		ArrayList<Countries> listcovid = gson.fromJson(response, new TypeToken<ArrayList<Countries>>() {}.getType());
		Countries countries = listcovid.get(1);
		storicoCasi.setData(new Date());
		storicoCasi.setCasiOggi(countries.getTodayCases());
		storicoRepositoryJPA.save(storicoCasi);
		
		htmlTable=htmlTable.replace("COUNTRY", countries.getCountry());
		htmlTable=htmlTable.replace("CASES", String.valueOf(countries.getCases()));
		htmlTable=htmlTable.replace("TODAYC", String.valueOf(countries.getTodayCases()));
		htmlTable=htmlTable.replace("DEATHS", String.valueOf(countries.getDeaths()));
		htmlTable=htmlTable.replace("TDEA", String.valueOf(countries.getTodayDeaths()));
		htmlTable=htmlTable.replace("RECOVERED", String.valueOf(countries.getRecovered()));
		htmlTable=htmlTable.replace("ACTIVE", String.valueOf(countries.getActive()));
		htmlTable=htmlTable.replace("CRITICAL", String.valueOf(countries.getCritical()));
		
		emailService.sendMail("a0000@live.it", "scheduled email", htmlTable);

	}


}
