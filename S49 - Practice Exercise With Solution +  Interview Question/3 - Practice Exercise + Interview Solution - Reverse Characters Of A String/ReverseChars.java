package interviewquestions;

import java.util.Scanner;

// Please change the extension to .java before using the file
// I changed the extension to .txt because udemy does not allow to upload .java files
public class ReverseChars {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		String original = scan.nextLine();
		
		while (original.isEmpty() || original == null) {
			System.out.println("Please enter a valid string, empty and null strings are not accepted:");
			original = scan.nextLine();
		}
		scan.close();
		
		ReverseChars output = new ReverseChars();
		String reverseCharacters = output.reverseCharacters(original);
		System.out.println(reverseCharacters);
	}
	
	private String reverseCharacters(String originalString) {
		String reverse = "";
		
		for (int i = originalString.length() - 1; i >= 0; i--) {
			reverse = reverse + originalString.charAt(i);
		}
		return reverse;
	}
}
