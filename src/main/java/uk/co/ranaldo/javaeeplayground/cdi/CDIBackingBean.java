package uk.co.ranaldo.javaeeplayground.cdi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Named(value = "cdiBackingBean")
@RequestScoped
@ManagedBean
public class CDIBackingBean {

    @Inject
    ConversationScopedBean conBean;

    @Inject
    ApplicationScopedBean appBean;

    @Inject
    DependentScopedBean depBean;

    @Inject
    RequestScopedBean reqBean;

    @Inject
    SessionScopedBean sesBean;

    @Inject
    BeanCounter beanCounter;   

    public void onload() {
        updateBeanCount();
        ExternalContext exContext = FacesContext.getCurrentInstance().getExternalContext();
        checkParams(exContext.getRequestParameterValuesMap().get("chosenBean"), exContext.getRequestParameterMap().get("beanValue"));
    }

    public CDIBackingBean() {
    }

    private void updateBeanCount() {
        if (beanCounter.getOldDepBeanID() == null) {
            beanCounter.setOldDepBeanID(depBean.getID());
        } else if (!depBean.getID().equals(beanCounter.getOldDepBeanID())) {
            beanCounter.setDepBeanCount(beanCounter.getDepBeanCount() + 1);
            depBean.setCount(beanCounter.getDepBeanCount());
        }

        if (beanCounter.getOldAppBeanID() == null) {
            beanCounter.setOldAppBeanID(appBean.getID());
        } else if (!appBean.getID().equals(beanCounter.getOldAppBeanID())) {
            beanCounter.setAppBeanCount(beanCounter.getAppBeanCount() + 1);
            appBean.setCount(beanCounter.getAppBeanCount());
        }

        if (beanCounter.getOldSesBeanID() == null) {
            beanCounter.setOldSesBeanID(sesBean.getID());
        } else if (!sesBean.getID().equals(beanCounter.getOldSesBeanID())) {
            beanCounter.setSesBeanCount(beanCounter.getSesBeanCount() + 1);
            sesBean.setCount(beanCounter.getSesBeanCount());
        }

        if (beanCounter.getOldReqBeanID() == null) {
            beanCounter.setOldReqBeanID(reqBean.getID());
        } else if (!reqBean.getID().equals(beanCounter.getOldReqBeanID())) {
            beanCounter.setReqBeanCount(beanCounter.getReqBeanCount() + 1);
            reqBean.setCount(beanCounter.getReqBeanCount());
        }

        if (beanCounter.getOldConBeanID() == null) {
            beanCounter.setOldConBeanID(conBean.getID());
        } else if (!conBean.getID().equals(beanCounter.getOldConBeanID())) {
            beanCounter.setConBeanCount(beanCounter.getConBeanCount() + 1);
            conBean.setCount(beanCounter.getConBeanCount());
        }

        beanCounter.setOldDepBeanID(depBean.getID());
        beanCounter.setOldAppBeanID(appBean.getID());
        beanCounter.setOldSesBeanID(sesBean.getID());
        beanCounter.setOldReqBeanID(reqBean.getID());
        beanCounter.setOldConBeanID(conBean.getID());
    }
    
    

    public void checkParams(String[] chosenBeans, String value) {
        if (chosenBeans != null) {
            for (String s : chosenBeans) {
                switch (s) {
                    case "app":
                        appBean.setData(value);
                        break;
                    case "req":
                        reqBean.setData(value);
                        break;
                    case "ses":
                        sesBean.setData(value);
                        break;
                    case "con":
                        conBean.setData(value);
                        break;
                    case "dep":
                        depBean.setData(value);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void refreshPage() {
        ExternalContext exContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            exContext.redirect(((HttpServletRequest) exContext.getRequest()).getRequestURI());
        } catch (IOException ex) {
            Logger.getLogger(CDIBackingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void endSession() {
        ExternalContext exContext = FacesContext.getCurrentInstance().getExternalContext();
        exContext.invalidateSession();
    }

    public ConversationScopedBean getConBean() {
        return conBean;
    }

    public ApplicationScopedBean getAppBean() {
        return appBean;
    }

    public DependentScopedBean getDepBean() {
        return depBean;
    }

    public RequestScopedBean getReqBean() {
        return reqBean;
    }

    public SessionScopedBean getSesBean() {
        return sesBean;
    }

    public BeanCounter getHistoryBean() {
        return beanCounter;
    }

    public void setConBean(ConversationScopedBean conBean) {
        this.conBean = conBean;
    }

    public void setAppBean(ApplicationScopedBean appBean) {
        this.appBean = appBean;
    }

    public void setDepBean(DependentScopedBean depBean) {
        this.depBean = depBean;
    }

    public void setReqBean(RequestScopedBean reqBean) {
        this.reqBean = reqBean;
    }

    public void setSesBean(SessionScopedBean sesBean) {
        this.sesBean = sesBean;
    }

    public void setHistoryBean(BeanCounter historyBean) {
        this.beanCounter = historyBean;
    }
}
