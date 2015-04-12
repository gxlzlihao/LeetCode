package testLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WordLadder2Solution {
	
	private List<List<String>> res = new ArrayList<List<String>>();
	private Set<String> used = new HashSet<String>();
	private String candidate = "qwertyuioplkjhgfdsazxcvbnm";
	private Map<String, Set<String>> parents = new HashMap<String, Set<String>>();
	private int length = Integer.MAX_VALUE;
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        
        Queue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.add(end);
        boolean found = false;
		while ( queue.size() > 0 && !found ) {
			Queue<String> newQueue = new ConcurrentLinkedQueue<String>();
			while ( queue.size() > 0 ) {
				String str = queue.poll();
				used.add(str);
				for ( int target = 0; target < str.length(); ++target )
					for ( int rep = 0; rep < candidate.length(); ++rep )
						if ( str.charAt(target) != candidate.charAt(rep) ) {
							String newStr = str.substring(0, target) + candidate.substring(rep, rep+1) + str.substring(target+1);
							if ( newStr.equals(start) ) {
								found = true;
								if ( parents.get(newStr) == null ) {
									Set<String> fathers = new HashSet<String>();
									fathers.add(str);
									parents.put(newStr, fathers);
								} else {
									parents.get(newStr).add(str);
								}
							} else if ( dict.contains(newStr) && !used.contains(newStr) ) {
								newQueue.add(newStr);
								if ( parents.get(newStr) == null ) {
									Set<String> fathers = new HashSet<String>();
									fathers.add(str);
									parents.put(newStr, fathers);
								} else {
									parents.get(newStr).add(str);
								}
							}
						}
				queue = newQueue;
			}
		}
		
		List<String> path = new ArrayList<String>();
		path.add(start);
		dfs( start, end, path, parents );
		List<List<String>> finalRes = new ArrayList<List<String>>();
		for ( List<String> solution : res ) 
			if ( solution.size() == length )
				finalRes.add(solution);
		res = finalRes;
        return res;
    }
	
	private void dfs( String str, String end, List<String> path, Map<String, Set<String>> parents ) {
		if ( str.equals(end) ) {
			if ( path.size() < length ) length = path.size();
			List<String> newPath = new ArrayList<String>();
			newPath.addAll(path);
			res.add(newPath);
		} else if ( parents.get(str) != null ) {
			Set<String> fathers = parents.get(str);
			for ( String father : fathers ) {
				path.add( father );
				dfs( father, end, path, parents );
				path.remove( path.size() - 1 );
			}
		} else return;
	}
	
}
