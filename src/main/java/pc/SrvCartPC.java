package pc;
/** This package contains the javaapp version of tested program
 *  to be tested by JPF. PC means personal computer, i.e. it is
 *  a desktop app without network communications
 */

public class SrvCartPC implements declaration.SrvCart{
    final int CAPACITY = 10;
    int[] product_ids;
    String[] product_docs;

    public SrvCartPC(){
        product_ids = new int[CAPACITY];
        product_docs = new String[CAPACITY];
        // init an empty shopping cart
        for(int i=0; i<CAPACITY; ++i){
            product_ids[i] = -1;
        }
    }
        
    public void test(){
        System.out.println("testing SrvCartPC");
    }
    public void add(int product_id) {
        for(int i=0; i<CAPACITY; ++i){
            if (product_ids[i] == -1){
                product_ids[i] = product_id;
                break;
            }
        }
    }

    public void remove(int product_id){
        for(int i=0; i<CAPACITY; ++i){
            if (product_ids[i] == product_id){
                product_ids[i] = -1;
                break;
            }
        }
    }

    private void pull_product_docs(){
        for(int i=0; i<CAPACITY; ++i){
            if (product_ids[i]!=-1){
               product_docs[i] = 
                srvhub.ServiceHub.srv_inventory_pc.get_product_doc(product_ids[i]);
            }
        }
    }
    public String display(){
        pull_product_docs();
        String cart_as_string = "";
        for(int i=0; i<CAPACITY; ++i){
            if (product_ids[i] != -1){
                cart_as_string += product_docs[i];
            }
        }
        return cart_as_string;
    }


}