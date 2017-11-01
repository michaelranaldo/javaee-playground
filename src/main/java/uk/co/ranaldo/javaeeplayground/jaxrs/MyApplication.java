package uk.co.ranaldo.javaeeplayground.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Either this or the web.xml specifies the location of the base URI for this applications resources.
 * Other than that, this class can be left empty.
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@ApplicationPath("webresources")
public class MyApplication extends Application {
}
