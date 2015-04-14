package testLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumberSolution {
	private Map<Integer, String> mapping = new HashMap<Integer, String>();
	private List<String> res = new ArrayList<String>();
	public List<String> letterCombinations(String digits) {
        if ( digits != null && digits.length() > 0 ) {
        	initialize();
        	work( "", digits );
        }
        return res;
    }
	private void work( String str, String digits ) {
		if ( digits.length() == 0 ) res.add(str);
		else {
			int num = Integer.valueOf( digits.substring(0, 1) );
			String candidates = mapping.get(num);
			if ( num == 1 )
				work( str, digits.substring(1) );
			else 
				for ( int i = 0; i < candidates.length(); ++i )
					work( str + candidates.substring(i, i+1), digits.substring(1) );
		}
	}
	private void initialize() {
		mapping.put(1, "");
		mapping.put(2, "abc");
		mapping.put(3, "def");
		mapping.put(4, "ghi");
		mapping.put(5, "jkl");
		mapping.put(6, "mno");
		mapping.put(7, "pqrs");
		mapping.put(8, "tuv");
		mapping.put(9, "wxyz");
		mapping.put(0, " ");
	}
}
