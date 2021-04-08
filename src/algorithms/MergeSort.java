package algorithms;

import visualization.FrameDisplay;

public class MergeSort extends SortAlgorithms{
	private int[] array;
	private FrameDisplay panel;	

	public MergeSort(int[] arr, FrameDisplay p) {
		moves = 0;
		array = arr;
		panel = p;
		MergeSortRun();
	}
	
	private void sort(int[] arr, int left, int right) {
		if (left < right) {
			int middleIndex = (left + right) / 2;
			sort(arr, left, middleIndex);
			sort(arr, middleIndex + 1, right);
			merge(arr, left, middleIndex, right);
		}
	}
	
	private void merge(int[] arr, int left, int middle, int right) {
		int leftSize = middle - left + 1;
		int rightSize = right - middle;

		int leftArray[] = getSubArray(array, left, leftSize);
		int rightArray[] = getSubArray(array, middle + 1, rightSize);

		int i = 0, j = 0, k = left;
		while (i < leftSize && j < rightSize && Continue) {
			if (leftArray[i] <= rightArray[j]) {
				updateArray(array, panel, k, leftArray[i]);
				i++;
			} else {
				updateArray(array, panel, k, rightArray[j]);
				j++;
			}
			k++;
		}

		while (i < leftSize && Continue) {
			updateArray(array, panel, k, leftArray[i]);
			i++;
			k++;
		}

		while (j < rightSize && Continue) {
			updateArray(array, panel, k, rightArray[j]);
			j++;
			k++;
		}
	}
	
	public void MergeSortRun() {
		sort(array, 0, array.length-1);
		panel.paint(-1);
	}
	
}
