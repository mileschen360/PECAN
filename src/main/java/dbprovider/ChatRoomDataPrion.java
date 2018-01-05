/** This package provides the dababase for different applications
 * 
 * 
 */
package dbprovider;

public class ChatRoomDataPrion extends infrastructure.Replica{
    public final static int CAPACITY = 100;
    String[] messages;
    int[] uids;

    public ChatRoomDataPrion(int n_nodes_in){
        messages = new String[CAPACITY];
        uids = new int[CAPACITY];
    }


    public void post(String msg, int uid){
        for(int i=0; i<CAPACITY; ++i){
            if (messages[i] == null){
                messages[i] = msg;
                uids[i] = uid;
                break;
            }
        }
    }

    public String[] retrieve_msgs(){
        return messages;
    }


    public ChatRoomDataPrion merge(infrastructure.Replica another_in){
        ChatRoomDataPrion another  = (ChatRoomDataPrion) another_in;
        return another;
    }
}

