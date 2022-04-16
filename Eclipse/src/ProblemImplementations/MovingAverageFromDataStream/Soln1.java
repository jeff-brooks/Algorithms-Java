package ProblemImplementations.MovingAverageFromDataStream;

import java.util.LinkedList;

/*
 * Addresses 1 shortcoming of Soln0 by using a Linked List instead of an array list.
 * The linked list will not have to move elements within the collection to trim the list, 
 * rather it just updates references.
 * 
 * It still uses iteration to calculate the sum.
 */
public class Soln1 {
	private LinkedList<Integer> list;
	private int listSize;
	private int maxSize;
	
	public Soln1(int size) {
        list = new LinkedList<Integer>();
        maxSize = size;
        listSize = 0;
    }
    
    public double next(int val) {
        if(listSize < maxSize) {
        	listSize++;
        }
        else {
        	list.removeFirst();
        }
        list.add(val);
        
        var iterator = list.iterator();
        double sum = 0.0;
        
        while(iterator.hasNext()) {
        	sum += iterator.next();
        }
        
        return sum / listSize;
    }
}
