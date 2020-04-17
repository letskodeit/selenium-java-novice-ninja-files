package testclasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_TestClass2 {

	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_TestClass2 -> This runs once before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_TestClass2 -> This runs once after class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_TestClass2 -> This runs before every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_TestClass2 -> This runs after every method");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("\nRunning Test -> TestNG_TestClass2 -> testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("\nRunning Test -> TestNG_TestClass2 -> testMethod2");
	}
}