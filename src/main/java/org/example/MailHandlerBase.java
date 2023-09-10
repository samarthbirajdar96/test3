package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Configuration
public class MailHandlerBase {
       @Bean
    public void sendMail()
    {

        //properties

        //something like a map
        Properties sysPropertiesMap = System.getProperties();

        //System.out.println(sysPropertiesMap);

        //in this map I want to add 4 more key value pairs : mailing

        sysPropertiesMap.put("mail.smtp.host","smtp.gmail.com"); //smtp server
        sysPropertiesMap.put("mail.smtp.port","465"); //server port
        sysPropertiesMap.put("mail.smtp.ssl.enable","true"); //ssl -secure socket layer
        sysPropertiesMap.put("mail.smtp.auth","true"); //authentication - auth


        //authentication

        Authenticator mailAuthenticator = new CustomizedMailAuthenticator();


        //session
        Session mailSession = Session.getInstance(sysPropertiesMap,mailAuthenticator);


        //build the mail
        //Mime message

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            mailMessage.setFrom(MailConstants.SENDER);
            mailMessage.setSubject("WEEKLY TEST 3");
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("birajdarsamarth09@gmail.com"));
            mailMessage.setText("Hello i received this mail !!!");

            Transport.send(mailMessage);

            System.out.println("Mail sent !!!");
        }
        catch(Exception ex)
        {
            System.out.println("Some error while preparing mail body!!!!");
            System.out.println(ex.getMessage());
        }






    }
}