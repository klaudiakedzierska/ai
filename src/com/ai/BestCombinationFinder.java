package com.ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.ai.config.ProgramConfig;
import com.ai.provider.AverageSpeedProvider;
import com.ai.provider.CustomerProvider;
import com.ai.provider.StartTimeProvider;

public class BestCombinationFinder {

	private RandomPopulationGenerator populationGenerator;
	private Selection selection;
	private Mutation mutation;
	private CrossPopulation crossPopulation;
	private AverageSpeedProvider speedProvider;
	private CustomerProvider customerProvider;
	private StartTimeProvider startTimeProvider;
	private Random random;
	private CostCalculator costCalculator;
	
	public BestCombinationFinder(){
		populationGenerator = new RandomPopulationGenerator();
		selection = new Selection();
		mutation = new Mutation();
		crossPopulation = new CrossPopulation();
		startTimeProvider = new StartTimeProvider();
		customerProvider = new CustomerProvider();
		speedProvider = new AverageSpeedProvider();
		random = new Random();
		costCalculator = new CostCalculator();
	}
	
	public void find(){
		Customer[] customers = customerProvider.createCustomerArray();
		List<int[]> population = populationGenerator.generateRandomPopulation(customers.length, ProgramConfig.CHILDREN);
		for (int i = 0 ; i < ProgramConfig.GENERATIONS; i++){
			List<int[]> populationAfterSelection = selection.select(customers, population, ProgramConfig.POPULATION_SIZE);
			List<int[]> populationAfterMutation = new ArrayList<>();
			
			for (int[] somebody : populationAfterSelection) {
				if(random.nextDouble() < 0.13){
					int[] newSomebody = mutation.mutuj(somebody);
					populationAfterMutation.add(newSomebody);
				}
				else{
					populationAfterMutation.add(somebody);
				}
			}
			List<int[]> populationAfterCross = new ArrayList<>();
			int index1 = 0;
			while(populationAfterCross.size() <= ProgramConfig.CHILDREN){
				int index2 = Double.valueOf(random.nextDouble() * (ProgramConfig.POPULATION_SIZE)).intValue();
				List<int[]> resultAfterCross = crossPopulation.cross(populationAfterMutation.get(index1), populationAfterMutation.get(index2), ProgramConfig.CHILD_PER_PARENTS);
				populationAfterCross.addAll(resultAfterCross);
				index1++;
			}
			
			int [] bestSequence = findBest(customers, populationAfterCross);
			
			population = populationAfterCross;
		}
		
	}

	private int[] findBest(Customer[] customers, List<int[]> populationAfterCross) {
		Collections.sort(populationAfterCross, (o1, o2) -> Long.valueOf(costCalculator.calculateCost(customers, o1))
				.compareTo(Long.valueOf(costCalculator.calculateCost(customers, o2))));
		System.out.println(costCalculator.calculateCost(customers, populationAfterCross.get(0)));
		
		for (int i : populationAfterCross.get(0)) {
			System.out.print(i + ", ");
		}
		return populationAfterCross.get(0);
	}
}
