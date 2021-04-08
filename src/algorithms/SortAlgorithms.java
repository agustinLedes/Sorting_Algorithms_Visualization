package algorithms;

import java.io.File;

import kuusisto.tinysound.*;
import visualization.*;

public abstract class SortAlgorithms {
	protected static int moves = 0;
	protected static boolean Continue;
	protected static long delayTime = 5;
	private static Sound audio;
	private static boolean isMute = false;
	
	public static void mute(boolean x) {
		isMute = x;
	}
	
	public static boolean getAudioState() {
		return isMute;
	}
	
	protected void setSound() {
		try {
			TinySound.init();
			audio = TinySound.loadSound(new File("audio/soundFX.wav"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected int[] getSubArray(int[] arr, int begin, int size) {
		int res[] = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = arr[begin + i];
		}
		return res;
	}
	
	protected void updateArray(int[] array, FrameDisplay panel, int index, int value) {
		array[index] = value;
		moves++;
		
		if (!isMute) {
 			setSound();
			audio.play();
		}
		
		panel.paint(index);
		try {
			Thread.sleep(delayTime);
		}catch (Exception e) {}
	}
	
	protected void swap(int[] array, FrameDisplay panel, int firstIndex, int secondIndex) {
		int first = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = first;
		
		if (!isMute) {
			setSound();
			audio.play();
		}
		
		moves++;
		
		panel.paint(firstIndex, secondIndex);
		try {
			Thread.sleep(delayTime);
		}catch (Exception e) {}
	}
}
