package oopconcepts;

public class AddingMethods {
	
	public static void main(String[] args) {
		findGrades("John", 90);
		findGrades("Tom", 80);
	}
	
	public static void findGrades(String studentName, int score) {
		String grade;
		if (score >= 90 && score <= 100) {
			grade = "A";
		} else if (score >= 80 && score < 90) {
			grade = "B";
		} else if (score >= 70 && score < 80) {
			grade = "C";
		} else {
			grade = "D";
		}
		System.out.println("Grade of " + studentName + " is: " + grade);
	}
	
	
	
	
	
	
	
	
}