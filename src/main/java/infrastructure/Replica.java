/** This package provide a in-memory replica data type (or cloud)
 * 
 */

package infrastructure;
public abstract class Replica{
    public int hosted_node_id;
    public abstract <T extends Replica> T merge(T another);
}
