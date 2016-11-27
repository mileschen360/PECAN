import java.lang.Math;
/* This is CRTD PNCounter
*
*
*  */

public class PNCounter{
    public int[] vals_over_nodes;
    public int hosted_node_id;
    public int n_nodes;

    public PNCounter(int n_nodes_in){
        vals_over_nodes = new int[n_nodes_in];
        this.n_nodes = n_nodes_in;
        hosted_node_id = -1;
    }

    public void increase(int delta){
        System.out.println("read  #"+hosted_node_id+" "+vals_over_nodes[hosted_node_id]);
        vals_over_nodes[hosted_node_id] += delta;
        System.out.println("write #"+hosted_node_id+" "+vals_over_nodes[hosted_node_id]);
    }

    public Integer value(){
        int sum = 0;
        for (int i=0; i< n_nodes; ++i){
            System.out.println("read #"+i+" "+vals_over_nodes[i]);
            sum += vals_over_nodes[i];
        }
        return sum;
    }

    /*
    boolean less_at(int node_id, PNCounter another){
        int val_this = this.vals_over_nodes[node_id];
        int val_another = another.vals_over_nodes[node_id];
        return val_this < val_another;
    }*/

    public PNCounter merge(PNCounter another) {
        PNCounter merged = new PNCounter(another.n_nodes);
        for (int i_node = 0; i_node < n_nodes; ++i_node) {
            merged.vals_over_nodes[i_node] = Math.max(this.vals_over_nodes[i_node],
                    another.vals_over_nodes[i_node]);
        }
        return merged;
    }
}
