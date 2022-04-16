package ProblemImplementations.MovingAverageFromDataStream;

import java.util.Queue;
import java.util.LinkedList;

/*
 * Final solution.
 * Calculates the sum as the window is built out. 
 * When the max list size is reached, subtracts the item that leaves the window from the sum
 * and adds in the new value. Eliminating the need to iterate a collection to calculate 
 * the sum.
 */
public class MovingAverage {
	private int maxSize;
	private Queue<Integer> queue;
	private int listSize;
	private double sum;
	
	public MovingAverage(int size) {
        maxSize = size;
        queue = new LinkedList<Integer>();
        listSize = 0;
        sum = 0.0;
    }
    
    public double next(int val) {
        if(listSize == maxSize) {
        	sum -= queue.remove();
        }
        else {
        	listSize++;
        }
        queue.add(val);
        sum += val;
        return sum / listSize;
    }
}
