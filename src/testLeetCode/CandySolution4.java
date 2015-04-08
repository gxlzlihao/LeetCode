package testLeetCode;

// this solution is accepted

public class CandySolution4 {
	public int candy(int[] ratings) {
		int res = 0;
		if ( ratings == null || ratings.length == 0 ) res = 0;
		else if ( ratings.length == 1 ) res = 1;
		else {
			int[] candies = new int[ ratings.length ];
			// from left to right
			int left = 1;
			if ( candies[0] == 0 ) candies[0] = 1;
			while ( left < ratings.length ) {
				if ( ratings[left] > ratings[left - 1] ) {
					if ( candies[left - 1] == 0 ) candies[left - 1] = 1;
					int newCandy = candies[left - 1] + 1;
					if ( newCandy > candies[left] )  candies[left] = newCandy;
				} else if ( ratings[left] == ratings[left - 1] ) {
					if ( candies[left] == 0 ) candies[left] = 1;
				}
				++left;
			}
			// from right to left
			int right = ratings.length - 2;
			if ( candies[ ratings.length - 1 ] == 0 ) candies[ ratings.length - 1 ] = 1;
			while ( right > -1 ) {
				if ( ratings[right] > ratings[right + 1] ) {
					if ( candies[right + 1] == 0 ) candies[right + 1] = 1;
					int newCandy = candies[right + 1] + 1;
					if ( newCandy > candies[right] ) candies[right] = newCandy;
				} else if ( ratings[right] == ratings[right + 1] ) {
					if ( candies[right] == 0 ) candies[right] = 1;
				}
				--right;
			}
			for ( int candy : candies ) {
				res += candy;
			}
		}
		
		return res;
	}
}
