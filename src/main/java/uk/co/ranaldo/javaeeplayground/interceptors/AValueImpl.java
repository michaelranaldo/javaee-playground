package uk.co.ranaldo.javaeeplayground.interceptors;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public class AValueImpl implements AValue {
    private String value;
    
    public AValueImpl() {
        value = "Payara";
    }
    
    @Override
    public String getValue() {
        return value;
    }
    
}
