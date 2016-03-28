package Calulation;


import org.junit.Test;

public class CalculateTest {
	
		
	@Test
	public void testCalculate() {
		//    System.out.println("²âÊÔ");
		//Calculate cc = new Calculate();
		double test = Calculate.CompoundingCalculation(10000, 0.03, 10);
		System.out.println("¸´Àû²âÊÔ½á¹û"+test);
	}

}
