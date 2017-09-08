/** This package contains the javaapp version of tested program
 *  to be tested by JPF. PC means personal computer, i.e. it is
 *  a desktop app without network communications
 */


package pc;
/** this class use Prion Clound for data storage */

import dbprovider.ProductsPrion;
import infrastructure.PrionCloud;

public class SrvInventoryPrion implements declaration.SrvInventory{
    final int n_replicas = 2;

    PrionCloud<ProductsPrion> cloud =
        new PrionCloud<ProductsPrion>(n_replicas, ProductsPrion.class);

    /** simulate the operation of inventory
     * 
    */
    public void test(){
        // create 3 product in our database
        createProduct("coke"); // will be assigned product_id 0 automaticly
        createProduct("rice");
        createProduct("cheese");
        deposit(0, 26);
        deposit(1, 17);
        deposit(2, 83);
        withdraw(1, 2);  // sell 2 bags of rice
        withdraw(0, 5);  // sell 5 packs of cokes
        withdraw(2, 18); // sell 18 slices of cheese
        ProductsPrion drip = cloud.get(0);
        assert(drip.get_balance(0)==21); // ensure still have 26-5=21 cokes
        assert(drip.get_product_doc(1)=="rice"); // ensure product_id 1 is rice        
    }


    public String get_product_doc(int product_id){
        ProductsPrion drip = cloud.get(0); // always get the 0th replica
        return drip.get_product_doc(product_id);
    }

    public void createProduct(String product_doc){
        ProductsPrion drip = cloud.get(0);
        for(int i=0; i<ProductsPrion.CAPACITY; ++i){
            if (drip.get_balance(i) == -1){
                drip.set_product_doc(i, product_doc);
                drip.set_balance(i, 0);
                cloud.put(drip,0);
                break;           
            }
        }
    }

    public void withdraw(int product_id, int amount){
        ProductsPrion drip = cloud.get(0);
        int current_balance = drip.get_balance(product_id);
        drip.set_balance(product_id, current_balance - amount);
        cloud.put(drip, 0);
    }

    public void deposit(int product_id, int amount){
        ProductsPrion drip = cloud.get(0);
        int current_balance = drip.get_balance(product_id);
        drip.set_balance(product_id, current_balance + amount);
        cloud.put(drip, 0);
    }
}