import static java.lang.Thread.sleep;

/**
 * Created by bookchen on 11/27/16.
 */
public class AppConcertAdmission {
    final static int n_entrances = 2;  // number of entrances,
    final static int n_seats   = 4;    // use to test the correctness of this application
    static PrionCloud cloud = new PrionCloud(n_entrances); // create a RDT/cluster with the same number of replicas/nodes
    final int interval_ms = 10;

    public AppConcertAdmission(){
        // cloud.online(interval_ms);
    }

    /// Ticket needed
    public void test(){
        int n_tickets = n_seats;
        //ticket_admission(n_tickets);
        free_admission();

        try {
            sleep(1000);  // adjust how long you want to wait to enroll next person
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cloud.propagate();
        GCounter drip = cloud.get(1);
        drip.value();
        //assert (drip.value()<=n_seats);
        //System.out.print("drip = ");
        //System.out.println(drip.value());

    }


    static void ticket_admission(int n_tickets){
        GCounter drip;
        // start entering
        for(int i=0; i<n_tickets; ++i) {
            drip = cloud.get(i%2);
            drip.increase(1);
            cloud.put(drip,0);
            cloud.propagate();
            try {
                sleep(1000);  // adjust how long you want to wait to enroll next person
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void free_admission (){
        GCounter drip;
        // start entering
        int i=1;
        for (drip = cloud.get(i%2); drip.value()<n_seats; drip = cloud.get(i%2)) {
            drip.increase(1);
            cloud.put(drip,0);
            cloud.propagate();
            try {
                sleep(500);  // adjust how long you want to wait to enroll next person
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }

        //assert (drip.value()<=n_seats);
        //System.out.print("drip = ");
        //System.out.println(drip.value());
    }



}
