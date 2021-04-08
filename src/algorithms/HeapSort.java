package algorithms;

import visualization.FrameDisplay;

public class HeapSort extends SortAlgorithms{
	private int[] array;
	private FrameDisplay panel;
	
	protected void heapify(int[] arr, int n, int i) {
		
		int maxIndex = i;
		int leftChild = 2*i + 1, rightChild = 2*i + 2;
		
		if (leftChild < n && arr[leftChild] > arr[maxIndex]) 
			maxIndex = leftChild;
		
		if (rightChild < n && arr[rightChild] > arr[maxIndex]) 
			maxIndex = rightChild;
		
		if (maxIndex != i) {
			swap(array, panel, i, maxIndex);
			heapify(arr, n, maxIndex);
		}	
		
	}
	
	public void HeapSortRun() {
		int size = array.length;
		
		for (int i = size/2 - 1; i >= 0 && Continue; i--) {
			heapify(array, size, i);
		}
		
		for (int j = size-1; j > 0 && Continue; j--) {
			swap(array, panel, j, 0);
			heapify(array, j, 0);
		}	
		panel.paint(-1);
	}
	
	public HeapSort(int[] arr, FrameDisplay p) {
		moves = 0;
		array = arr;
		panel = p;
		HeapSortRun();
	}
	
}
