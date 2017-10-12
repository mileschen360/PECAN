package benchmarks;

/* ShoppingList.java - define a shopping list.
 * The attribute will be an array of Items, where an Item
 *   is just a name and a price.
 * The shopping list info will be read in from a file.  To make
 *   the implementation a little simpler, let's assume that the
 *   input file begins with a number that tells us how many items
 *   are on the list.  This will save us the trouble of having to
 *   read the list twice (or using a data structure other than an array.)
 * Let's assume the rest of the input file has one item per line
 *   and the format is the name followed by price.
 * Let's assume the name has only one word.  (Think about how we
 *   would handle multi-word names.)
 */
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;

//import org.apache.commons.lang3.ArrayUtils;

// public class ShoppingList {
// 	private Item[] list;
// 	static cloud store = new cloud();
// 	private int itemCount; // total number of items in the cart
	
// 	public static void main(String[] args) {
// 		//try{
// 			ShoppingList testinst = new ShoppingList();
// 			testinst.test();
// 		//}
// 		//catch (FileNotFoundException e){
// 		    // do stuff here..
// 		    //return false;
// 		//}
		
// 	}
// 	/*
// 	 * default constructor - read from input file
// 	 */
	
// 	public ShoppingList(){// throws FileNotFoundException {
// 		//System.out.printf("Enter name of input file:  ");
// 		//Scanner kbd = new Scanner(System.in);
// 		String fileName = "test.txt";//kbd.nextLine();
// 		//Scanner in = new Scanner(new FileInputStream(fileName)); // don't forget
// 										// "new"

// 		// Find size of the list. Allocate space for shopping list.
// 		int numItems = 0;//in.nextInt();
// 		list = new Item[2];

// 		// Read the items one at a time.
// 		// Each line has a price. After the price, the entire rest of
// 		// the line will be the name of the item.
// 		// If the item name came first, this would have been a little
// 		// more difficult to do.
// 		int index = 0;
// 		//while (index < numItems) {
// 			//String name = in[index].next();
// 			//double price = in.nextDouble();

// 			// Create a new object and put it into the array.
// 			//Item thing = new Item(name, price);
// 			//list[index] = thing;

// 		//	index = index + 1;
// 		//}
// 	}

// 	// -----------------------------------------------------------
// 	// Test shopping cart with a capacity of 3 items.
// 	// -----------------------------------------------------------

// 	public  void test() {
// 		addItem("test", 1.0);store.put(1, 1);
// 		addItem("test1", 2.0);store.put(2, 1);
// 		assert (store.get(2) == 2);//findTotal() == list.length);
// 	}

// 	// -----------------------------------------------------------
// 	// Rm shopping items from list.
// 	// -----------------------------------------------------------

// 	public void removeItem(int index) {
// 		// let's remove or delete an element from Array using Apache Commons
// 		// ArrayUtils
// 		// list = ArrayUtils.remove(list, index); //removing element at index 2
// 		int i = 0, j = 0;

// 		while (i < list.length) {
// 			if (i != index) {
// 				list[j] = list[i];
// 				j++;
// 			}

// 			i++;
// 		}
// 	}

// 	public  void addItem(String n, double p) {
// 		// let's remove or delete an element from Array using Apache Commons
// 		// ArrayUtils
// 		// list = ArrayUtils.remove(list, index); //removing element at index 2
// 		// Create a new object and put it into the array.
// 		//Item thing = new Item(n, p);
// 		list[itemCount++] = new Item(n, p);
// 	}

// 	/*
// 	 * findTotal - go thru the entire array and add up the prices of the items.
// 	 * This is a very useful function! Many functions we'll write in the future
// 	 * will look like this. Note carefully the expression
// 	 * "list[index].getPrice()"
// 	 */
// 	public int findTotal()// double findTotal()
// 	{
// 		double sum = 0.00;
// 		int index = 0;
// 		while (index < list.length) {
// 			sum = sum + list[index].getPrice();
// 			index = index + 1;
// 		}
// 		return index;// sum;
// 	}

// 	/*
// 	 * toString() will generate a text representation of the list, including the
// 	 * total. We'll format the output so it looks good. Note that we need to use
// 	 * a loop, and slowly build the string. We'll make use of the Item
// 	 * toString(). When we do so, we need to remember to append a \n because
// 	 * there isn't one at the end of the item's string.
// 	 */
// 	public String toString() {
// 		String build = "";
// 		int index = 0;
// 		while (index < list.length) {
// 			build = build + list[index].toString() + "\n";
// 			index = index + 1;
// 		}

// 		// Get ready for the total
// 		// Let's assume the shopping list has a width of 30 characters.
// 		build = build + "------------------------------\n";
// 		build = build + String.format("TOTAL %24.2f\n", findTotal());

// 		return build;
// 	}
// }

// /*class cloud{
// 	static int get(int x) { // change a=x to a=memory.read(x)
// 		return x;
// 	}

// 	static void put(int x, int val) { // change x=b to memory.write(x,b)
// 		x = val;
// 	}
// }*/
