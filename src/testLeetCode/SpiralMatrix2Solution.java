package testLeetCode;

public class SpiralMatrix2Solution {
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        init( res );
        
        int[][] steps = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int direction = 0;
        int x = 0;
        int y = 0;
        int count = 1;
        
        while( count <= n*n ) {
        	if( res[x][y] == 0 ){
        		res[x][y] = count;
        		boolean ok = false;
        		
        		while( !ok && count < n*n ){
        			int newX = x + steps[direction][0];
        			int newY = y + steps[direction][1];
        			
        			if ( newX > -1 && newX < n && 
        					newY > -1 && newY < n && 
        					res[newX][newY] == 0 ) {
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
        
        return res;
    }
	
	private void init( int[][] matrix ) {
		for( int[] row : matrix ) {
			for ( int item : row ) {
				item = 0;
			}
		}
	}
}
