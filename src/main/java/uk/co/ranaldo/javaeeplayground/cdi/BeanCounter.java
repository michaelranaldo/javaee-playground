package uk.co.ranaldo.javaeeplayground.cdi;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Named(value = "beanCounter")
@ApplicationScoped
public class BeanCounter {

    private int appBeanCount;
    private int sesBeanCount;
    private int reqBeanCount;
    private int depBeanCount;
    private int conBeanCount;
    
    private String oldAppBeanID;
    private String oldSesBeanID;
    private String oldReqBeanID;
    private String oldDepBeanID;
    private String oldConBeanID;
    

    /**
     * Creates a new instance of HistoryBean
     */
    public BeanCounter() {
    }

    public int getAppBeanCount() {
        return appBeanCount;
    }

    public void setAppBeanCount(int appBeanCount) {
        this.appBeanCount = appBeanCount;
    }

    public int getSesBeanCount() {
        return sesBeanCount;
    }

    public void setSesBeanCount(int sesBeanCount) {
        this.sesBeanCount = sesBeanCount;
    }

    public int getReqBeanCount() {
        return reqBeanCount;
    }

    public void setReqBeanCount(int reqBeanCount) {
        this.reqBeanCount = reqBeanCount;
    }

    public int getDepBeanCount() {
        return depBeanCount;
    }

    public void setDepBeanCount(int depBeanCount) {
        this.depBeanCount = depBeanCount;
    }

    public int getConBeanCount() {
        return conBeanCount;
    }

    public void setConBeanCount(int conBeanCount) {
        this.conBeanCount = conBeanCount;
    }

    public String getOldAppBeanID() {
        return oldAppBeanID;
    }

    public void setOldAppBeanID(String oldAppBeanID) {
        this.oldAppBeanID = oldAppBeanID;
    }

    public String getOldSesBeanID() {
        return oldSesBeanID;
    }

    public void setOldSesBeanID(String oldSesBeanID) {
        this.oldSesBeanID = oldSesBeanID;
    }

    public String getOldReqBeanID() {
        return oldReqBeanID;
    }

    public void setOldReqBeanID(String oldReqBeanID) {
        this.oldReqBeanID = oldReqBeanID;
    }

    public String getOldDepBeanID() {
        return oldDepBeanID;
    }

    public void setOldDepBeanID(String oldDepBeanID) {
        this.oldDepBeanID = oldDepBeanID;
    }

    public String getOldConBeanID() {
        return oldConBeanID;
    }

    public void setOldConBeanID(String oldConBeanID) {
        this.oldConBeanID = oldConBeanID;
    }
    
    
}
