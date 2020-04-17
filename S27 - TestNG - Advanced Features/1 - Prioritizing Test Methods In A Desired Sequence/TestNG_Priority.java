package testclasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Prioritiy {
	
	@BeforeClass
	public void setUp() {
		System.out.println("TestNG_Prioritiy -> before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("TestNG_Prioritiy -> after class");
	}
	
	@Test(priority=2)
	public void testMethod1() {
		System.out.println("TestNG_Prioritiy -> testMethod1");
	}
	
	@Test(priority=1)
	public void testMethod2() {
		System.out.println("TestNG_Prioritiy -> testMethod2");
	}
	
	@Test(priority=0)
	public void testMethod3() {
		System.out.println("TestNG_Prioritiy -> testMethod3");
	}
}