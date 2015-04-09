package testLeetCode;

import java.util.Arrays;

public class NextPermutationSolution {
	public void nextPermutation(int[] num) {
        if ( num.length == 0 || num.length == 1 ) return;
        else {
        	boolean solved = false;
        	for ( int i = num.length - 1; i >= 0 && !solved; --i ) {
        		int minBigger = Integer.MAX_VALUE;
        		int target = i;
        		for ( int j = i + 1; j < num.length && !solved; ++j ) 
        			if ( num[ j ] > num[ i ] )
        				if ( num[ j ] < minBigger ) {
        					minBigger = num[ j ];
        					target = j;
        				}
        		if ( minBigger != Integer.MAX_VALUE ) {
        			int temp = num[ i ];
        			num[ i ] = num[ target ];
        			num[ target ] = temp;
        			solved = true;
        			if ( i != num.length - 1 ) Arrays.sort( num, i + 1, num.length );
        		}
        	}
        	if ( !solved )
        		Arrays.sort( num );
        }
    }
}
