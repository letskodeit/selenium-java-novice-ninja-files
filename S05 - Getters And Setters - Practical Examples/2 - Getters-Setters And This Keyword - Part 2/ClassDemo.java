package oopconcepts;

public class ClassDemo {

	public static void main(String[] args) {
		Car bmw = new Car(); // Create and initialize the object
		bmw.setMake("BMW");
		System.out.println(bmw.getMake());
		
		Car benz = new Car();
		benz.setMake("Benz");
		System.out.println(benz.getMake());
		
		benz.setModel("c300");
		System.out.println(benz.getModel());
		
		benz.setYear(2020);
		System.out.println(benz.getYear());
	}
}