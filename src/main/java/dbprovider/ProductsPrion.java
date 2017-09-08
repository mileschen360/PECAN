/** This package provides the dababase 
 * 
 */
package dbprovider;

public class ProductsPrion extends infrastructure.Replica{
    public final static int CAPACITY = 20;    
    int[] balances;
    String[] product_docs;

    public ProductsPrion(int n_nodes_in){
        balances = new int[CAPACITY];
        product_docs = new String[CAPACITY];
        // init an empty inventory
        for(int i=0; i<CAPACITY; ++i){
            balances[i] = -1;
        }        
    }

    public void set_balance(int product_id, int amount){
        balances[product_id] = amount;
    }

    public int get_balance(int product_id){
        return balances[product_id];
    }

    public void set_product_doc(int product_id, String doc){
        product_docs[product_id] = doc;
    }

    public String get_product_doc(int product_id){
        return product_docs[product_id];
    }

    public ProductsPrion merge(infrastructure.Replica another_in){
        ProductsPrion another = (ProductsPrion) another_in;
        return another;
    }

}