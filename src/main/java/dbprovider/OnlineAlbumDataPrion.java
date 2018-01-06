/** This package provides the database for different applications
 * 
 * 
 * 
 */
package dbprovider;

 public class OnlineAlbumDataPrion extends infrastructure.Replica{
    public final static int MAX_N_PHOTOS = 100;
    public final static int MAX_N_ALBUMS = 10;
    private final static int INVALID = -1;
    int[] photos;
    int[] albums;
    int[][] albums_photos;

    public OnlineAlbumDataPrion(int n_nodes_in){
        photos = new int[MAX_N_PHOTOS];
        for(int i=0; i<MAX_N_PHOTOS; ++i){
            photos[i] = INVALID;   // initialize to storing no photos;
        }
        albums = new int[MAX_N_ALBUMS];
        for(int i=0; i<MAX_N_ALBUMS; ++i){
            albums[i] = INVALID;   // initialize to no albums created;
        }
        albums_photos = new int[MAX_N_ALBUMS][MAX_N_PHOTOS];  // default to 0 means no albums
        for(int i=0; i<MAX_N_ALBUMS; ++i){
            for(int j=0; j<MAX_N_PHOTOS; ++j){
                albums_photos[i][j] = INVALID;
            }
        }
    }

    public void add_photo(int photo){
        assert(photo>0);
        for(int i=0; i<MAX_N_PHOTOS; ++i){
            if (photos[i] == INVALID){
                photos[i] = photo;
                return; 
            }
        }
    }

    public int create_album(){
        for(int i=0; i<MAX_N_ALBUMS; ++i){
            if (albums[i] == INVALID ){
                albums[i] = 1;
                return i;
            }
        }
        return MAX_N_ALBUMS;
    }

    public void add_to_album(int album, int photo){
        for(int i=0; i<MAX_N_PHOTOS; ++i){
            if (albums_photos[album][i] == INVALID) {
                albums_photos[album][i] = photo;
                return;
            }
        }
    }

    public int[] get_photos(int album){
        return albums_photos[album];
    }


    public OnlineAlbumDataPrion merge(infrastructure.Replica another_in){
        OnlineAlbumDataPrion another = (OnlineAlbumDataPrion) another_in;
        return another;
    }


 }