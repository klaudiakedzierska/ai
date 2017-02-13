import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class CostCalculatorTest {
	
	CostCalculator costCalculator = new CostCalculator();

	@Test
	public void test() {
		long expected = 700;
		Customer[] customers = new Customer[2];
		customers[0] = new Customer(40, 41, LocalDateTime.now());
		customers[1] = new Customer(0, 0, LocalDateTime.now());
		int[] sequence = {0,1};
		
		long result = costCalculator.calculateCost(customers, sequence);
		
		assertEquals(expected, result);
	}

}
