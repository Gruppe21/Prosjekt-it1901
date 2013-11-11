package it1901g21;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {

    public static void sendMail(String farmer_mail, String farmer_name, String timestamp, String sheepId, String sheepX, String sheepY) {

        final String username = "g21.sheepalert@gmail.com";
        final String password = "imsdallomper";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(farmer_mail));					//mail-addresse til mottaker
            message.setSubject("ALARM! Your sheep is under attack!!!");			
            message.setText(farmer_name									//innhold i mailen
                + "\n\n Din sau "+sheepId+" er angrepet "+timestamp+"!"
                + "\n\n https://maps.google.com/maps/api/staticmap?size=300x300&maptype=roadmap&sensor=false&markers=color:red%7C"+sheepX+","+sheepY);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
