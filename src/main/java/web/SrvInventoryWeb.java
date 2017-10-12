package web;

import javax.annotation.Generated;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/inventory")
public class SrvInventoryWeb implements scenarios.SrvInventory{
    final int CAPACITY = 20;
    int[] balances;
    String[] product_docs;

    public SrvInventoryWeb(){
        balances = new int[CAPACITY];
        product_docs = new String[CAPACITY];
        // init an empty inventory
        System.out.println("initialzing inventory");
        for(int i=0; i<CAPACITY; ++i){
            balances[i] = -1;
        }
    }
    public String get_product_doc(int product_id){
        return product_docs[product_id];
    }

    public void createProduct(String product_doc){
        for(int i=0; i<CAPACITY; ++i){
            if (balances[i] == -1){
                product_docs[i] = product_doc;
                balances[i] = 0;
                break;           
            }
        }
    }

    
    @GET
    @Path("/create/{product_doc}")
    public String createProductWeb(@PathParam("product_doc") String product_doc){
        for(int i=0; i<CAPACITY; ++i){
            if (balances[i] == -1){
                product_docs[i] = product_doc;
                balances[i] = 0;
                break;           
            }
        }
        return product_doc + "created.";
    }


    public void withdraw(int product_id, int amount){
        balances[product_id] -= amount;
    }

    public void deposit(int product_id, int amount){
        balances[product_id] += amount;
    }

    @GET
    @Path("/ui")
    public String ui(){
        String resp = "";
        for(int i=0; i<CAPACITY; ++i){
            System.out.println(balances[i]);
            if (balances[i] != -1){
                resp += product_docs[i];
            }
        }
        return resp;
    }
}