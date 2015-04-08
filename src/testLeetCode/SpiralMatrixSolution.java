package testLeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixSolution {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if ( matrix.length != 0 && matrix[0].length != 0) {
	        boolean[][] checked = new boolean[matrix.length][matrix[0].length];
	        int[][] steps = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	        int direction = 0;
	        int x = 0;
	        int y = 0;
	        int count = 0;
	        init( checked );
	        
	        while( count < matrix.length * matrix[0].length ) {
	        	if( !checked[x][y] ){
	        		res.add(matrix[x][y]);
	        		
	        		checked[x][y] = true;
	        		boolean ok = false;
	        		
	        		while( !ok && count < matrix.length * matrix[0].length - 1 ){
	        			int newX = x + steps[direction][0];
	        			int newY = y + steps[direction][1];
	        			
	        			if ( newX > -1 && newX < matrix.length && 
	        					newY > -1 && newY < matrix[0].length && 
	        					!checked[newX][newY] ) {
	        				// the move is ok
	        				ok = true;
	        				x = newX;
	        				y = newY;
	        			} else {
	        				// the move is not ok, so change direction
	        				ok = false;
	        				direction = ( direction + 1 ) % steps.length;
	        			}
	        		}
	        	}
	        	++count;
	        }
        }
        
        return res;
    }
	
	private void init( boolean[][] checked ) {
		for( boolean[] row : checked ) {
			for( boolean element : row ) {
				element = false;
			}
		}
	}
}
