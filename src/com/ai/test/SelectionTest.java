package com.ai.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ai.Customer;
import com.ai.Selection;

public class SelectionTest {
	
	Selection selection = new Selection();

	@Test
	public void testSelection(){
		List<int[]> population = new ArrayList<>();
		int[] bestResult = new int[]{0, 1, 2, 3};
		
		population.add(new int[]{0, 2, 1, 3});
		population.add(new int[]{0, 3, 2, 1});
		population.add(bestResult);
		population.add(new int[]{0, 1, 3, 2});
		population.add(new int[]{0, 3, 1, 2});
		population.add(new int[]{3, 1, 0, 2});
		population.add(new int[]{0, 3, 2, 1});
		
		Customer[] customers = createCustomerArray();
		List<int[]> result = selection.select(customers , population , 1);
		
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(bestResult[0], result.get(0)[0]);
		Assert.assertEquals(bestResult[1], result.get(0)[1]);
		Assert.assertEquals(bestResult[2], result.get(0)[2]);
		Assert.assertEquals(bestResult[3], result.get(0)[3]);
	}
	
	@Test
	public void testSelectionTwo(){
		List<int[]> population = new ArrayList<>();
		int[] bestResult = new int[]{0, 1, 2, 3};
		int[] second = new int[]{0, 2, 1, 3};
		
		population.add(new int[]{0, 3, 2, 1});
		population.add(new int[]{0, 1, 3, 2});
		population.add(second);
		population.add(new int[]{0, 3, 1, 2});
		population.add(bestResult);
		population.add(new int[]{3, 1, 0, 2});
		population.add(new int[]{0, 3, 2, 1});
		
		Customer[] customers = createCustomerArray();
		List<int[]> result = selection.select(customers , population , 2);
		
		Assert.assertEquals(2, result.size());
		Assert.assertEquals(bestResult[0], result.get(0)[0]);
		Assert.assertEquals(bestResult[1], result.get(0)[1]);
		Assert.assertEquals(bestResult[2], result.get(0)[2]);
		Assert.assertEquals(bestResult[3], result.get(0)[3]);
		
		Assert.assertEquals(second[0], result.get(1)[0]);
		Assert.assertEquals(second[1], result.get(1)[1]);
		Assert.assertEquals(second[2], result.get(1)[2]);
		Assert.assertEquals(second[3], result.get(1)[3]);
	}                       

	private Customer[] createCustomerArray() {
		Customer[] customers = new Customer[4];
		customers[0] = new Customer(0, 0, LocalDateTime.now().plusHours(1));
		customers[1] = new Customer(10, 10, LocalDateTime.now().plusHours(1));
		customers[2] = new Customer(30, 30, LocalDateTime.now().plusHours(1));
		customers[3] = new Customer(80, 80, LocalDateTime.now().plusHours(1));
		return customers;
	}
}
