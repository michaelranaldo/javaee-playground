package uk.co.ranaldo.javaeeplayground.cdi;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Named(value = "applicationScopedBean")
@ApplicationScoped
public class ApplicationScopedBean {

    private String data;
    private int count;

    /**
     * Creates a new instance of ApplicationScopedBean
     */
    public ApplicationScopedBean() {
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
