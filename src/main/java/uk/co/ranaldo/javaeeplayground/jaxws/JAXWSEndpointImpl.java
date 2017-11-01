package uk.co.ranaldo.javaeeplayground.jaxws;

import javax.jws.WebService;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@WebService
public class JAXWSEndpointImpl implements JAXWSEndpoint {

    @Override
    public String helloWorld() {
        return "Hello World";
    }

    @Override
    public String advancedHelloWorld(String name) {
        return "Hello " + name + ", this is world.";
    }
    
}