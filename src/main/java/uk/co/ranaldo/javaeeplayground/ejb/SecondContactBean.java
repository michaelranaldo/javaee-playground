package uk.co.ranaldo.javaeeplayground.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Stateless
public class SecondContactBean implements SecondContactBeanRemote {

    private String response = "Request does not conform to established norms";
    
    @Override
    public String greeting() {
        System.out.println("greetings");
        return "Greetings!";
    }

    @Override
    public String response(String request) {
        if (!request.equals("Take me to your leader"))  {
            return "Request does not conform to established norms";
        } else {
            return "We don't really have anyone that qualified";
        }
    }

    @Override
    public void changeResponse(String newResponse) {
        response = newResponse;
    }
}
