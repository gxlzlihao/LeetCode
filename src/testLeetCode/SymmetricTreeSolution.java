package testLeetCode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTreeSolution {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	
	private boolean res = true;
	private List<TreeNode> leftNodes = new ArrayList<TreeNode>();
	private List<TreeNode> rightNodes = new ArrayList<TreeNode>();
	private TreeNode lp = null;
	private TreeNode rp = null;
	
	public boolean isSymmetric( TreeNode root ) {
		if( root == null ) res = true;
		else if( root.left == null && root.right == null ) res = true;
		else if( root.left == null || root.right == null ) res =false;
		else {
			lp = root.left;
			rp = root.right;
			while(  ( lp == null && rp == null ) || lp.val == rp.val ) {
				//
				if( lp != null && rp != null ) {
					leftNodes.add(lp.left);
					leftNodes.add(lp.right);
					
					rightNodes.add(rp.right);
					rightNodes.add(rp.left);
				}
				
				if ( leftNodes.size() == rightNodes.size() && leftNodes.size() != 0 ) {
					lp = leftNodes.get(0);
					leftNodes.remove(0);
				
					rp = rightNodes.get(0);
					rightNodes.remove(0);
				}
			}
			if( leftNodes.size() != 0 || rightNodes.size() != 0 )
				res = false;
		}
		return res;
	}
}
