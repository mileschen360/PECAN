/**
 * Created by bookchen on 11/29/16.
 */
public abstract class Replica{
    public int hosted_node_id;
    public abstract <T extends Replica> T merge(T another);
}
