/** This package contains the javaapp version of tested program
 *  to be tested by JPF. PC means personal computer, i.e. it is
 *  a desktop app without network communications
 */


package pc;
public class SrvInventoryPC implements declaration.SrvInventory{
    final int CAPACITY = 20;
    static int[] balances;
    static String[] product_docs;

    public SrvInventoryPC(){
        balances = new int[CAPACITY];
        // init an empty inventory
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

    public void withdraw(int product_id, int amount){
        balances[product_id] -= amount;
    }

    public void deposit(int product_id, int amount){
        balances[product_id] += amount;
    }
}