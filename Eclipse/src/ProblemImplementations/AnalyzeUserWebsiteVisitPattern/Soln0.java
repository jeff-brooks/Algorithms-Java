package ProblemImplementations.AnalyzeUserWebsiteVisitPattern;

//import java.security.KeyPair;
//import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import DataStructures.PriorityQueue.PriorityQueue;

/*
 * h: 527896567
 * eiy: 334462937
 * cq: 517687281
 * h: 134127993
 * cq: 859112386
 * txldsscx: 159548699
 * cq: 51100299
 * txldsscx: 444082139
 * h: 926837079
 * cq: 317455832
 * cq:	411747930
 * 
 * 527896567: hibympufi
 * 334462937: hibympufi
 * 517687281: hibympufi
 * 134127993: hibympufi
 * 859112386: hibympufi
 * 159548699: hibympufi
 * 51100299: hibympufi
 * 444082139: hibympufi
 * 926837079: yljmntrclw
 * 317455832: hibympufi
 * 411747930: yljmntrclw
 * 
 * h pattern: 	134127993 -> 527896567 -> 926837079
 * 				hibympufi -> hibympufi -> yljmntrclw
 * cq pattern: 	517687281 -> 859112386 -> 51100299 -> 317455832 -> 411747930 
				hibympufi -> hibympufi -> hibympufi -> hibympufi -> yljmntrclw

 * 					
 * 					
 * 
 */
public class Soln0 {
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		var timeStampList = new ArrayList<Integer>();
		for(int i : timestamp) {
			timeStampList.add(i);
		}
		
		var allPatterns = new HashMap<Pattern, Integer>();
		
		var userTimestamp = new HashMap<String, ArrayList<Integer>>();
		for(int i = 0; i < username.length; i++) {
			var user = username[i];
			if(!userTimestamp.containsKey(user)) {
				userTimestamp.put(user,  new ArrayList<Integer>());
			}
			userTimestamp.get(user).add(timestamp[i]);
		}
		
		var userVisits = new HashMap<String, ArrayList<String>>();
		
		var utsIterator = userTimestamp.keySet().iterator();
		
		while(utsIterator.hasNext()) {
			var user = utsIterator.next();
			
			if(!userVisits.containsKey(user)) {
				userVisits.put(user,  new ArrayList<String>());
			}
			
			var times = userTimestamp.get(user).toArray();
			if(times.length < 3) {
				continue;
			}
			Arrays.sort(times);
			
			var uvList = userVisits.get(user);
			for(int i = 0; i < times.length ; i++) {
				var timesValue = times[i];
				var timestampIndex = timeStampList.indexOf(timesValue);
				uvList.add(website[timestampIndex]);
			}
		}
		
		var uvIterator = userVisits.keySet().iterator();
		while(uvIterator.hasNext()) {
			var user = uvIterator.next();
			
			var wsList = userVisits.get(user);
			
			if(wsList.size() == 3) {
				Pattern p = new Pattern(wsList.get(0), wsList.get(1), wsList.get(2));
				
				if(!allPatterns.containsKey(p)) {
					allPatterns.put(p, 0);
				}
				
				var patternCount = allPatterns.get(p);
				allPatterns.put(p, ++patternCount);
				continue;
			}
			
			if(wsList.size() < 3) {
				//how to handle? question of requirements
			}
			
			if(wsList.size() > 3) {
				ArrayList<Combination> usedCombinations = new ArrayList<Combination>();
				int firstIndex;
				int secondIndex;
				int thirdIndex;
				for(int i = 0; i < wsList.size() - 2; i++) {
					firstIndex = i;
					for(int j = i + 1; j < wsList.size() - 1; j++) {
						secondIndex = j;
						for(int k = j + 1; k < wsList.size(); k++) {
							thirdIndex = k;
							
							Combination c = new Combination(firstIndex, secondIndex, thirdIndex);
							if(usedCombinations.contains(c)) {
								continue;
							}
							
							usedCombinations.add(c);
							
							var p = new Pattern(wsList.get(firstIndex), wsList.get(secondIndex), wsList.get(thirdIndex));
							if(!allPatterns.containsKey(p)) {
								allPatterns.put(p, 0);
							}
							
							var patternCount = allPatterns.get(p);
							allPatterns.put(p, ++patternCount);
							continue;
						}
					}
				}
			}
		}
		
		Pattern mostUsedPattern = null;
		int patternCount = 0;
		
		var allPatternKeyIterator = allPatterns.keySet().iterator();
		while(allPatternKeyIterator.hasNext()) {
			var key = allPatternKeyIterator.next();
			if(mostUsedPattern == null) {
				mostUsedPattern = key;
				patternCount = allPatterns.get(key);
			}
			else if(allPatterns.get(key) > patternCount) {
				mostUsedPattern = key;
				patternCount = allPatterns.get(key);
			}
			else if(allPatterns.get(key) == patternCount) {
				if(key.compareTo(mostUsedPattern) < 0) {
					mostUsedPattern = key;
				}
			}
		}
		List<String> returnVal = new ArrayList<String>();
		returnVal.add(mostUsedPattern.ws1);
		returnVal.add(mostUsedPattern.ws2);
		returnVal.add(mostUsedPattern.ws3);
		return returnVal;
    }
	
	private class Combination {
		public int n1;
		public int n2;
		public int n3;
		
		public Combination(int a1, int a2, int a3) {
			n1 = a1;
			n2 = a2;
			n3 = a3;
		}
		
		@Override
		public int hashCode() {
			Integer sum = n1+n2+n3;
			return sum.hashCode();
		}
		
		@Override
		public boolean equals(Object o) {
			if(o == this) {return true;}
			if(!(o instanceof Combination)) {return false;}
			var c = (Combination)o;
			
			return this.n1 == c.n1 && this.n2 == c.n2 && this.n3 == c.n3;
		}
	}
	
	private class Pattern {
		public String ws1;
		public String ws2;
		public String ws3;
		
		public Pattern(String w1, String w2, String w3) {
			ws1 = w1;
			ws2 = w2;
			ws3 = w3;
		}
		
		@Override
		public int hashCode() {
			String s = ws1 + ws2 + ws3;
			return s.hashCode();
		}
		
		@Override
		public boolean equals(Object o) {
			if(o == this) {
				return true;
			}
			if(!(o instanceof Pattern)) {
				return false;
			}
			
			var p = (Pattern) o;
			
			return this.ws1.equals(p.ws1) && this.ws2.equals(p.ws2) && this.ws3.equals(p.ws3);
		}

		public int compareTo(Pattern p2) {
			if(!this.ws1.equals(p2.ws1)) {
				return this.ws1.compareTo(p2.ws1);
			}
			if(!this.ws2.equals(p2.ws1)) {
				return this.ws2.compareTo(p2.ws2);
			}
			return this.ws3.compareTo(p2.ws3);
		}
	}
}
