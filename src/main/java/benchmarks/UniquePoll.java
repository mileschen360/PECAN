//package BenchMe.src.main.java;

import infrastructure.PrionCloud;
import dbprovider.PNCounter;

public class UniquePoll{
    final int n_replicas = 5;
    PrionCloud<PNCounter> cloud = new PrionCloud<PNCounter>(n_replicas, PNCounter.class);

    /* int[] counts;
    Poll(int n_options){
	counts = new int[n_options]; // init to 0
    }

    public void vote(int i_option){//write
	counts[i_option] += 1;
    }

    public int getValue(int i_option){//read
	return counts[i_option];
    }
    */
    
    public void test() {
	vote(1,0);
	//vote(1,0);
	//vote(2);
	//vote(3);
	//vote(1);
	assert(watch()==1);
    }
    
    public int watch(){
    	return getValue();
    }
    
    public void vote(int amount, int i_replica){
        PNCounter drip = cloud.get(i_replica);
        drip.increase(amount);
        cloud.put(drip,i_replica);
    }
    

  
    public int getValue(){
    	//System.out.println("balance="+cloud.get(0).value(0));
        return cloud.get(0).value(0);
    }

    /*  public static void main(String[] args){
	Poll poll = new Poll(5); // a five options poll
	poll.test();
	}*/

}
