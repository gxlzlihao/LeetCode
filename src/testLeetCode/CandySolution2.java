package testLeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// this solution works but has time limit problem

public class CandySolution2 {
	
	public class entryComparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			int res = 0;
			Entry<Integer,Integer> entry1 = ( Entry<Integer,Integer> ) o1;
			Entry<Integer, Integer> entry2 = ( Entry<Integer, Integer> ) o2;
			if ( entry1.getValue() < entry2.getValue() ) res = -1;
			else if ( entry1.getValue() == entry2.getValue() ) res = 0;
			else res = 1;
			return res;
		}}
	
	public int candy(int[] ratings) {
		int res = 0;
		if ( ratings == null || ratings.length == 0) return 0;
		else if ( ratings.length == 1 ) return 1;
		int[] candies = new int[ ratings.length ];
		boolean[] used = new boolean[ ratings.length ];
		Map<Integer, Integer> ratingMap = new HashMap<Integer, Integer>();
		for ( int i = 0; i < ratings.length; ++i ) {
			ratingMap.put( i, ratings[ i ] ); // key - index, value - rating
		}
		Entry<Integer, Integer>[] ratingArray = ratingMap.entrySet().toArray( new Entry[0] );
		Arrays.sort( ratingArray, new entryComparator() );
		for ( int i = 0; i < ratingArray.length; ++i )
			if ( !used[ i ] ) {
				candies[ ratingArray[i].getKey() ] = 1;
				used[ ratingArray[i].getKey() ] = true;
				int left = ratingArray[i].getKey() - 1;
				int right = ratingArray[i].getKey() + 1;
				while ( left >= 0 && ratings[left] > ratings[left+1] ) {
					if ( candies[left+1]+1 > candies[left] ) candies[left] = candies[left+1] + 1;
					used[ left ] = true;
					--left;
				}
				while ( right < ratings.length && ratings[right] > ratings[right-1] ) {
					if ( candies[right-1]+1 > candies[right] ) candies[right] = candies[right-1] + 1;
					used[ right ] = true;
					++right;
				}
			}
		for( int candy : candies ) {
			res += candy;
		}
		return res;
	}
}
