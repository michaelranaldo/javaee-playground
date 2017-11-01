//package uk.co.ranaldo.javaeeplayground.jaxrs;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
///**
// *
// * @author Michael Ranaldo <michael@ranaldo.co.uk>
// */
//@Path("/resources")
//public class MyResource {
//    
//    /**
//     * Gets all objects
//     * @return ^
//     */
//    @GET
//    public Response get() {
//        String badger = "Oh hi mark";
//        return Response.status(200).entity(badger).build();
//    }
//    
//    /**
//     * Gets the specified object
//     * Annotations:
//     *  @GET: The HTTP method which this method will respond to
//     *  @Path: A catch-all for values entered after $ctx/badgers. Parameters, when specified using {x}, {y}, can be
//     *         used in the method when clarified using the @PathParam notation in the method signature. By this
//     *         signature change you are naturally able to have multiple methods which respond to the same HTTPMethod,
//     *         but with different variables (as the whole signature is checked for uniqueness, but that's basic Java
//     *         so I'm sure you're familiar. Or, like me, temporarily forgotten it.
//     * @param uriPayload
//     * @return String representation of the request object, or an empty string. Null can be considered rude.
//     */
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    @Path("{name}")
//    public String get(@PathParam("name") String uriPayload) {
//        return "<html lang=\"en\"><body>Request for the badger: " + Storage.get(uriPayload) + "</body></html>";
//    }
//    
//    /**
//     * Adds the object given as a payload to Storage
//     * Annotations: 
//     *  @POST: The HTTP method which this method will respond to
//     * @param uriPayload The object to be added to the list, which must be a POJO
//     * @return
//     */
//    @POST
//    @Produces(MediaType.TEXT_HTML)
//    public String put(String uriPayload) {
//        Storage.add(uriPayload);
//        return "<html lang=\"en\"><body>Added a badger: " + uriPayload + "</body></html>";
//    }
//    
//    /**
//     * Deletes the object corresponding to the URI, i.e. $ctx/$methodpath/{craig} will call Storage's delete on craig.
//     * Annotations:
//     *  @DELETE: Action when endpoint is contacted using DELETE http method. ws.rs.DELETE, NOT ws.rs.HttpMethod.DELETE
//     *  @Path: Additional values which follow the classes path, so this would be $ctx/badgers/{name}, where {name}
//     *         is a value which can be used in the method. Thus it could equally be @Path(/names/{name}) or blank,
//     *         which would allow use to use a parameter or not respectively.
//     * @param uriPayload The name of the object to be deleted, deletion proper handled by Storage.delete.
//     * @return 
//     */
//    @DELETE
//    @Consumes(MediaType.TEXT_PLAIN)
//    @Produces(MediaType.TEXT_HTML)
//    @Path("{name}")
//    public String delete(@PathParam("name") String uriPayload) {
//        Storage.delete(uriPayload);
//        return "<html lang=\"en\"><body>Deleted a badger: " + uriPayload + "</body></html>";
//    }
//}
//
