package com.ai;

import java.util.List;
import java.util.stream.Collectors;

public class Selection {
	
	CostCalculator calculator;
	
	public Selection(){
		calculator = new CostCalculator();
	}

	public List<int[]> select(Customer[] customers, List<int[]> population, int newSize){
		List<int[]> newPopulation = population.stream()
		.sorted((o1, o2) -> compareCost(customers, o1, o2))
		.collect(Collectors.toList()).subList(0, newSize);
		
		return newPopulation;
	}

	private int compareCost(Customer[] customers, int[] o1, int[] o2) {
		return Long.valueOf(calculator.calculateCost(customers, o1)).compareTo(calculator.calculateCost(customers, o2));
	}
}
