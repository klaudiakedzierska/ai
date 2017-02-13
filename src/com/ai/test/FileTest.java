package com.ai.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ai.DataLoader;


public class FileTest {
	
	private static final String SPEED_50 = ":speed-50";
	private DataLoader file = new DataLoader("test.txt");
	
	@Test
	public void testFile(){
		List<String> result = file.read();
		
		Assert.assertEquals(SPEED_50, result.get(0));
	}
}
