package benchmarks;

import dbprovider.OnlineAlbumDataPrion;
import infrastructure.PrionCloud;

public class OnlineAlbumPrion implements scenarios.OnlineAlbum{
    static final int n_replicas = 2;

    static PrionCloud<OnlineAlbumDataPrion> cloud = 
        new PrionCloud<OnlineAlbumDataPrion>(n_replicas, OnlineAlbumDataPrion.class);

    public static void test(){
        System.out.println("testing OnlineAlbumPrion");
        OnlineAlbumPrion iphone_client = new OnlineAlbumPrion();
        iphone_client.upload(1);   // photos are represented by positive integers
        iphone_client.upload(2);
        OnlineAlbumPrion android_client = new OnlineAlbumPrion();
        android_client.upload(3);
        OnlineAlbumPrion mac_client = new OnlineAlbumPrion();
        int album_id = mac_client.create_album();
        mac_client.add_to_album(album_id, 2);
        OnlineAlbumPrion website_client = new OnlineAlbumPrion();
        website_client.add_to_album(album_id, 3);
        int[] photos = iphone_client.get_photos(album_id);
        assert(photos[1]==3);
    }

    public void add_to_album(int album, int photo){
        OnlineAlbumDataPrion drip = cloud.get(0); // always get the 0th, change as necessary
        drip.add_to_album(album, photo);
        cloud.put(drip, 1);    // always put to a differnt replica, change as necessary
    }

    public void upload(int photo){
        OnlineAlbumDataPrion drip = cloud.get(0); // always get the 0th, change as necessary
        drip.add_photo(photo);
        cloud.put(drip, 1);  // always put to a differnt replica, change as necessary
    }

    public int[] get_photos(int album){
        OnlineAlbumDataPrion drip = cloud.get(0);
        return drip.get_photos(album);
    }

    public int create_album(){
        OnlineAlbumDataPrion drip = cloud.get(0); // always get the 0th, change as necessary
        int album_id = drip.create_album();
        cloud.put(drip, 1); // always put to a differnt replica, change as necessary
        return album_id;
    }



}