package benchmarks;

import java.util.*;
public class MicroBlog
{
    String Post;
    private String username;
    cloud4 store = new cloud4();
    // the max size is for the encrypted password, which is always 80 characters
    //#@Size(min = 1, max=ENCRYPTED_PASSWORD_SIZE, message="Password {javax.validation.constraints.Size.message}")
    //@Column(nullable = false)
    private String password;
	
    //@Column(nullable = false)
    private Boolean enabled;
	
    //@OneToMany
    //@JoinColumn(name="username")
    private List<String> posts;

    public String getUsername() {
	return username;
    }
	
    public void setUsername(String username) {
	this.username = username;
    }
	
    public String getPassword() {
	return password;
    }
	
    public void setPassword(String password) {
	this.password = password;
    }
	
    public Boolean getEnabled() {
	return enabled;
    }
	
    public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
    }
	
    public List<String> getPosts() {
	return posts;
    }

    public void setPosts(List<String> posts) {
	this.posts = posts;
    }
    
     public void session1() {
    	   store.put(1,2);
    	   setPosts(posts);
	}
    public void session2() {
       	   store.put(2,1);
	       setPosts(posts);
	}
	 
    public  void test() {
    	  session1();
    	  session2();
    	  assert (store.get(1) == 3);//findTotal() == list.length);
    }


    public static void main (String [] args)
        {
            MicroBlog blg = new MicroBlog();	     
	       blg.test();       
	       System.out.println("fdfdfdfd");
        }
	
}

class cloud4 {
	int get(int x) { // change a=x to a=memory.read(x)
	    //MicroBlog blg = new MicroBlog();
	    return 2+1;
	}

	 void put(int x, int val) { // change x=b to memory.write(x,b)
		x = val;
	}
}
