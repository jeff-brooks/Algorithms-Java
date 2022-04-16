package ProblemImplementations.WallsAndGates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Soln0 {
	private class Point{
		public int x;
		public int y;
		
		Point(int i, int j){
			x = i;
			y = j;
		}
		
		@Override
		public int hashCode() {
			Integer a = x;
			Integer b = y;
			return ((Integer)(a + b)).hashCode();
		}
		
		@Override
		public boolean equals(Object o) {
			if( this == o) {return true;}
			if( ! (o instanceof Point)) { return false;}
			Point p = (Point) o;
			return this.x == p.x && this.y == p.y;
		}
	}
	
	private Map<Point, ArrayList<Point>> visitedMap;
	
	public void wallsAndGates(int[][] rooms) {
		visitedMap = new HashMap<Point, ArrayList<Point>>();
	    for(int i = 0; i < rooms.length; i++) {
        	for(int j = 0; j < rooms[i].length; j++) {
        		if(rooms[i][j] == 0) {
        			//fill map from this point
        			Point gate = new Point(i, j);
        			if(!visitedMap.containsKey(gate)) {
        				visitedMap.put(gate,  new ArrayList<Point>());
        				fillMap(i, j, rooms, 0, gate);
        			}
        		}
        	}
        }
    }
	
	private void fillMap(int i, int j, int[][] rooms, int step, Point gate) {
//		//boundary checks
//		if(i < 0 || i >= rooms.length) {return;}
//		if(j < 0 || j >= rooms[0].length) {return;}
//		if(rooms[i][j] == -1) {
//			return;
//		}
		
//		Point p = new Point(i, j);
//		if(visitedMap.get(gate).contains(p)) {
//			return;
//		}
//		
//		visitedMap.get(gate).add(p);
//		
		//set distance from found gate
		if(rooms[i][j] > step ) {
			rooms[i][j] = step ;
		}
		
		//visit other locations
		if(canMove(i + 1, j, rooms)) {
			fillMap(i + 1, j, rooms, step + 1, gate);
		}
		if(canMove(i - 1, j, rooms)) {
			fillMap(i - 1, j, rooms, step + 1, gate);
		}
		if(canMove(i, j + 1, rooms)) {
			fillMap(i, j + 1, rooms, step + 1, gate);
		}
		if(canMove(i, j - 1, rooms)) {
			fillMap(i, j - 1, rooms, step + 1, gate);
		}
		
	}
	
	private boolean canMove(int i, int j, int[][] rooms) {
		if(i < 0 || i >= rooms.length) {return false;}
		if(j < 0 || j >= rooms[0].length) {return false;}
		int value = rooms[i][j];
		if(value < 1) {
			return false;
		}
		
		return true;
	}
}
