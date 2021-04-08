package algorithms;

import visualization.FrameDisplay;

public class SelectionSort extends SortAlgorithms{
	private int[] array;
	private FrameDisplay panel;	

	public SelectionSort(int[] arr, FrameDisplay p) {
		moves = 0;
		array = arr;
		panel = p;
		SelectionSortRun();
	}

	public final void SelectionSortRun () {
		for (int i = 0; i < array.length && Continue; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = i; j < array.length && Continue; j++) {
				if (array[j] < min) { 
					moves++;
					min = array[j];
					index = j;
				}
			}
			swap(array, panel, i, index);
		}
		panel.paint(-1);
	}
	
}
