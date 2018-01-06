import static java.lang.Thread.sleep;

/**
 * 
 */
public class BenchMeMain {
    public static void main(String[] args){
        //AppConcertAdmission app = new AppConcertAdmission();
        //AppHelloGCounter app = new AppHelloGCounter();
        // AppBankAccount app = new AppBankAccount();
        // app.test();

        // pc.SrvCartPC srv_cart = new pc.SrvCartPC();
        // pc.SrvInventoryPC srv_inventory = new pc.SrvInventoryPC();
        //pc.SrvInventoryPrion srv_inventory_prion = new pc.SrvInventoryPrion();
        // srvhub.ServiceHub.srv_cart_pc = srv_cart;
        // srvhub.ServiceHub.srv_inventory_pc = srv_inventory;
        // srvhub.ServiceHub.srv_inventory_prion = srv_inventory;
        //srv_inventory_prion.test(); // test the inventory service
        // try{
        //     dbprovider.ProductsRiak.setUpCluster();
        //     benchmarks.SrvReviewRiak srv_review_riak = new benchmarks.SrvReviewRiak();
        //     srv_review_riak.test();
        //     dbprovider.ProductsRiak.cluster.shutdown();
        // }catch (Exception e){
        //     System.out.println(e.getMessage());
        // }

        // benchmarks.ChatRoomPrion.test();
        benchmarks.OnlineAlbumPrion.test();

    }
}



 
