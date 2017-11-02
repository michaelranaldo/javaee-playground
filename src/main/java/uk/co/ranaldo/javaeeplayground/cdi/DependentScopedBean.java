package uk.co.ranaldo.javaeeplayground.cdi;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Named(value = "dependentScopedBean")
@Dependent
public class DependentScopedBean {

    private String data;
    
    private int count;

    /**
     * Creates a new instance of DependentScopedBean
     */
    public DependentScopedBean() {
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
