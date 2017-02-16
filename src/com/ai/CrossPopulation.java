package com.ai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CrossPopulation {
	
	Random random = new Random();
	
	public List<int[]> cross(int[] sequence1, int[] sequence2, int childrenNumber){
		int length = sequence1.length;
		List<int[]> children = new ArrayList<>();
		
		for(int i = 0; i < childrenNumber; i++){
			children.add(createChild(sequence1, sequence2, length));
		}
		
		return children;
	}

	private int[] createChild(int[] sequence1, int[] sequence2, int length) {
		int[] childSequence = new int[length];
		Arrays.fill(childSequence, -1);
		
		int[] consideredSequence = null; 
		
		List<Integer> notUsedElements = new ArrayList<>();
		for(int elemenentOfChildSequence = 0; elemenentOfChildSequence < length; elemenentOfChildSequence++){
			consideredSequence = determineConsideredParent(sequence1, sequence2);
			
			setElementToChild(childSequence, consideredSequence, notUsedElements, elemenentOfChildSequence);
		}
		fillNotFilledElements(childSequence, notUsedElements);
		
		return childSequence;
	}

	private int[] determineConsideredParent(int[] sequence1, int[] sequence2) {
		int[] consideredSequence;
		if(random.nextDouble() < 0.5){
			consideredSequence = sequence1;
		}
		else{
			consideredSequence = sequence2;
		}
		return consideredSequence;
	}

	private void setElementToChild(int[] childSequence, int[] consideredSequence, List<Integer> notUsedElements,
			int elemenentOfChildSequence) {
		for (int j = 0; j < consideredSequence.length; j++) {
			int parentElement = consideredSequence[j];
			
			if(parentElement == elemenentOfChildSequence){
				if(childSequence[j] == -1){
					childSequence[j] = elemenentOfChildSequence;
				}
				else{
					notUsedElements.add(elemenentOfChildSequence);
				}
			}
		}
	}

	private void fillNotFilledElements(int[] childSequence, List<Integer> notUsedElements) {
		Collections.shuffle(notUsedElements);
		
		for (Integer notUsedElement : notUsedElements) {
			for (int i = 0; i < childSequence.length; i++) {
				if(childSequence[i] == -1){
					childSequence[i] = notUsedElement;
					break;
				}
			}
		}
	}
}
