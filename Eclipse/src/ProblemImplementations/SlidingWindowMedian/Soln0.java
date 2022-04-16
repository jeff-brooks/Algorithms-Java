package ProblemImplementations.SlidingWindowMedian;

import java.util.ArrayList;
import java.util.Arrays;

public class Soln0 {
	public static double[] medianSlidingWindow(int[] nums, int k) {
		boolean isEven = k % 2 == 0;
		int half = k/2;
		ArrayList<Double> list = new ArrayList<Double>();
		for(int i = 0; i + k - 1 < nums.length; i++) {
			int[] windowValues = new int[k];
			for(int j = i; j < i + k; j++) {
				windowValues[j - i] = nums[j];
			}
			
			Arrays.sort(windowValues);
			
			if(isEven) {
				double first = windowValues[half - 1];
				double second = windowValues[half];
				list.add((first + second) / 2);
			}
			else {
				list.add((double)windowValues[half]);
			}
		}
		
		double[] array = new double[list.size()];
		for(int l = 0; l < list.size(); l++) {
			array[l] = list.get(l);
		}
		
		return array;
	}
}
