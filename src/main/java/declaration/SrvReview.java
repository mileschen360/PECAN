/** The product review service interface. Srv is short for service
 * 
 */

package declaration;
public interface SrvReview{    
    public void post(int product_id, String review);
    public void delete(int product_id, int review_id);
}