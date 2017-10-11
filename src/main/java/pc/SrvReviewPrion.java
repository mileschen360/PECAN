/** This package contains the javaapp version of tested program
 *  to be tested by JPF. PC means personal computer, i.e. it is
 *  a desktop app without network communications
 */


package pc;
/** this class use Prion Clound for data storage */
import dbprovider.ProductsPrion;
import declaration.SrvReview;
import infrastructure.PrionCloud;

class SrvReviewPrion implements SrvReview{
    final int n_replicas = 2;

    PrionCloud<ProductsPrion> cloud = 
        new PrionCloud<ProductsPrion> (n_replicas, ProductsPrion.class);

    public SrvReviewPrion(){}

    public void post(int product_id, String review){
        int i_replica = 0;
        ProductsPrion drip = cloud.get(i_replica); // always get the 0th replica
        drip.add_product_review(product_id, review);
        cloud.put(drip,i_replica);
    }

    public void delete(int product_id, int review_id){
        int i_replica = 0;
        ProductsPrion drip = cloud.get(i_replica); // always get the 0th replica
        drip.del_product_review(product_id, review_id);
        cloud.put(drip,i_replica);
    }
}