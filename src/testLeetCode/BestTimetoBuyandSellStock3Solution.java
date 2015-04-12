package testLeetCode;

public class BestTimetoBuyandSellStock3Solution {
	public int maxProfit(int[] prices) {
		int res = 0;
        if ( prices == null || prices.length < 2 ) res = 0;
        else {
        	int[] left = new int[ prices.length ];
        	int[] right = new int[ prices.length ];
        	
        	int min = prices[0];
        	left[0] = 0;
        	for ( int i = 1; i < prices.length; ++i ) {
        		if ( prices[i] < min ) min = prices[i];
        		left[i] = Math.max( left[i-1], prices[i] - min );
        	}
        	int max = prices[ prices.length - 1 ];
        	right[ prices.length - 1 ] = 0;
        	for ( int j = prices.length - 2; j >=0; --j ) {
        		if ( prices[j] > max ) max = prices[j];
        		right[j] = Math.max( right[j+1], max - prices[j] );
        	}
        	for ( int x = 0; x < prices.length; ++x ) {
        		res = Math.max( res, left[x] + right[x] );
        	}
        }
        return res;
    }
}
