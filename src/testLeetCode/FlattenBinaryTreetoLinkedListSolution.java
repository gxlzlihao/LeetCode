package testLeetCode;

import java.util.Stack;
import testLeetCode.util.TreeNode;

public class FlattenBinaryTreetoLinkedListSolution {
	
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public void flatten(TreeNode root) {
		TreeNode p = root;
		
		while ( !( p == null && stack.empty() ) ) {
			if ( p.right != null ) stack.push( p.right );
			if ( p.left != null ) {
				p.right = p.left;
				p.left = null;
			} else if ( !stack.empty() ) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}
			p = p.right;
		}
	}
}
