package uk.co.ranaldo.javaeeplayground.javamail;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.*;
import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.naming.*;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public class JavaMailExampleBackingBean {

    private Address email;

    private String content;
    
    @Resource(lookup = "java:comp/env/mail/testEmail")
    Session session;

    public String send() {
        try {
            Message message = new MimeMessage(session);
            message.setSubject("Email From Examples");
            message.setRecipient(Message.RecipientType.TO, email);
            message.setText(content);
            Transport emailTransport = session.getTransport();
            emailTransport.connect(session.getProperty("user"), session.getProperty("password"));
            emailTransport.sendMessage(message, message.getAllRecipients());
            return "Successful";
        } catch (MessagingException ex) {
//            Logger.getLogger(JavaMailExampleBackingBean.class.getName()).log(Level.SEVERE, null, ex);
            return "Failure";
        }
    }

    public Address getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            this.email = new InternetAddress(email);
        } catch (AddressException ex) {
            Logger.getLogger(JavaMailExampleBackingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
