package com.ai;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.ai.provider.AverageSpeedProvider;
import com.ai.provider.DistanceCalculator;
import com.ai.provider.StartTimeProvider;

public class CostCalculator
{	
	private static final int SECONDS_IN_HOUR = 3600;

	private DistanceCalculator distanceCalculator;
	
	private StartTimeProvider startTimeProvider;
	
	private AverageSpeedProvider averageSpeedProvider;
	
	
	public CostCalculator() {
		distanceCalculator = new DistanceCalculator();
		startTimeProvider = new StartTimeProvider();
		averageSpeedProvider = new AverageSpeedProvider();
		
	}

	public long calculateCost(Customer[] customers, int[] sequence)
	{
		long cost = 0;
		LocalDateTime startTime = startTimeProvider.provide();
		double averageSpeed = averageSpeedProvider.provide();
		
		for (int i = 0; i < sequence.length-1; i++) {
			int index = sequence[i];
			int index2 = sequence[i + 1];
			Customer fromCustomer = customers[index];
			Customer toCustomer = customers[index2];
			
			double distance = distanceCalculator.calculate(fromCustomer, toCustomer);
			int seconds = calculateSeconds(averageSpeed, distance);
			
			startTime = startTime.plusSeconds(seconds);
			
			if(startTime.isAfter(toCustomer.getEndTime()))
			{		
				long hours = toCustomer.getEndTime().until(startTime, ChronoUnit.HOURS);
				cost = cost + hours * 100;
			}
		}
		
		return cost;
	}

	private int calculateSeconds(double averageSpeed, double distance) {
		Double time = distance/averageSpeed;
		time = time * SECONDS_IN_HOUR;
		int seconds = time.intValue();
		return seconds;
	}

}
