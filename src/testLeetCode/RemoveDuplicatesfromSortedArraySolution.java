package testLeetCode;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArraySolution {
	public int removeDuplicates(int[] A) {
        int res = 0;
        if ( A == null || A.length == 0 ) res = 0;
        else if ( A.length == 1 ) res = 1;
        else {
        	Arrays.sort(A);
        	int count = 1;
        	for ( int i = 1; i < A.length; ++i ) {
        		if ( A[ i ] != A[ i - 1 ] ) A[ count++ ] = A[i];
        	}
        	res = count;
        }
        return res;
    }
}
