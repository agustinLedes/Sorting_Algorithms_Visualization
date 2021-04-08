package algorithms;

import visualization.*;

public class SortRun extends SortAlgorithms implements Runnable{

	private String toUseAlgorithm;
	private int[] array;
	private FrameDisplay panel;
	
	public SortRun(int[] arr, FrameDisplay p, String algo) {
		array = arr;
		panel = p;
		toUseAlgorithm = algo;
	}
	
	public String currentAlgorithm() {
		return toUseAlgorithm;
	}
	
	@Override
	public void run() {
		if (toUseAlgorithm.contains("Bubble"))
			new BubbleSort(array, panel);
		else if (toUseAlgorithm.contains("Insertion"))
			new InsertionSort(array, panel);
		else if (toUseAlgorithm.contains("Selection"))
			new SelectionSort(array, panel);
		else if (toUseAlgorithm.contains("Merge"))
			new MergeSort(array, panel);
		else if (toUseAlgorithm.contains("Quick"))
			new QuickSort(array, panel);
		else if (toUseAlgorithm.contains("Heap"))
			new HeapSort(array, panel);
		else if (toUseAlgorithm.contains("Shell"))
			new ShellSort(array, panel);
		else if (toUseAlgorithm.contains("Gnome"))
			new GnomeSort(array, panel);
		else if (toUseAlgorithm.contains("Cocktail"))
			new CocktailSort(array, panel);
	}
	
	public static void toContinue (boolean cont) {
		Continue = cont;
	}

	public String getMovesPerformed() {
		return Integer.toString(moves);
	}

	public String getDelayTime() {
		return Long.toString(delayTime);
	}

	public void setDelayTime(int time) {
		delayTime = time;
	} 

	
}
