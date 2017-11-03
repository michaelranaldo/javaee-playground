package uk.co.ranaldo.javaeeplayground.jaxrs;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Path("/helloworld") // identifies the URI which will host our RESTful shizzle. Can contain params
public class ClicheResource {

    /**
     *
     * @return A clich<e but in french>d way to start a program
     */
    @GET // This method responds to a get request
    @Produces("text/plain")
    @Path("/plain") // This is appended to the path provided for the class, so to get here go to /helloworld/text
    public String getPlaintextClichedMessage() {
        return "Hello World";
    }

    /**
     *
     * @return A html formatted method of traditionally greeting the despairing creator of a new program. Not my idea.
     * This shit is Oracle's cross to bear.
     */
    @GET // This method responds to a get request
    @Produces("text/html") // This returns a string (text) which contains html (html) (<html>?)
    @Path("/html") // This is appended to the path provided for the class, so get here via /helloworld/html
    public String getHTMLClichedMessage() {
        return "<!DOCTYPE html><html><head><title>JAX-RS HTML Example</title></head><body>Hello World</body></html>";
    }

    /**
     *
     * @param name a variable provided by the URI (stripped from the URI, not nice like GET params). Used to create the
     * fancy response. this is captured using @PathParam - note the var. in the @Path Parameter and its corresponding
     * value in @PathParam
     * @return A fancy response containing the name of the user
     */
    @GET
    @Produces("text/plain")
    @Path("/boringfancy/{name}")
    public String getBoringlyFancyClichedMessage(@PathParam("name") String name) {
        return "> \"Hello " + name + ", welcome to the world!";
    }

    /**
     * An example of sending data to rest using a form. This retrieves deets from the URI, stripping them out using
     * @queryParam. QueryParam types are not limited to standard java - you can use your own classes.
     *
     * @param name a variable provided by the URI (stripped from the URI, not nice like GET params). Used to create the
     * fancy response. this is captured using @QueryParam - note the lack of path var.
     * @return A fancy response containing the name of the user
     */
    @GET
    @Produces("text/html")
    @Path("/fancyfancy")
    public String getFancyFancyClichedMessage(@QueryParam("name") String name) {
        String fancyMessage = "<!DOCTYPE html><html><head><title>JAX-RS Fancy</title></head><body>\"Hello there";
        if (name.equals("Kenobi")) {
            fancyMessage = fancyMessage + "\" </br> \"General " + name + "...\"</body></html>";
        } else {
            fancyMessage = fancyMessage + " " + name + "!</body></html>";
        }
        return fancyMessage;
    }

    /**
     * Another example of sending data using a form, but this time note the @POST param - this receives data sent from a
     * form (remember to change method to "post"), with none of the ugly params in the url.
     *
     * @param name a variable provided by the form. Used to create the fancy response. this is captured using
     * @FormParam - note the lack of path var and the fact it just knows
     * @return A fancy response containing the name of the user
     */
    @POST
    @Produces("text/html")
    @Path("/form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String getFormMessage(@FormParam("name") String name) {
        String fancyMessage = "<!DOCTYPE html><html><head><title>JAX-RS Fancy</title></head><body>\"Hello there";
        if (name.equals("Kenobi")) {
            fancyMessage = fancyMessage + "\" </br> \"General " + name + "...\"</body></html>";
        } else {
            fancyMessage = fancyMessage + " " + name + "!</body></html>";
        }
        return fancyMessage;
    }

    /**
     * An example of retrieving multiple values
     *
     * @param pathSegments /the/values/entered/as/part/of/the/uri which can be selected due to @Path's regex styling
     * @return
     */
    @GET
    @Produces("text/plain")
    @Path("/examples/{examples:.*}")
    public String getMagicMessage(@PathParam("examples") List<PathSegment> pathSegments) {
        List<String> examples = new ArrayList<>();
        pathSegments.stream()
                .map((pathSegment) -> pathSegment.getPath())
                .filter((path) -> (path != null && !path.isEmpty()))
                .forEachOrdered((path) -> {
                    examples.add(path);
                });
//      Above is equivalent to:
//      for (PathSegment pathSegment : pathSegments) {
//          String path = pathSegment.getPath();
//          if (path != null && !path.isEmpty()) {
//              examples.add(path);
//          }
//      }
        String givenExamples = "You Entered: ";
        for (String s : examples) {
            if (examples.get(0).equals(s)) {
                givenExamples += s;
            } else {
                givenExamples = givenExamples + ", " + s;
            }
        }

        return givenExamples;
    }

    /**
     * Another example of retrieving multiple values. Interestingly it appears to be inverted.
     *
     * @param questions a path parameter which can act as a list of values
     * @return
     */
    @GET
    @Produces("text/plain")
    @Path("/list/{question}/{question}/{question}")
    public String getMultiMessage(@PathParam("question") List<String> questions) {
        String furtherQuestions = "You asked: "
;        furtherQuestions = questions.stream()
                .map((s) -> ", " + s).reduce(furtherQuestions, String::concat);
//      Equivalent to:
//      for (String s : questions) {
//          furtherQuestions += ", " + s;
//      }
        return furtherQuestions;
    }

    /**
     * An example of retrieving http headers plus an ugly way of pluralizing a string
     *
     * @param userAgent
     * @param cookie
     * @return
     */
    @GET
    @Produces("text/plain")
    @Path("/headers")
    public String getHeaderMessage(@HeaderParam("User-Agent") String userAgent, @HeaderParam("Cookie") String cookie) {
        return "You are currently viewing this using: " + userAgent + ".\nYou have " + (cookie.matches(".*=.*=") ? "some cookies: " : "a cookie: ") + cookie;
    }

    /**
     * Another example of retrieving http headers
     *
     * @param requestHeaders grab the ... request headers. But you saw that coming. We'll loop through them
     * and print them to the page. Via @cousjava, it's fun to F5 and Ctrl-F5 to see changes.
     * @return
     */
    @GET
    @Produces("text/html")
    @Path("/context")
    public String getHeaderMessage(@Context HttpHeaders requestHeaders) {
        MultivaluedMap<String, String> headers = requestHeaders.getRequestHeaders();
        String table = "<table>";
        for (String s : headers.keySet()) {
            table = table + "<tr><td>" + s + "</td><td>" + headers.get(s) + "</td></tr>";
        }
        return "<!DOCTYPE html><html><head><title>Headers</title></head><body>Your headers</br>" + table + "</body></html>";
    }
}
