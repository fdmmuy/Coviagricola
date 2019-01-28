package uy.org.coviagricola.mail;

import java.util.Properties;

import javax.ejb.Asynchronous;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	@Asynchronous
	public void sendEmail(String aFromEmailAddr, String aToEmailAddr, String aSubject, String aBody) {

		System.out.println("Entro a enviar mail");
        Properties props = new Properties();
        
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.user", "fdmmuy@gmail.com");
		props.put("mail.smtp.pass", "F3rn@nd02e");
		// Habilitar Acceso de apps menos seguras
		// https://myaccount.google.com/lesssecureapps
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication( "fdmmuy@gmail.com","F3rn@nd02e");
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(aToEmailAddr));
			message.setSubject(aSubject);
			message.setFrom(aFromEmailAddr);
			message.setText(aBody);
			Transport.send(message);
			System.out.println("Mail enviado");


		} catch (MessagingException ex) {
			System.err.println("Cannot send email. " + ex);
		}


	}
}
