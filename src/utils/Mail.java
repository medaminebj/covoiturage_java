package utils;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author zemni ahmed amine
 */
public class Mail extends Exception {

                final String username = "oussama.benhenda@esprit.tn";
		final String password = "loveamerica66";
                Message message;

    public Mail(String mail) throws Exception{
                Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");


		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
            @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
               try {

			message = new MimeMessage(session);
			message.setFrom(new InternetAddress("oussama.benhenda@esprit.tn"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mail));
			message.setSubject("Flux RSS");
			/*message.setText("Bienvenue "+mail+" ");
			Transport.send(message);*/
			System.out.println("Done");



		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

    }

    public void SetContenuMail(String contenu){
        try {
            message.setText(contenu);

        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void envoyerMail(){
        try {
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}