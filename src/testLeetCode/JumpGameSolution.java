package testLeetCode;

public class JumpGameSolution {
	
	private boolean res = false;
	private int furthest = 0;
	
	public boolean canJump(int[] A) {
        if ( A.length == 0 ) res = false;
        else if ( A.length == 1 ) res = true;
        else {
        	int i = 0;
	        do{
	        	if ( furthest >= A.length - 1 )
	        		res = true;
	        	else {
	        		if ( i + A[i] > furthest ) furthest = i + A[i];
	        	}
	        } while( i++ < furthest );
        }
        return res;
    }
	
}
