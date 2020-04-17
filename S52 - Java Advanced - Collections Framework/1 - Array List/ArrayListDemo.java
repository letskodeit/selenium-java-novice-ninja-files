import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<String> cars = new ArrayList<String>();
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
		System.out.println("Iteraton example");
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
	}

}
