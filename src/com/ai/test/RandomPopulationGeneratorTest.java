import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class RandomPopulationGeneratorTest {
	
	private static final int ONE_RESULT = 1;
	private static final int FIRST_ELEMENT = 0;
	private static final int SIZE = 10;
	private static final int SEQUENCE = 10;
	private static final int INCORRECT_SIZE = -10;
	private static final int INCORRECT_SEQUENCE = -10;
	private RandomPopulationGenerator generator = new RandomPopulationGenerator();

	@Test
	public void testGenerator(){
		Set<Integer> firstElements = new HashSet<>();
		List<int[]> population = generator.generateRandomPopulation(SIZE, SEQUENCE);
		
		for (int[] sequence : population) {
			firstElements.add(sequence[FIRST_ELEMENT]);
			System.out.println(Arrays.toString(sequence));
		}
		
		assertTrue(firstElements.size() > ONE_RESULT);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectSize(){
		generator.generateRandomPopulation(INCORRECT_SIZE, SEQUENCE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectSequenceNumber(){
		generator.generateRandomPopulation(SIZE, INCORRECT_SEQUENCE);
	}
}
