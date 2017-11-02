package uk.co.ranaldo.javaeeplayground.interceptors;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public interface Greeting {
   boolean isConstructed();
   
   boolean isInitialised();
   
   AValue getAValue();
   
   public String sayHello(String value);
   
   public String customisedHello();
}
