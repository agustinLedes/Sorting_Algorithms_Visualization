package algorithms;

import visualization.FrameDisplay;

public class CocktailSort extends SortAlgorithms{
	private int[] array;
	private FrameDisplay panel;
	
	public CocktailSort(int[] arr, FrameDisplay p) {
		moves = 0;
		array = arr;
		panel = p;
		CocktailSortRun();
	}

protected void CocktailSortRun() {
		
		boolean travel = true;
		int start = 0, end = array.length-1;
		
		while (travel && Continue) {
			
			travel = false;
			
			for (int i = start; i < end - 1 && Continue; i++) {
				if (array[i] > array[i+1]) {
					swap(array, panel, i, i+1);
					travel = true;
				}
			}
			
			if (!travel) 
				break;
			
			end--;
			
			for (int j = end-1; j >= start && Continue; j--) {
				if (array[j] > array[j + 1]) {
					swap(array, panel, j, j+1);
					travel = true;
				}
			} 
			
			start++;
			
		}
		panel.paint(-1);
		
	}
	
}
