package ProblemImplementations.RansomNote;

import java.util.*;

public class Soln0 {
	public boolean canConstruct(String ransomNote, String magazine) {
	    Map<Character, Integer> available = new HashMap<Character, Integer>();
	    for(int i = 0; i < magazine.length(); i++) {
	    	char c = magazine.charAt(i);
	    	if(!available.containsKey(c)) {
	    		available.put(c, 0);
	    	}
	    	Integer count = available.get(c);
	    	available.put(c, ++count);
	    }
	    
	    for(int j = 0; j < ransomNote.length(); j++) {
	    	//check for existence
	    	char c = ransomNote.charAt(j);
	    	if(!available.containsKey(c)) {
	    		return false;
	    	}
	    	
	    	//decrement
	    	Integer count = available.get(c);
	    	if(count == 1) {
	    		available.remove(c);
	    		continue;
	    	}
	    	available.put(c, --count);
	    }
	    return true;
    }
}
