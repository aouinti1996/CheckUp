package utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author lotfi
 */
public class JavaMail 
{
    public static void sendMail(String recepient) throws MessagingException
    {
        Properties props = new Properties();
        
        System.out.println("Preparing send mail ");
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "*");
        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        String myAccountEmail = "lotfihammoudi308@gmail.com";
        String password = "lotfiesprit";
        
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message message = prepareMessage(session, myAccountEmail, recepient);
   
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient)
    {
        try
        {
         MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("evenement ajouter avec succee");
            message.setText("Hello World!!!");
            return message; 
        }
        catch(Exception e)
        {
            System.out.println("Erreur: " + e.getMessage());
        }      
        return null;
    }
    
}
