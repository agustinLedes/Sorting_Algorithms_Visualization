package algorithms;

import visualization.FrameDisplay;

public class QuickSort extends SortAlgorithms{
	private int[] array;
	private FrameDisplay panel;

	public QuickSort(int[] arr, FrameDisplay p) {
		moves = 0;
		array = arr;
		panel = p;
		QuickSortRun();
	}
	
	private int sortAndPartition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int j = left-1;
		for (int i = left; i < right && Continue; i++) {
			if (arr[i] < pivot && Continue) {
				j++;
				swap(array, panel, i, j);
			}
		}
		if (Continue)
			swap(array, panel, j+1, right);
		return j+1;
	}
	
	private void Quick(int[] arr, int left, int right) {
		if (left < right) {
			int partition = sortAndPartition(arr, left, right);
			
			Quick(arr, left, partition-1);
			Quick(arr, partition+1, right);
		}
		
	}
	
	public void QuickSortRun() {
		Quick(array, 0, array.length-1);
		panel.paint(-1);
	}
	
}
