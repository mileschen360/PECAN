/**
 * Created by bookchen on 11/28/16.
 */
public class AppHelloGCounter {
    private final static int n_replicas = 2;
    private PrionCloud<GCounter> cloud = new PrionCloud<GCounter>(n_replicas, GCounter.class);

    public void test(){
        cloud.data_nodes[0].increase(1, 0);  // replica_0 increase 1
        cloud.data_nodes[1] = cloud.data_nodes[1].merge(cloud.data_nodes[0]);  // merge to replica_1
        assert (1==cloud.data_nodes[1].value());
    }
}
