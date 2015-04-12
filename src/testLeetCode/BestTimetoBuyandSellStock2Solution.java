package testLeetCode;

public class BestTimetoBuyandSellStock2Solution {
	public int maxProfit(int[] prices) {
        int res = 0;
        if ( prices == null || prices.length < 2 ) res = 0;
        else { 
        	int buy = Integer.MIN_VALUE;
        	int sell = Integer.MIN_VALUE;
        	int profit = 0;
        	boolean buyin = false;
        	boolean sellout = false;
        	for ( int i = 0; i < prices.length; ++i ) 
        		if ( !buyin ) {
        			buyin = true;
        			buy = prices[i];
        		} else if ( buyin && !sellout && prices[i] <= buy ) {
        			buy = prices[i];
        		} else if ( buyin && !sellout && prices[i] > buy ) {
        			sell = prices[i];
        			sellout = true;
        			profit = sell - buy;
        		} else if ( buyin && sellout && prices[i] > sell ) {
        			sell = prices[i];
        			profit = sell - buy;
        		} else if ( buyin && sellout && prices[i] < sell ) {
        			res += profit;
        			buyin = true;
        			sellout = false;
        			buy = prices[i];
        			sell = Integer.MIN_VALUE;
        			profit = 0;
        		}
        	if ( profit != 0 ) res += profit;
        }
        return res;
    }
}
