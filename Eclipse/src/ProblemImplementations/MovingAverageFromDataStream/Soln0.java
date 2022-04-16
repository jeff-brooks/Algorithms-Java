package ProblemImplementations.MovingAverageFromDataStream;

import java.util.ArrayList;

/*
 * First take at an implementation.
 * 2 issues with this implementation:
 * 1) the list will grow without bound. Adjusting the contents of the array list will involve moving data elements to new locations. This is not ideal
 * 2) the list is iterated for a runtime on the order of the max size of the window. Would be better to not have to iterate the list to get the answer.
 */
public class Soln0 {
	private int windowStart = 0;
	private int windowStop = 0;
	private int windowSize;
	
	private ArrayList<Integer> list;
	
	public Soln0(int size) {
		windowSize = size;
		
		list = new ArrayList<Integer>();
	}
	
	public double next (int val) {
		if(windowStart + windowStop == windowSize - 1) {
			windowStart++;
			windowStop++;
		}
		else {
			windowStop++;
		}
		
		list.add(val);
		
		double sum = 0.0;
		for(int i = windowStart; i < windowStop; i++) {
			sum += list.get(i);
		}
		
		return sum / (windowStop - windowStart);
		
	}
}
