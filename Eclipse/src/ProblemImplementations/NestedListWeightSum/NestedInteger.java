package ProblemImplementations.NestedListWeightSum;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger extends AbstractNestedInteger  {
	private Integer integer = null;
	private List<NestedInteger> list = null;

	// Constructor initializes an empty nested list.
	public NestedInteger() {
		list = new ArrayList<NestedInteger>();
	}
 
    // Constructor initializes a single integer.
    public NestedInteger(int value) {	
    	integer = value;
    }
	    
	@Override
	public boolean isInteger() {
		// TODO Auto-generated method stub
		return integer != null;
	}

	@Override
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return integer;
	}

	@Override
	public void setInteger(int value) {
		// TODO Auto-generated method stub
		integer = value;
	}

	@Override
	public void add(NestedInteger ni) {
		// TODO Auto-generated method stub
		list.add(ni);
	}

	@Override
	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return list;
	}

}
