/* This is CvRTD GCounter
*
*
*  */

package dbprovider;

import java.lang.Math;

public class GCounter extends infrastructure.Replica{
    public int[] vals_over_nodes;
    public int n_nodes;
    private static final boolean print_debug_info = false;

    public GCounter(int n_nodes_in){
        vals_over_nodes = new int[n_nodes_in];
        this.n_nodes = n_nodes_in;
        this.hosted_node_id = -1;
    }

    public void increase(int delta){
        if (print_debug_info) {
            System.out.println("read  #" + hosted_node_id + " " + vals_over_nodes[hosted_node_id]);
        }
        vals_over_nodes[hosted_node_id] += delta;
        if (print_debug_info) {
            System.out.println("write #" + hosted_node_id + " " + vals_over_nodes[hosted_node_id]);
        }
    }

    public void increase(int delta, int hosted_node_id){
        vals_over_nodes[hosted_node_id] += delta;
    }

    public Integer value(){
        int sum = 0;
        for (int i=0; i< n_nodes; ++i){
            if (print_debug_info) {
                System.out.println("read #" + i + " " + vals_over_nodes[i]);
            }
            sum += vals_over_nodes[i];
        }
        return sum;
    }

    /*
    boolean less_at(int node_id, TransitCenter another){
        int val_this = this.vals_over_nodes[node_id];
        int val_another = another.vals_over_nodes[node_id];
        return val_this < val_another;
    }*/

    public GCounter merge(infrastructure.Replica another_in) {
        GCounter another = (GCounter) another_in;
        GCounter merged = new GCounter(another.n_nodes);
        for (int i_node = 0; i_node < n_nodes; ++i_node) {
            merged.vals_over_nodes[i_node] = Math.max(this.vals_over_nodes[i_node],
                    another.vals_over_nodes[i_node]);
        }
        return merged;
    }
}
