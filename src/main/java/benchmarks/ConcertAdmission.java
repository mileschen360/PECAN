package benchmarks;

import infrastructure.PrionCloud;
import dbprovider.GCounter;


 public class ConcertAdmission {
    private final static int n_entrances = 2;  // number of entrances,
    private final static int n_seats   = 3;    // use to test the correctness of this application
    // when n_seats = even, free_admission() will fail, when n_seats = odd, it still work, but just HAPPEN to be correct.
    PrionCloud<GCounter> cloud = new PrionCloud<GCounter>(n_entrances, GCounter.class); // create a RDT/cluster with the same number of replicas/nodes


    public ConcertAdmission(){
    }

    public void test(){
        free_admission();
        //int n_tickets = n_seats;
        //ticket_admission(n_tickets);

        cloud.propagate(); // make the distributed system to arrive eventual state

        /// below is to check if the result is expected
        GCounter drip = cloud.get(0);
        System.out.print("eventually drip = "+drip.value());
        //System.out.print(drip.value());
        System.out.println(", correct drip = " + n_seats);
        //assert (drip.value()==n_seats);
    }

    void ticket_admission(int n_tickets){
        GCounter drip;
        for(int i=0; i<n_tickets; ++i) {
            drip = cloud.get(i%2);
            drip.increase(1);
            cloud.put(drip, 0);
        }
    }

    void free_admission (){
        int i=1;
        for (GCounter drip = cloud.get(i%2); drip.value()<n_seats; drip = cloud.get(i%2)) {
            drip.increase(1);
            cloud.put(drip,0);
            i++;
        }
    }
}
