/** The shopping cart service interface. Srv is short for service
 * 
 */
package declaration;
public interface SrvCart{    
    public void add(int product_id);
    public void remove(int product_id);
    public void checkout();
}