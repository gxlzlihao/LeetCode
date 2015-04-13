package testLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder2Solution {
	
	private List<List<String>> res = new ArrayList<List<String>>();
	private Set<String> used = new HashSet<String>();
	private Map<String, Set<String>> parents = new LinkedHashMap<String, Set<String>>();
	private int length = Integer.MAX_VALUE;
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        
		Set<String> currentLevel = new HashSet<String>();
        currentLevel.add(end);
        Set<String> previousLevel = new HashSet<String>();
        previousLevel.addAll(currentLevel);
        boolean found = false;
        length = 1;
		while ( currentLevel.size() > 0 && !found ) {
			Set<String> nextLevel = new HashSet<String>();
			Iterator<String> iter = currentLevel.iterator();
			while ( iter.hasNext() ) {
				String str = iter.next();
				used.add(str);
				for ( String newStr : neighbours( str, dict ) ) {
						if ( newStr.equals(start) ) {
							found = true;
							if ( parents.get(newStr) == null ) {
								Set<String> fathers = new HashSet<String>();
								fathers.add(str);
								parents.put(newStr, fathers);
							} else {
								parents.get(newStr).add(str);
							}
							
						} else if ( !used.contains(newStr) && !previousLevel.contains(newStr) ) {
							nextLevel.add(newStr);
							if ( parents.get(newStr) == null ) {
								Set<String> fathers = new HashSet<String>();
								fathers.add(str);
								parents.put(newStr, fathers);
							} else {
								parents.get(newStr).add(str);
							}
						}
					}
			}
			previousLevel = currentLevel;
			currentLevel = nextLevel;
			++length;
		}
		List<String> path = new ArrayList<String>();
		path.add(start);
		dfs( start, end, path, parents, 1 );
		
		parents.clear();
		currentLevel.clear();
		previousLevel.clear();
		
        return res;
    }
	
	private List<String> neighbours ( String s, Set<String> dict ) {
		List<String> res = new ArrayList<String>();
		char[] chars = s.toCharArray();
		for ( int target = 0; target < s.length(); ++target ) {
			char original = chars[target];
			for ( char rep = 'a'; rep <= 'z'; ++rep ) 
				if ( original != rep ) {
					chars[target] = rep;
					String newStr = new String( chars );
					if ( dict.contains(newStr) ) res.add(newStr);
				}
			chars[target] = original;
		}
		return res;
	}
	
	private void dfs( String str, String end, List<String> path, Map<String, Set<String>> parents, int depth ) {
		if ( depth > length ) return;
		else if ( str.equals(end) && depth <= length ) {
			res.add( new ArrayList<String>(path) );
		} else if ( depth < length && parents.get(str) != null ) {
			for ( String father : parents.get(str) ) {
					path.add( father );
					dfs( father, end, path, parents, depth + 1 );
					path.remove( path.size() - 1 );
			}
		} else return;
	}
	
}
