package web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.sun.jersey.api.view.Viewable;

@Path("/")
public class SrvHomePage{

    @GET
    @Produces({"text/html"})
    @Path("/")
    public Viewable index(){
        return new Viewable("/index");
    }
}
