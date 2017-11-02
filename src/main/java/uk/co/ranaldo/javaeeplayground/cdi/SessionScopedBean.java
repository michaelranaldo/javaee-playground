package uk.co.ranaldo.javaeeplayground.cdi;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Named(value = "sessionScopedBean")
@SessionScoped
public class SessionScopedBean implements Serializable {

    private String data;
    
    private int count;

    /**
     * Creates a new instance of SessionScopedBean
     */
    public SessionScopedBean() {
    }

    public String getID() {
        return this + "";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
}
