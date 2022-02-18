package com.example.Project.Utility;

import java.util.Properties;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	
	public static void sendMail(String userEmail) {
		System.out.println("Starting mailtrigger");
		Properties p=new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", 587);
		
		String myAcc="Abc@gmail.com";
		String password="Abc@123abc";
		
		Session session =Session.getInstance(p, new Authenticator() {
			@Override
			protected PasswordAuthentication  getPasswordAuthentication() {
				return new PasswordAuthentication(myAcc, password);
			}		
		});
		
		try {
			Message message=new MimeMessage(session);
			message.setFrom( new InternetAddress(myAcc));
			message.setRecipient(Message.RecipientType.TO , new InternetAddress(userEmail));
			message.setSubject("TaskManager Registration");
			message.setText("Hey there!, \\n You have successfully registered into taskmanager. \\n Thankyou ....:D");
			Transport.send(message);
			System.out.println("Email sent successfully");
			
		}catch(Exception e) {
			System.out.println("Error occured while triggering mail"+e);
		}
	
	}
	
	

}
