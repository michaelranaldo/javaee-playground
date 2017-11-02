package uk.co.ranaldo.javaeeplayground.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Named
public class CloseEncounterBean {

    @EJB // references the interface not the impl, as per
            // note that globals in same module can be referenced via @EJB too
    FirstContactBeanLocal firstContactBean;

    private String firstGreeting = "";

    private String secondGreeting = "";

    public void updateFirstGreeting() {
        firstGreeting = firstContactBean.greeting();
    }

    public void updateSecondGreeting() {
        SecondContactBeanRemote secondContactBean;
        try {
            // Start it up once the EJB is valid, then nick the location from the log 
            // From the boot log:
            // Info:   Portable JNDI names for EJB SecondContactBean: [java:global/JavaEE_Playground/SecondContactBean, java:global/JavaEE_Playground/SecondContactBean!uk.co.ranaldo.javaeeplayground.ejb.SecondContactBeanLocal]
            // See javadoc - included verbose version but you can omit e.g. application name, module name depending on context
            secondContactBean = (SecondContactBeanRemote) InitialContext.doLookup("java:global/JavaEE_Playground/SecondContactBean");
            secondGreeting = secondContactBean.greeting();
        } catch (NamingException ex) {
            secondGreeting = "shit";
            Logger.getLogger(CloseEncounterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFirstGreeting() {
        return firstGreeting;
    }

    public void setFirstGreeting(String firstGreeting) {
        this.firstGreeting = firstGreeting;
    }

    public String getSecondGreeting() {
        return secondGreeting;
    }

    public void setSecondGreeting(String secondGreeting) {
        this.secondGreeting = secondGreeting;
    }
}
