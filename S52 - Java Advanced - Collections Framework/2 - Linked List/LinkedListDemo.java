import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
	/***
	 * Array List - {0, 1, 2, 3, 4, 5, 6}
	 * Linked List - [0] > [1] > [2]
	 *                   <     < 
	 * Array List - When you have to add at the end and remove from the end and getting is fast
	 * Linked List - When you have add at the beginning and remove from the beginning
	 */
	public static void main(String[] args) {
		LinkedList<String> cars = new LinkedList<String>();
		// Adding
		cars.add("BMW");
		cars.add("Honda");
		cars.add("Audi");
		
		// Size
		int size = cars.size();
		System.out.println("The size of the list is: " + size);
		
		// Get
		System.out.println("The item on index 1 is: " + cars.get(1));
		
		// Iteration
		System.out.println("Iteration example");
		for (int i = 0; i < size; i++) {
			System.out.println("Item on index " + i + " is: " + cars.get(i));
		}
		
		System.out.println("\nNext for loop example");
		for (String car : cars) {
			System.out.println("The item is: " + car);
		}
		
		// Remove
		cars.remove(size - 1);
		
		System.out.println("\nNext for loop example after removing");
		for (String car : cars) {
			System.out.println("The item is: " + car);
		}
		
		List<Integer> aList = new ArrayList<Integer>();
		List<Integer> lList = new LinkedList<Integer>();
	}
	
}
