package testLeetCode;

public class SumRootToLeafSolution {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	private int sum = 0;
	private int tempSum = 0;
	
	public int sumNumbers(TreeNode root) {
		if ( root != null ) make( root );
        return sum;
    }
	
	private void make( TreeNode node ) {
		tempSum = tempSum * 10 + node.val;
		
		if ( node.left == null && node.right == null ) {
		    sum += tempSum;
		} else {
		    if ( node.left != null ) make( node.left );
		    if ( node.right != null ) make( node.right );
		}
		
		tempSum = tempSum / 10;
	}
}
