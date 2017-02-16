package com.ai.test;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.ai.CrossPopulation;

public class CrossPopulationTest {
	
	CrossPopulation crossPopulation = new CrossPopulation();

	@Test
	public void testCrossPopulation(){
		
		int[] sequence1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] sequence2 = {5, 3, 4, 1, 2, 0, 10, 6, 8, 7, 9};
		List<int[]> result = crossPopulation.cross(sequence1, sequence2, 3);
		
		assertEquals(3, result.size());
	}
	
	@Test
	public void testIfDoesntCreateDuplicates(){
		
		int[] sequence1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 13, 15, 16};
		int[] sequence2 = {5, 3, 4, 1, 2, 0, 10, 6, 8, 7, 9, 16, 15, 14, 12, 13, 11};
		List<int[]> result = crossPopulation.cross(sequence1, sequence2, 50);
		
		for (int[] sequence : result) {
			Set<Integer> sequenceSet = new HashSet<>();
			for (int element : sequence) {
				sequenceSet.add(element);
			}
			
			assertEquals(sequence1.length, sequenceSet.size());
		}
	}
}
