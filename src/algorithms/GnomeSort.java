package algorithms;

import visualization.FrameDisplay;

public class GnomeSort extends SortAlgorithms{
	private int[] array;
	private FrameDisplay panel;	

	public GnomeSort(int[] arr, FrameDisplay p) {
		moves = 0;
		array = arr;
		panel = p;
		GnomeSortRun();
	}
	
	protected void GnomeSortRun() {
		int n = array.length, i = 1;
		while (i < n && Continue) {
			if (i == 0) 
				i++;
			if (array[i] >= array[i-1]) {
				i++;
			}else {
				swap(array, panel, i,i-1);
				i--;
			}
		}
		panel.paint(-1);
	}
}
