package testLeetCode;

public class NQueens2Solution {
	private int number = 0;
	private int count = 0;
	private int res = 0;
	
	public int totalNQueens(int n) {
        
        int[] xArray = new int[n];
        int[] yArray = new int[n];
        boolean[] xUsed = new boolean[n];
        boolean[] yUsed = new boolean[n];
        number = n;
        findQ( xArray, yArray, xUsed, yUsed, 0 );
        return res;
    }
	
	private void initialize( int[] xArray, int[] yArray, boolean[] xUsed, boolean[] yUsed ) {
		for ( int i = 0; i < xArray.length; ++i )
			xArray[i] = 0;
		for ( int i = 0; i < yArray.length; ++i )
			yArray[i] = 0;
		for ( int i = 0; i < xUsed.length; ++i )
			xUsed[i] = false;
		for ( int i = 0; i < yUsed.length; ++i )
			yUsed[i] = false;
	}
	
	private boolean checkDiagonal( int x, int y, int[] xArray, int[] yArray, int limit ) {
		boolean pass = true;
		int diffxy = x - y;
		int sumxy = y + x;
		for ( int i = 0; i < limit; ++i )
			if ( (xArray[i] - yArray[i] == diffxy) || (yArray[i] + xArray[i] == sumxy) ) {
				pass = false;
				break;
			}
		return pass;
	}
	
	private void findQ( int[] xArray, int[] yArray, boolean[] xUsed, boolean[] yUsed, int index ) {
		if ( index >= number ) {
			++res;
		} else {
			// index is the x value
			if ( index == 0 ) initialize( xArray, yArray, xUsed, yUsed );
			for ( int y = 0; y < number; ++y ) {
				if ( !xUsed[index] && !yUsed[y] && checkDiagonal( index, y, xArray, yArray, count ) ) {
					xArray[count] = index;
					yArray[count] = y;
					xUsed[index] = true;
					yUsed[y] = true;
					++count;
					findQ( xArray, yArray, xUsed, yUsed, index+1 );
					xUsed[index] = false;
					yUsed[y] = false;
					--count;
				}
			}
		}
	}
}
