package uk.co.ranaldo.javaeeplayground.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Stateless
public class FirstContactBean implements FirstContactBeanLocal {

    private final String greeting = "hello";
    
    @Override
    public String greeting() {
        System.out.println("hello");
        return greeting;
    }

    @Override
    public void updateGreeting() {
    }
}
