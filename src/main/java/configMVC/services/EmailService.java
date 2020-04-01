package configMVC.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
    private JavaMailSender mailSender;
      
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
    
    public void sendMail(String to, String subject, String body) throws MessagingException 
    {
    	
    	 MimeMessage messagem = mailSender.createMimeMessage();
    	 MimeMessageHelper helper;
    	 helper = new MimeMessageHelper(messagem, true);
    	 
         helper.setTo(to);
         helper.setText(body, true);
    	 
        mailSender.send(messagem);
	
}
    
    public void sendPreConfiguredMail(String message) 
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
    
}
