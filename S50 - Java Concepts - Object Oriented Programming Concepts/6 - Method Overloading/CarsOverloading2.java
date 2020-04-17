package automobile;
//Three ways to achieve method overloading
//1. Different Number of parameters in arguments list
//2. Difference in data type of arguments
//3. Difference is sequence of data type of arguments

/***
 * Difference in data type of arguments
 */
public class CarsOverloading2 {

	public static void main(String[] args) {
		increaseSeatHeight(2);
		increaseSeatHeight("8");
	}
	
	public static void increaseSeatHeight(int heightToIncrease) {
		System.out.println("Increased seat height by " + heightToIncrease + " inches. I am the interger one.");
	}
	
	public static void increaseSeatHeight(String heightToIncrease) {
		System.out.println("Increased seat height by " + heightToIncrease + " inches. I am the String one.");
	}
}