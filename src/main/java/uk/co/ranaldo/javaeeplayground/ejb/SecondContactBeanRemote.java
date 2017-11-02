package uk.co.ranaldo.javaeeplayground.ejb;

import javax.ejb.Remote;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Remote
public interface SecondContactBeanRemote {

    public String greeting();
    
    public String response(String request);
    
    public void changeResponse(String newResponse);
    
}
