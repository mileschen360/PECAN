/** This package contains the webapp version of tested program
 * can be visted from web browser. It used real database such 
 * as Riak to store data
 */

package web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/cart")
public class SrvCartWeb implements declaration.SrvCart{
    
        public void test(){
            System.out.println("testing SrvCartPC");
        }
        public void add(int product_id) {
            
        }
    
        public void remove(int product_id){
    
        }

        public void checkout(){
            // TODO
        }
        
        @GET
        @Path("/{name}")
        public String display(@PathParam("name") String name){
            String product_name = name;
            return product_name;
        }
    
    
    }