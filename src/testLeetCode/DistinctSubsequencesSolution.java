package testLeetCode;

import java.util.ArrayList;
import java.util.List;

public class DistinctSubsequencesSolution {
	
	private int tempRes = 0;
	
	public int numDistinct(String S, String T) {
		int res = 0;
		if ( T.length() == 0 || S.length() == 0 || S.length() < T.length() || ( S.length() == T.length() && !S.equals(T) ) ) res = 0;
		else if ( S.equals(T) ) res = 1;
		else {
			work( S, T );
			res = tempRes;
		}
		return res;
    }
	
	private boolean work( String template, String target ) {
		boolean res = false;
		if ( template.length() == 0 && target.length() != 0 ) return false;
		else if ( target.length() == 0 ) {
			++tempRes;
			return true;
		} else {
			String t = target.substring( 0, 1 );
			if ( template.indexOf(t) == -1 ) return false;
			else {
				int occur = template.indexOf( t );
				while ( occur != -1 ) {
					if ( occur == template.length() - 1 && target.length() > 1 ) return false;
					else if ( target.length() == 1 ) {
						++tempRes;
						return true;
					} else  if ( work( template.substring( occur + 1, template.length() ), target.substring( 1 ) ) ) {
						occur = template.substring( occur + 1 ).indexOf( t );
						template = template.substring( occur + 1 );
					} else return false;
				}
			}
		}
		return res;
	}
	
}
