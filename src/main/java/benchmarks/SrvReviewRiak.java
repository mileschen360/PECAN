/** This package contains the javaapp version of tested program
 *  to be tested by JPF. PC means personal computer, i.e. it is
 *  a desktop app without network communications
 */


package benchmarks;
/** this class use Prion Clound for data storage */
import dbprovider.ProductsRiak;
import infrastructure.PrionCloud;

import com.basho.riak.client.core.query.RiakObject;
import com.basho.riak.client.core.util.BinaryValue;

public class SrvReviewRiak implements scenarios.SrvReview{
    public SrvReviewRiak(){}

    public void test(){
        RiakObject quoteObject = new RiakObject()
        // We tell Riak that we're storing plaintext, not JSON, HTML, etc.
        .setContentType("text/plain")
                // Objects are ultimately stored as binaries
        .setValue(BinaryValue.create("You're dangerous, Maverick"));
        System.out.println("Basic object created");
    }


    public void post(int product_id, String review){
    }

    public void delete(int product_id, int review_id){
    }
}