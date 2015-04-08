package testLeetCode;

import java.util.Stack;

public class LargestRectangleInHistogramSolution {
	
	public int largestRectangleArea( int[] height ) {
		int largestSize = 0;
		Stack<Integer> indexStack = new Stack<Integer>();
		Stack<Integer> heightStack = new Stack<Integer>();
		
		for ( int i = 0; i < height.length; ++i ) {
			if ( heightStack.empty() || height[i] > heightStack.peek() ) {
				indexStack.push( i );
				heightStack.push( height[i] );
			} else if ( height[i] < heightStack.peek() ) {
				int latestIndex = i;
				while( !heightStack.empty() && height[i] < heightStack.peek() ) {
					latestIndex = indexStack.pop();
					int size = heightStack.pop() * ( i - latestIndex );
					if ( size > largestSize )
						largestSize = size;
				}
				indexStack.push( latestIndex );
				heightStack.push( height[i] );
			}
		}
		
		while( !heightStack.empty() ) {
			int size = heightStack.pop() * ( height.length - indexStack.pop() );
			if ( size > largestSize )
				largestSize = size;
		}
		
		return largestSize;
	}
}
