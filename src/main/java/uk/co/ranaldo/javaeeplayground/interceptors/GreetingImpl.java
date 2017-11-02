package uk.co.ranaldo.javaeeplayground.interceptors;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@AnInterceptorBinding
// Alternative
// @Interceptors({BasicInterceptor.class},{AnotherInterceptor.class},{AnotherInterceptor.class})

// Another alternative
// Default Interceptor
// No annotation - it would intercept all deployed beans
// You can exclude with
// @ExcludeDefaultInterceptors
// or
// @ExcludeClassInterceptors
public class GreetingImpl implements Greeting {
    private boolean constructed = false;
    
    private boolean initialised = false;
    
    private final AValue value;
    
    @Inject
    public GreetingImpl(AValue value) {
        this.value = value;
        constructed = true;
    }
    
    @PostConstruct
    void onPostConstruct() {
        initialised = true;
    }
    
    @Override
    public boolean isConstructed() {
        return constructed;
    }
    
    @Override
    public boolean isInitialised() {
        return initialised;
    }
    
    @Override
    public AValue getAValue() {
        return value;
    }
    
    @Override
    public String sayHello(String value) {
        return "Hello world, hello " + value;
    }
    
    @Override
    public String customisedHello() {
        return "Hello "  + value.getValue();
    }
}
