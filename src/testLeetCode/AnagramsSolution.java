package testLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsSolution {
	public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        Map<String, List<String>> check = new HashMap<String, List<String>>();
        for ( String str : strs ) {
        	char[] chars = str.toCharArray();
        	Arrays.sort(chars);
        	String nStr = new String( chars );
        	if ( !check.containsKey( nStr ) ) {
        		List<String> strArray = new ArrayList<String>();
        		strArray.add(str);
        		check.put(nStr, strArray);
        	} else {
        		// find a anagram
        		check.get(nStr).add(str);
        	}
        }
        
        for ( List<String> temp : check.values() ) {
        	if ( temp.size() > 1 ) res.addAll(temp); 
        }
        
        return res;
    }
}
