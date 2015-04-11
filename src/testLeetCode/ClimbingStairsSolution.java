package testLeetCode;

public class ClimbingStairsSolution {
	public int climbStairs(int n) {
        int res = 0;
        if ( n == 0 ) res = 0;
        else if ( n == 1 ) res = 1;
        else {
        	int[] steps = new int[n];
        	steps[0] = 1;
        	steps[1] = 2;
        	for ( int i = 2; i < n; ++i ) {
        		steps[ i ] = steps[ i - 1 ] + steps[ i - 2 ];
        	}
        	res = steps[ n - 1 ];
        }
        return res;
    }
}
