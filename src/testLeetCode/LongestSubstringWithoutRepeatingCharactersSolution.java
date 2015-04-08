package testLeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersSolution {
	public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0;
        int j = 0;
        
        Map<Integer, Integer> check = new HashMap<Integer, Integer>();
        while( j < s.length() ) {
        	if ( !check.containsKey( (int) s.charAt(j) ) ) {
        		check.put( (int) s.charAt(j) , j );
        	} else {
        		if ( res < check.size() ) res = check.size();
        		int duplicatedPlace = check.get( (int) s.charAt(j) );
        		for ( int x = i; x <= duplicatedPlace ; ++x ) {
        			check.remove( (int) s.charAt(x) );
        		}
        		i = duplicatedPlace + 1;
        		check.put( (int) s.charAt(j), j );
        	}
        	++j;
        }
        
        if ( res < check.size() ) res = check.size();
        
        return res;
    }
}
