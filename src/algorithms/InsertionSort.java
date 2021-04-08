package algorithms;

import visualization.FrameDisplay;

public class InsertionSort extends SortAlgorithms{
	private int[] array;
	private FrameDisplay panel;
	
	public InsertionSort(int[] arr, FrameDisplay p) {
		moves = 0;
		array = arr;
		panel = p;
		InsertionSortRun();
	}
	
	public final void InsertionSortRun () {
		for (int i = 1; i < array.length && Continue; i ++) {
			for (int j = i; j > 0 && Continue; j--) {
				if (array[j] < array[j-1]) {
					swap(array, panel, j,j-1);
				}else {
					break;
				}
			}
		}
		panel.paint(-1);
	}
	
}
