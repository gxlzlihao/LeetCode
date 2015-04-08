package testLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumSolution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> array = toOrderedArray( candidates );
        return find( array, target, -1 );
    }
	
	private List<Integer> toOrderedArray( int[] candidates ) {
		List<Integer> array = new ArrayList<Integer>();
		for( int number : candidates ) {
			array.add( number );
		}
		Collections.sort( array );
		
		return array;
	}
	
	private List<List<Integer>> find( List<Integer> array, int target, int start ){
		if ( target < 0 ) {
			return null;
		} else {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			for ( int i = start+1; i < array.size(); ++i ) {
				int number = array.get(i);
				if ( target == number ) {
					List<Integer> newList = new ArrayList<Integer>();
					newList.add(number);
					res.add(newList);
				} else {
					List<List<Integer>> tempRes = find( array, target - number, i );
					if ( tempRes != null && tempRes.size() > 0 ) {
						for( List<Integer> list : tempRes ) {
							list.add( 0, number );
						}
						res.addAll( tempRes );
					}
				}
			}
			return res;
		}
	}
}
