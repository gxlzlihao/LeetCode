package testLeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationsSolution {
	
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	private List<Integer> array = new ArrayList<Integer>();
	
	public List<List<Integer>> combine(int n, int k) {
		
		int[] numbers = new int[ n + 1 ];
		for ( int i = 0; i < numbers.length; ++i ) numbers[i] = i;
		
		if ( k <= n ) {
			work( numbers, 1, k, 1 );
		}
        return res;
    }
	
	private void work( int[] numbers, int start, int k, int depth ) {
		if ( depth > k ) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll( array );
			res.add( temp );
		} else {
			for ( int j = start; j < numbers.length; ++j ) {
				array.add( numbers[ j ] );
				work( numbers, j + 1, k, depth + 1 );
				array.remove( array.size() - 1 );
			}
		}
	}
}
