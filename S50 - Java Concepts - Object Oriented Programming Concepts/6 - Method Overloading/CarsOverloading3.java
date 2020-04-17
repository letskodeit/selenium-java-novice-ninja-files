package automobile;
//Three ways to achieve method overloading
//1. Different Number of parameters in arguments list
//2. Difference in data type of arguments
//3. Difference is sequence of data type of arguments

/***
 * Sequence of data type of arguments
 */
public class CarsOverloading3 {

	public static void main(String[] args) {
		increaseSeatHeight("2", 2);
		increaseSeatHeight(8, "8");
	}
	
	public static void increaseSeatHeight(String variable1, int variable2) {
		System.out.println("I am the 1st overload.");
	}
	
	public static void increaseSeatHeight(int variable2, String variable1) {
		System.out.println("I am the 2nd overload.");
	}
}