package algorithms;

import visualization.FrameDisplay;

public class BubbleSort extends SortAlgorithms {
	private int[] array;
	private FrameDisplay panel;
	
	public BubbleSort(int[] arr, FrameDisplay p) {
		moves = 0;
		array = arr;
		panel = p;
		
		BubbleSortRun();
	}
	
	public final void BubbleSortRun() {
		int n = array.length; 
		for (int i = 0; i < n-1 && Continue; i++) 
			for (int j = 0; j < n-i-1 && Continue; j++) {
				if (array[j] > array[j+1] && Continue) { 
					swap(array, panel, j, j+1);
				}
			}
		panel.paint(-1);
	}
	
}
