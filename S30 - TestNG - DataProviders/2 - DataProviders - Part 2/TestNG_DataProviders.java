package testclasses;

//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProviders {
	
//	@DataProvider(name="inputs")
//	public Object[][] getData() {
//		return new Object[][] {
//			{"bmw", "m3"},
//			{"audi", "a6"},
//			{"benz", "c300"}
//		};
//	}
	
	@Test(dataProvider="inputs", dataProviderClass=TestData.class)
	public void testMethod1(String input1, String input2) {
		System.out.println("Input 1: " + input1);
		System.out.println("Input 2: " + input2);
	}
}