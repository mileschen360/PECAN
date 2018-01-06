package benchmarks;

import infrastructure.PrionCloud;
import dbprovider.PNCounter;
public class BankAccount{
    final int n_replicas = 2;
    PrionCloud<PNCounter> cloud = new PrionCloud<PNCounter>(n_replicas, PNCounter.class);

    public void test(){
        System.out.println("Testing AppBankAccount");
        deposit(100,0);
        withdraw(80,0);
        withdraw(70,0);
        System.out.println(balance());
        assert(balance()>=0);
    }

    public void deposit(int amount, int i_replica){
        PNCounter drip = cloud.get(i_replica);
        drip.increase(amount);
        cloud.put(drip,i_replica);
    }

    public void withdraw(int amount, int i_replica){
        PNCounter drip = cloud.get(i_replica);
        drip.decrease(amount);
        cloud.put(drip, i_replica);
    }

    public int balance(){
        return cloud.get(0).value();
    }
}
