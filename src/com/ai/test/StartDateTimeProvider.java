package com.ai.test;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

import com.ai.provider.StartTimeProvider;

public class StartDateTimeProvider {
	
	private StartTimeProvider provider = new StartTimeProvider();
	
	@Test
	public void testFile(){
		LocalDateTime result = provider.provide();
		
		Assert.assertEquals(2017, result.getYear());
		Assert.assertEquals(Month.FEBRUARY, result.getMonth());
		Assert.assertEquals(13, result.getDayOfMonth());
		Assert.assertEquals(16, result.getHour());
		Assert.assertEquals(59, result.getMinute());
	}
}
