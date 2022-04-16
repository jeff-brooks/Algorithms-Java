package RunnableExamples;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;

public class JCFBinSearchExample {
	public static void main(String[] args) {
		String[] names = {"Janet", "Michael", "Jack", "Nancy", "Andrew"
				, "Sarah", "Mark", "Mimi"};
		
		LinkedList<String> nameList = new LinkedList<String>();
		nameList.addAll(Arrays.asList(names));
		Collections.sort(nameList);
		
		String newName = "Maite";
		
		int loc = Collections.binarySearch(nameList, newName);
		
		if(loc < 0) {
			int insertLoc = -(loc+1);
			System.out.println(newName + " should be inserted into position " +
					 (insertLoc) + '\n');
			nameList.add(insertLoc, newName);
		}
		else {
			System.out.println(newName + " was found in location " + loc + '\n');
		}
	}

}
