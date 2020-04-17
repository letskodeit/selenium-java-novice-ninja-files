package testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import appcode.SomeClassToTest;

public class TestNG_DependentTests {
	
	SomeClassToTest obj;
	
	@BeforeClass
	public void setUp() {
		obj = new SomeClassToTest();
		System.out.println("before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("after class");
	}
	
	@Test(dependsOnMethods={ "testMethod2" }, alwaysRun=true)
	public void testMethod1() {
		System.out.println("testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("testMethod2");
		int result = obj.sumNumbers(1, 2);
		Assert.assertEquals(result, 2);
	}
	
	@Test(dependsOnMethods={ "testMethod1" })
	public void testMethod3() {
		System.out.println("testMethod3");
	}
	
	@Test
	public void testMethod4() {
		System.out.println("testMethod4");
	}
}