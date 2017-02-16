package com.ai.test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

import com.ai.Mutation;

public class MutationTest {
	Mutation mutation = new Mutation();

	@Test
	public void testMutation(){
		int[] sequence = IntStream.range(0, 10).toArray();
		int[] mutedSequence = mutation.mutuj(sequence);
		
		assertFalse(Arrays.equals(sequence, mutedSequence));
	}
}
