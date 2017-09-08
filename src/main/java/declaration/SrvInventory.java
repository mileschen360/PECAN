/** The inventory service interface. Srv is short for service
 * 
 */

package declaration;
public interface SrvInventory{
    public String get_product_doc(int product_id);
    public void createProduct(String product_doc);
    public void withdraw(int product_id, int amount);

    public void deposit(int product_id, int amount);
}