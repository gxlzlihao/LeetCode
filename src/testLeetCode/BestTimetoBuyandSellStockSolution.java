package testLeetCode;

import java.util.Stack;

public class BestTimetoBuyandSellStockSolution {
	public int maxProfit(int[] prices) {
		int res = 0;
		if ( prices.length < 2 ) res = 0;
		else {
			Stack<Integer> stack = new Stack<Integer>();
			for ( int price : prices ) {
				if ( stack.size() == 0 ) stack.push( price );
				else if ( price > stack.peek() ) res = Math.max( res, price - stack.peek() );
				else if ( price < stack.peek() ) stack.push( price );
				else continue;
			}
		}
		return res;
    }
}
