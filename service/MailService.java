package com.united.gan.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.united.gan.model.User;
import com.united.gan.utils.Constants;

@Service
public class MailService {
	
	@Autowired
    private JavaMailSender sender;
	
	public String sendMail(User user, String heading) {
    	String toMailID = user.getEmailId();
    	String text = "You have requested your user name and password for the your access to the Human Face Generator Portal:\n" 
    	+ "UserName : " + user.getEmailId() + " \nPassword: " + user.getPassword()+ "\nPlease contact the United team if you have any questions.\n" + 
    			"Thank you\n" + 
    			"United Team.\n";
    	try {
          sendEmailWithUserNamePassword(toMailID, text, heading);
          return Constants.mailSuccess;
      }catch(Exception ex) {
          return Constants.mailError+ex;
      }
    }
    
    
    private void sendEmailWithUserNamePassword(String toMailID, String text, String heading) throws MessagingException {
    	MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(toMailID);
        helper.setText(text);
        helper.setSubject(heading); 
        sender.send(message);
	}
}

