package testLeetCode;


public class JumpGame2Solution {
	public int jump(int[] A) {
        int res = 0;
        if ( A.length == 0 ) res = 0;
        else if ( A.length == 1 && A[0] != 0 ) res = 0;
        else {
        	int step = 1;
        	int furthest = 0;
        	int tempMax = 0;
        	int count = 0;
        	for ( int i = 0; i < A.length; ++i ) {
        		--step;
        		if ( i + A[i] > tempMax ) tempMax = i + A[i];
        		if ( step == 0 ) {
        			step = tempMax - i;
        			++count;
        			if ( tempMax > furthest ) {
        				furthest = tempMax;
        				if ( furthest >= A.length - 1 ) {
        					res = count;
        					break;
        				}
        			}
        			tempMax = 0;
        		}
        	}
        }
        return res;
    }
}
