package testLeetCode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceSolution {
	public String getPermutation( int n, int k ) {
        String res = "";
        int t = 1;
        List<Integer> numbers = new ArrayList<Integer>();
        for ( int i = 1; i <= n; ++i ) {
        	t = t * i;
        	numbers.add( i );
        }
        t /= n;
        k--;
        for (int i = n - 1; i >= 1; i--) {
            int p = k / t;
            int np = numbers.get( p );
            res = res + String.valueOf( np );
            numbers.remove( p );
            k %= t;
            t /= i;
        }
        res = res + String.valueOf(numbers.get(0));
        return res;
    }
}
