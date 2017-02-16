package com.ai.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.ai.Customer;
import com.ai.provider.DistanceCalculator;
//TODO klaudia: porob dodatkowe testy: przypadki brzegowe
public class DistanceCalculatorTest {
	
	private static final int DELTA = 0;
	DistanceCalculator distanceCalculator = new DistanceCalculator();

	@Test
	public void testBasicCase() {
		//given
		Customer from = new Customer(3, 4, null);
		Customer to = new Customer(0, 0, null);
		double expectedResult = 5;
		
		//when
		double result = distanceCalculator.calculate(from, to);
		
		//then
		assertEquals(expectedResult, result, DELTA);
	}
	
	@Test
	public void testZero() {
		//given
		Customer from = new Customer(0, 0, null);
		Customer to = new Customer(0, 0, null);
		double expectedResult = 0;
		
		//when
		double result = distanceCalculator.calculate(from, to);
		
		//then
		assertEquals(expectedResult, result, DELTA);
	}

}
