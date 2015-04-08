package testLeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestConsecutiveSequenceSolution {
	private Map<Integer, Integer> check = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> fathers = new HashMap<Integer, Integer>();
	public int longestConsecutive(int[] num) {
        int res = 0;
        for ( int number : num ) 
        	if ( check.get(number) == null ) {
	        	int small = 0;
	        	int large = 0;
	        	int smallFather = Integer.MAX_VALUE;
	        	int largeFather = Integer.MAX_VALUE;
	        	if ( check.get( number - 1 ) != null ) {
	        		smallFather = fathers.get( number - 1 );
	        		while ( smallFather != fathers.get( smallFather ) )
	        			smallFather = fathers.get( smallFather );
	        		small = check.get( smallFather );
	        	}
	        	if ( check.get( number + 1 ) != null ) {
	        		largeFather = fathers.get( number + 1 );
	        		while ( largeFather != fathers.get( largeFather ) )
	        			largeFather = fathers.get( largeFather );
	        		large = check.get( largeFather );
	        	}
	        	int length = small + 1 + large;
	        	
	        	if ( length > res ) res = length;
	        	check.put( number, length );
	        	int newFather = Math.min( number, Math.min( smallFather, largeFather ) );
	        	fathers.put( number, newFather ) ;
	        	check.put( newFather, length );
	        	if ( small != 0 ) {
	        		check.put( number - 1, length );
	        		check.put( smallFather, length );
	        		fathers.put( number - 1, newFather );
	        	}
	        	if ( large != 0 ) {
	        		check.put( number + 1, length );
	        		check.put( largeFather, length );
	        		fathers.put( number + 1, newFather );
	        	}
        	}
        return res;
    }
}
