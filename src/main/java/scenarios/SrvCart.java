package scenarios;

public interface SrvCart{    
    public void add(int product_id);
    public void remove(int product_id);
    public void checkout();
}