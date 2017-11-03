package uk.co.ranaldo.javaeeplayground.ejb;

import javax.ejb.Local;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Local
public interface FirstContactBeanLocal {

    public String greeting();

    public void updateGreeting();
    
}
