import java.util.Arrays;
import java.util.Random;

public class Mutation {
	
	public int[] mutuj(int[] sequence){
		sequence = Arrays.copyOf(sequence, sequence.length);
		Random r = new Random();
		
		int lastIndex = sequence.length - 1;
		int firstIndex = r.nextInt(lastIndex);
		int secondIndex = firstIndex;
		
		while(firstIndex == secondIndex){
			secondIndex = r.nextInt(lastIndex);
		}
		
		swap(sequence, firstIndex, secondIndex);
		
		return sequence;
	}

	private void swap(int[] sequence, int firstIndex, int secondIndex) {
		int temp = sequence[firstIndex];
		sequence[firstIndex] = sequence[secondIndex];
		sequence[secondIndex] = temp;
	}
	
}
