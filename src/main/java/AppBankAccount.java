public class AppBankAccount{
    final int n_replicas = 2;
    PrionCloud<PNCounter> cloud = new PrionCloud<PNCounter>(n_replicas, PNCounter.class);

    public void test(){
        deposit(100,0);
        withdraw(80,0);
        withdraw(70,1);
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
