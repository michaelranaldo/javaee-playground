package uk.co.ranaldo.javaeeplayground.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@WebService
public interface JAXWSEndpoint {
    
    @WebMethod
    public String helloWorld();

    @WebMethod
    public String advancedHelloWorld(String name);
}

