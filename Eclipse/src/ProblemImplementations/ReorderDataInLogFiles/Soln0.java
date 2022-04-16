package ProblemImplementations.ReorderDataInLogFiles;

import java.util.*;

public class Soln0 {
	public static class letterLog implements Comparable<letterLog> {
		private String id;
		private String words;
		public String log;
		
		public letterLog(String Id, String Words) {
			id = Id;
			words = Words;
			log = Id + " " + Words;
		}

		@Override
		public int compareTo(letterLog l) {
			if(this.words.equals(l.words)) {
				return this.id.compareTo(l.id);
			}
			return this.words.compareTo(l.words);
		}
	}
	public static String[] reorderLogFiles(String[] logs) {
		TreeSet<letterLog> letterLogs = new TreeSet<letterLog>();
		ArrayList<String> digitLogs = new ArrayList<String>();
		
		for(int i = 0; i < logs.length; i++) {
			String log = logs[i];
			String[] split = log.split(" ");
			String id = split[0]; 
			String words = log.substring(id.length() + 1, log.length()); 
			char firstLetter = words.charAt(0);
			switch(firstLetter) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					digitLogs.add(log);
					break;
				default:
					letterLogs.add(new letterLog(id, words));
					
			}
		}
		
		List<String> returnVal = new ArrayList<String>();
		
		var llIterator = letterLogs.iterator();
		while(llIterator.hasNext()){
			returnVal.add(llIterator.next().log);
		}
		

		for(var digit : digitLogs) {
			returnVal.add(digit);
		}
		
		return returnVal.toArray(new String[0]);
		
	}
}
