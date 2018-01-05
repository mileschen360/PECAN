/** This package provides the dababase for 
 * 
 * 
 */
package dbprovider;

// for storing product information
public class ProductsPrion extends infrastructure.Replica{
    public final static int CAPACITY = 20;
    public final static int REVIEWS_CAPACITY = 9;
    int[] balance_prds; // prds: products
    String[] doc_prds;
    String[][] reviews_prds;

    public ProductsPrion(int n_nodes_in){
        balance_prds = new int[CAPACITY];
        doc_prds = new String[CAPACITY];
        reviews_prds = new String[CAPACITY][REVIEWS_CAPACITY];
        // init an empty inventory
        for(int i=0; i<CAPACITY; ++i){
            balance_prds[i] = -1;
        }        
    }

    public void set_balance(int product_id, int amount){
        balance_prds[product_id] = amount;
    }

    public int get_balance(int product_id){
        return balance_prds[product_id];
    }

    public void set_product_doc(int product_id, String doc){
        doc_prds[product_id] = doc;
    }

    public void add_product_review(int product_id, String review){
        for(int i=0; i<REVIEWS_CAPACITY; ++i){
            if (reviews_prds[product_id][i] == null){
                reviews_prds[product_id][i] = review;
                break;
            }
        }
    }

    public void del_product_review(int product_id, int review_id){
        assert(review_id < REVIEWS_CAPACITY);
        reviews_prds[product_id][review_id] = null;
    }


    public String get_product_doc(int product_id){
        return doc_prds[product_id];
    }

    public ProductsPrion merge(infrastructure.Replica another_in){
        ProductsPrion another = (ProductsPrion) another_in;
        return another;
    }

}