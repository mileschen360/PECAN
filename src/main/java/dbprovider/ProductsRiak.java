package dbprovider;

import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;

import java.net.UnknownHostException;

public class ProductsRiak{
    public static RiakCluster cluster;

    public static class Product {
        public String doc;
    }

    public static void setUpCluster() throws UnknownHostException {
        RiakNode node = new RiakNode.Builder()
            .withRemoteAddress("127.0.0.1")
            .withRemotePort(8087)
            .build();

        cluster = new RiakCluster.Builder(node).build();

        cluster.start();
    }
    
}