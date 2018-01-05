package benchmarks;

import dbprovider.ChatRoomDataPrion;
import infrastructure.PrionCloud;
import scenarios.ChatRoom;

// A chat room using Prion as data store
public class ChatRoomPrion implements scenarios.ChatRoom{
    static final int n_replicas = 2;
    static int next_uid = 0;
    int uid;

    static PrionCloud<ChatRoomDataPrion> cloud = 
        new PrionCloud<ChatRoomDataPrion>(n_replicas, ChatRoomDataPrion.class);

    public ChatRoomPrion(){
        this.uid = ChatRoomPrion.next_uid;
        ChatRoomPrion.next_uid += 1;
    }

    public ChatRoomPrion(int uid){
        this.uid = uid;
    }


    public static void test(){
        System.out.println("testing ChatRoomPrion");
        ChatRoomPrion client1 = new ChatRoomPrion();
        ChatRoomPrion client2 = new ChatRoomPrion();
        client1.post("Anyone here?");
        String[] messages = client2.retrieve();
        if (messages[0].equals("Anyone here?")) {
            client2.post("Yes, I am here. Who are you?");
        }
        messages = client1.retrieve();
        if (messages[1].equals("Yes, I am here. Who are you?")){
            client1.post("I am John.");
        }
        ChatRoomPrion client3 = new ChatRoomPrion();
        client3.post("I just came in.");

        messages = client1.retrieve();
        assert(messages[2].equals("I just came in."));
    }


    public void post(String msg){
        ChatRoomDataPrion drip = cloud.get(0);  // always get the 0th replica
        drip.post(msg, this.uid);
        cloud.put(drip, 1);     // always write to the 1st replica, change this policy when necessary
    }

    public String[] retrieve(){
        ChatRoomDataPrion drip = cloud.get(0); // always get the 0th replica
        return drip.retrieve_msgs();
    }




}