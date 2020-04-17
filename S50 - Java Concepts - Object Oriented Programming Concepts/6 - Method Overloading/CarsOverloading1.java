package automobile;
// Three ways to achieve method overloading
// 1. Different Number of parameters in arguments list
// 2. Difference in data type of arguments
// 3. Difference is sequence of data type of arguments

/***
 * Different Number of parameters in arguments list
 */
public class CarsOverloading1 {
	public static void main(String[] args) {
		increaseSeatHeight(2);
		increaseSeatHeight(8, true);
	}
	
	public static void increaseSeatHeight(int heightToIncrease) {
		System.out.println("Increased seat height by " + heightToIncrease + " inches");
	}
	
	public static void increaseSeatHeight(int heightToIncrease, boolean rememberHeight) {
		System.out.println("Increased seat height by " + heightToIncrease + " inches");
		if (rememberHeight) {
			System.out.println("Your selection is saved");
		} else {
			System.out.println("Your selection is not saved");
		}
	}
}