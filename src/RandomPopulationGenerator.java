import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPopulationGenerator {

	public List<int[]> generateRandomPopulation(int customerAmount, int sequenceNumber){
		checkArguments(customerAmount, sequenceNumber);
		
		List<int[]> createdSequences = new ArrayList<>(sequenceNumber);
		List<Integer> sequence = IntStream.range(0, customerAmount).boxed().collect(Collectors.toList()); // stworzenie
		// listy integerow od 0 do customer amount -1 czyli np gdy customer amount = 3 to lista ma [0 , 1, 2]
		
		for (int i = 0; i < sequenceNumber; i++){
			createdSequences.add(createNewSequnce(sequence));
		}
		
		return createdSequences;
	}

	private void checkArguments(int size, int sequenceNumber) {
		if(size < 1){
			throw new IllegalArgumentException("size must be greater than 0");
		}
		
		if(sequenceNumber < 1){
			throw new IllegalArgumentException("sequence number must be greater than 0");
		}
	}
	
	private int[] createNewSequnce(List<Integer> sequenceList){
		Collections.shuffle(sequenceList);
		int[] mixedSequence = sequenceList.stream().mapToInt(i -> i).toArray();
		
		return mixedSequence;
	}
	
}
