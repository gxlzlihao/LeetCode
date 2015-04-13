package testLeetCode;

import testLeetCode.util.TreeNode;

public class SameTreeSolution {
	
	private class Pair{
		public TreeNode first;
		public TreeNode second;
		public Pair( TreeNode first, TreeNode second ) {
			this.first = first;
			this.second = second;
		}
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		boolean res = true;
		res = compare( new Pair( p, q ) );
		return res;
    }
	
	private boolean compare( Pair pair ) {
		boolean res;
		if ( ( pair.first == null && pair.second != null ) ||
				( pair.first != null && pair.second == null ) ||
				( pair.first != null && pair.second != null && pair.first.val != pair.second.val ) )
			res = false;
		else if ( pair.first == null && pair.second == null ) res = true;
		else {
			res = compare( new Pair( pair.first.right, pair.second.right ) ) && compare( new Pair( pair.first.left, pair.second.left ) );
		}
		return res;
	}
}
