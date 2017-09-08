import java.lang.Math;
/* This is CvRTD PNCounter
*
*
*  */

public class PNCounter extends Replica{
    public int[] pvals_over_nodes;
    public int[] nvals_over_nodes;
    public int n_nodes;
    private static final boolean print_debug_info = false;

    public PNCounter(int n_nodes_in){
        pvals_over_nodes = new int[n_nodes_in];
        nvals_over_nodes = new int[n_nodes_in];
        this.n_nodes = n_nodes_in;
        hosted_node_id = -1;
    }

    public void increase(int delta){
        if (print_debug_info) {
            System.out.println("read  p#" + hosted_node_id + " " + pvals_over_nodes[hosted_node_id]);
        }
        pvals_over_nodes[hosted_node_id] += delta;
        if (print_debug_info) {
            System.out.println("write p#" + hosted_node_id + " " + pvals_over_nodes[hosted_node_id]);
        }
    }


    public void decrease(int delta){
        if (print_debug_info) {
            System.out.println("read  n#" + hosted_node_id + " " + nvals_over_nodes[hosted_node_id]);
        }
        nvals_over_nodes[hosted_node_id] += delta;  // increase the negative part
        if (print_debug_info) {
            System.out.println("write n#" + hosted_node_id + " " + nvals_over_nodes[hosted_node_id]);
        }

    }


    public Integer value(){
        int sum = 0;
        for (int i=0; i< n_nodes; ++i){
            if (print_debug_info) {
                System.out.println("read p#" + i + " " + pvals_over_nodes[i]);
                System.out.println("read n#" + i + " " + nvals_over_nodes[i]);
            }
            sum = sum + pvals_over_nodes[i]-nvals_over_nodes[i];
        }
        return sum;
    }

    public PNCounter merge(Replica another_in) {
        PNCounter another = (PNCounter) another_in;
        PNCounter merged = new PNCounter(another.n_nodes);
        for (int i_node = 0; i_node < n_nodes; ++i_node) {
            merged.pvals_over_nodes[i_node] = Math.max(this.pvals_over_nodes[i_node],
                                                    another.pvals_over_nodes[i_node]);
            merged.nvals_over_nodes[i_node] = Math.max(this.nvals_over_nodes[i_node],
                                                    another.nvals_over_nodes[i_node]);
        }
        return merged;
    }
}
