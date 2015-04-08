package testLeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTravesal {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> levelOrder( TreeNode root ) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if ( root != null ) {
			List<TreeNode> nodes = new ArrayList<TreeNode>();
			nodes.add(root);
			res = travesal( nodes );
		} 
		return res;
	}
	
	private List<List<Integer>> travesal( List<TreeNode> nodes ) {
		List<TreeNode> newNodes = new ArrayList<TreeNode>();
		List<Integer> currentLevel = new ArrayList<Integer>();
		for(int i=0; i<nodes.size(); ++i) {
			TreeNode temp = nodes.get(i);
			currentLevel.add( temp.val );
			if ( temp.left != null ) newNodes.add( temp.left );
			if ( temp.right != null ) newNodes.add( temp.right );
		}
		List<List<Integer>> childrenLevel = null;
		if( newNodes.size() != 0 ) { 
			childrenLevel = travesal( newNodes );
		}
		childrenLevel.add( 0, currentLevel );
		return childrenLevel;
	}
}
