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

import GUI.ErrorMessage;

/**
 * 
 * @author Jango
 *	Has same function as SendMail, only this one is designed for the contact to recieve.
 */
public class Contact_SendMail {

    public Contact_SendMail(String farmer_mail, String farmer_name, String timestamp, String sheepId, String sheepX, String sheepY) {

        final String username = "g21.sheepalert@gmail.com";			//mailadressen som sender mail
        final String password = "imsdallomper";						//passord

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
            message.setSubject("ALARM! An attack on a sheep in " + farmer_name + "'s sheep herd has occured!");			
            message.setText("Farmer " + farmer_name + " has had an attack on a sheep, Eartag ID: " + sheepId + "! \nAttack happened at "+timestamp+"!" + "\nPlease inform him immediately!"
                + "\n\n https://maps.google.com/maps/api/staticmap?size=300x300&maptype=satellite&sensor=false&markers=color:red%7Clabel:S%7C"+sheepX+","+sheepY);

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            ErrorMessage errorMsg = new ErrorMessage("","Invalid E-mail!");
        }
    }
}
