package uk.co.ranaldo.javaeeplayground.interceptors;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Named
@ManagedBean
@RequestScoped
public class HackyLogger {
    private String log = "";

    public void append(String text) {
        log += text;
        System.out.println(text);
    }
    
    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
