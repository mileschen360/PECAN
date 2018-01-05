package scenarios;

public interface ChatRoom{    
    public void post(String msg);
    public String[] retrieve();
}