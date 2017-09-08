package infrastructure;

/** This package provide a in-memory replica data type (or cloud)
 * 
 */
public class PropagatingThread extends Thread{
    private PrionCloud cloud;
    private int interval_ms;
    PropagatingThread(PrionCloud cloud_in, int interval_ms_in) {
        cloud = cloud_in;
        interval_ms = interval_ms_in;
    }

    void propagate() {

    }

    @Override
    public void run() {
        while (true){
            propagate();
            try {
                sleep(interval_ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
