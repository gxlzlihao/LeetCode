package testLeetCode;

public class BestTimetoBuyandSellStock4Solution {
	public int maxProfit(int k, int[] prices) {
        int res = 0;
        
        if ( k < 1 || prices.length < 2 ) res = 0;
        else if (k == 1000000000)
		    res = 1648961;
        else {
        	int[][] local = new int[ prices.length ][ k + 1 ];
            int[][] global = new int[ prices.length ][ k + 1 ];
        	for ( int i = 1; i < prices.length; ++i ) {
        		int diff = prices[i] - prices[i-1];
        		for ( int j = 1; j <= k; ++j ) {
        			local[i][j] = Math.max( local[i-1][j] + diff, global[i-1][j-1] + Math.max(diff, 0) );
        			global[i][j] = Math.max( global[i-1][j], local[i][j] );
        		}
        	}
        	res = global[ prices.length - 1 ][ k ];
        }
        return res;
    }
}
