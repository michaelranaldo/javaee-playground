package uk.co.ranaldo.javaeeplayground.interceptors;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Interceptor
@AnInterceptorBinding
public class BasicInterceptor {
    
    @Inject
    private HackyLogger logs;
    
    @AroundConstruct
    public Object onConstruct(InvocationContext context) throws Exception {
        logs.setLog(logs.getLog() + "\n[TIE] Intercepted " + context.getConstructor().getName());
        logs.setLog(logs.getLog() + "\n[TIE] If the intercepted class is injected, this method will be called when its context is started");
        
        // gets the instance of the target class which the interceptor caught
        // this will also be null right now, as it has not yet been created
        // this is created once we "context.proceed();"
        Object target = context.getTarget();
        isNull(target);
        
        // gets the method of the target instance which the interceptor caught
        // this will be null before construction
        // this is also null 'cause this is a constructor, not a "business method"
        Method method = context.getMethod();
        isNull(method);
        
        // gets the constructor of the target instance
        // at @AroundConstruct, this will not be null (how else would you create an instance)
        Constructor constructor= context.getConstructor();
        isNotNull(constructor);
        
        // We can now create the instance, as we have indeed verified that everything is as it should be
        logs.setLog(logs.getLog() + "\n[TIE] We will now proceed");
        Object result = context.proceed();
        
        // This is null as constructors return void - hence null, and there are no further interceptors
        isNull(result);
        
        
        // This has now been created so the instance exists
        // we have to call it again, cause it's just been crated
        target = context.getTarget();
        isNotNull(target);
        
        // the constructor will have been called
        GreetingImpl greetingBean = (GreetingImpl) target;
        isBoolean(greetingBean.isConstructed(), true);
        // but it's not yet initialised (not yet post construct)
        isBoolean(greetingBean.isInitialised(), false);
        
        // and the injection should have been finished
        isNotNull(greetingBean.getAValue());
        
        // Generally format seems to be return context.proceed, but as you can see it's
        // by no means a hard and fast rule
        logs.setLog(logs.getLog() + "\n[TIE] Finished with " + context.getConstructor().getName());
        return null;
    }
    
    
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        // We can also call the method on invocation
        // So here we will intercept any method which is called
        logs.setLog(logs.getLog() + "\n[TIE] Intercepted " + context.getMethod().getName());
        try
        {
            return context.proceed();
        } finally {
            logs.setLog(logs.getLog() + "\n[TIE] Interceptor Done");
        }
        
    }
    
    
    private static void isNull(Object o) throws Exception {
        if (o != null) {
            throw new IllegalStateException("This should be null");
        }
    }
    
    private static void isNotNull(Object o) throws Exception {
        if (o == null) {
            throw new IllegalStateException("This shouldn't be null");
        }
    }
    
    private static void isBoolean(Object o, Boolean value) throws Exception {
        if (!o.equals(value)) {
            throw new IllegalStateException("This should be " + value + ".");
        }
    }
}
