package ProblemImplemenations.RobotBoundedInCircle;

public class Soln0 {
	private static enum direction {
		north, east, south, west;
		private static direction[] vals = values();
		public static direction clockWise() {
			if(currentDirection.ordinal() == vals.length - 1) {
				return vals[0];
			}
			return vals[currentDirection.ordinal() + 1];
		}
		public static direction counterClockWise() {
			if(currentDirection.ordinal() == 0) {
				return vals[vals.length - 1];
			}
			return vals[currentDirection.ordinal() - 1];
		}
	};
	private static direction currentDirection;
	
	public static boolean isRobotBounded(String instructions) {
		
        if(instructions.length() == 0) {
        	return true;
        }
        //would an odd number of instructions equate to a non-circular path?
        //  if-so that could be used for an early return
        
        currentDirection = direction.north;
        int[]  currentPosition = {0, 0};
        
        for(int i = 0; i < instructions.length(); i++) {
        	char instruction = instructions.charAt(i);
        	
        	if(instruction == 'L') {
        		currentDirection = currentDirection.counterClockWise(); 
        		continue;
        	}
        	if(instruction == 'R') {
        		currentDirection = currentDirection.clockWise();
        		continue;
        	}
        	
        	if(instruction == 'G') {
        		if(currentDirection == direction.north) {
        			currentPosition[1]++;
        			continue;
        		}
        		if(currentDirection == direction.south) {
        			currentPosition[1]--;
        			continue;
        		}
        		if(currentDirection == direction.east) {
        			currentPosition[0]++;
        			continue;
        		}
        		currentPosition[0]--;
        	}
        }
        boolean hasNotMoved = currentPosition[0] == 0 && currentPosition[1] == 0;
        boolean facingNorth = currentDirection == direction.north;
        return hasNotMoved || !facingNorth;
    }
}
