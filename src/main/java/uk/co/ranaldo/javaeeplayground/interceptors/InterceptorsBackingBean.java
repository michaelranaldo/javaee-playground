/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.ranaldo.javaeeplayground.interceptors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Michael Ranaldo <michael.ranaldo@payara.fish>
 */
@Named("interceptorsBackingBean")
@RequestScoped
public class InterceptorsBackingBean {

    @Inject
    private Greeting bean;

    private String greeting = "";

    private String anotherMethodResult = "";

    @Inject
    private HackyLogger logs;
    
    private String log;

    public InterceptorsBackingBean() {
    }

    @PostConstruct
    public void post() {
        logs.setLog(logs.getLog() + "\n[BEAN] Backing Bean Init Finished");
        
    }

    public void generateHello() {
        greeting = bean.customisedHello();
    }

    public void runAnotherMethod() {
        logs.setLog(logs.getLog() + "\n[BEAN] Backing Bean Running Another Method");
        anotherMethodResult = bean.sayHello("Payara");
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getAnotherMethodResult() {
        return anotherMethodResult;
    }

    public void setAnotherMethodResult(String anotherMethodResult) {
        this.anotherMethodResult = anotherMethodResult;
    }

    public String getLog() {
        return logs.getLog();
    }

    public void setLog(String log) {
        this.log = log;
    }
    
    
}
