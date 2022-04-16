package ProblemImplementations.NestedListWeightSum;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	private int maxDepth;
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
        int ret = 0;
        
        int depth = 1;
        
        ArrayList<ItemAndDepth> list = new ArrayList<ItemAndDepth>();
		
    	recurse(nestedList, depth, list);
    	
    	for(var itemAndDepth : list) {
    		int weight = maxDepth - itemAndDepth.getDepth() + 1;
    		ret += weight * itemAndDepth.getItem();
    	}
        
		return ret;
    }
	
	public void recurse(List<NestedInteger> nestedList, int depth, ArrayList<ItemAndDepth> list) {
		if(maxDepth < depth) {
			maxDepth = depth;
		}
		for(int i = 0; i < nestedList.size(); i++) {
        	var item = nestedList.get(i);
        	if(item.isInteger()) {
        		list.add(new ItemAndDepth(item.getInteger(), depth));
        		continue;
        	}
        	recurse(item.getList(), depth + 1, list);
        }
	}
	
	private class ItemAndDepth {
		public int item;
		public int depth;
		
		public ItemAndDepth(int _item, int _depth) {
			item = _item;
			depth = _depth;
		}
		
		public int getItem() {
			return item;
		}
		
		public int getDepth() {
			return depth;
		}
		
	} 
	
	
}
