package exercises;

public class ReverseString {
	
	public static void main(String[] args) {
		String input = "this is a test string";
		String output = reverse(input);
		System.out.println(output);
	}
	
	// There is no built-in reverse method for strings in Java
	// There is one with String Builder, which does not give the output we want
	private static String reverse(String input) {
		String reverse = "";
		
		if (input == null || input.isEmpty()) {
			System.out.println("Empty and null strings are not accepted");
		}
		
		if (input.length() <= 1) {
			reverse = input;
		} else {
			String[] originalArray = input.split("\\s+");
			
			for (String item : originalArray) { // this, is, a, test, string
				reverse = item + " " + reverse; // this + "", is + this, a + is this, test + a is this, string + test a is this
			}
		}
		
		return reverse.trim();
	}
}