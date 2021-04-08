package algorithms;

import visualization.FrameDisplay;

public class ShellSort extends SortAlgorithms{
	private int[] array;
	private FrameDisplay panel;

	public ShellSort(int[] arr, FrameDisplay p) {
		moves = 0;
		array = arr;
		panel = p;
		ShellSortRun();
	}
	
	protected void ShellSortRun() {
		int n = array.length;
		for (int interval = n/2; interval > 0 && Continue; interval /= 2) {
			for (int i = interval; i < n && Continue; i++) {
				int temp = array[i];
				for (int j = i; j >= interval && array[j - interval] > temp; j -= interval) {
					swap(array, panel, j, j-interval);
				}
			}
			panel.paint(-1);
		}
	}
}

