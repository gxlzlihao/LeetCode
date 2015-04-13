package testLeetCode;

import java.util.ArrayList;
import java.util.List;

import testLeetCode.util.TreeNode;

public class UniqueBinarySearchTrees2Solution {
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if ( n == 0 ) {
        	res = new ArrayList<TreeNode>();
        	res.add( null );
        }
        else if ( n == 1 ) {
        	res = new ArrayList<TreeNode>();
        	res.add( new TreeNode(1) );
        } else if ( n == 2 ) {
        	res = new ArrayList<TreeNode>();
        	TreeNode first = new TreeNode(1);
        	first.right = new TreeNode(2);
        	TreeNode second = new TreeNode(2);
        	second.left = new TreeNode(1);
        	res.add(first);
        	res.add(second);
        } else {
        	List<TreeNode>[] trees = new ArrayList[n+1];
        	trees[0] = new ArrayList<TreeNode>();
        	trees[1] = new ArrayList<TreeNode>();
        	trees[1].add( new TreeNode(1) );
        	trees[2] = new ArrayList<TreeNode>();
        	TreeNode first = new TreeNode(1);
        	first.right = new TreeNode(2);
        	TreeNode second = new TreeNode(2);
        	second.left = new TreeNode(1);
        	trees[2].add(first);
        	trees[2].add(second);
        	for ( int num = 3; num <= n; ++num ) {
        		List<TreeNode> tempRes = new ArrayList<TreeNode>();
        		for ( int middle = 1; middle <= num; ++middle ) {
        			int left = middle - 1;
        			int right = num - middle;
        			List<TreeNode> leftRes = trees[left];
        			if ( leftRes.size() == 0 ) leftRes.add(null);
        			List<TreeNode> rightRes = trees[right];
        			if ( rightRes.size() == 0 ) rightRes.add(null);
        			for ( TreeNode leftBranch : leftRes )
        				for ( int j = 0; j < rightRes.size(); ++j ) {
        					TreeNode rightBranch = rightRes.get(j);
        					TreeNode resTree = new TreeNode( middle );
        					resTree.left = copyTree( leftBranch, 0 );
        					resTree.right = copyTree( rightBranch, middle );
        					tempRes.add( resTree );
        				}
        		}
        		trees[num] = tempRes;
        	}
        	res = trees[n];
        }
        return res;
    }
	
	private TreeNode copyTree( TreeNode node, int inc ) {
		if ( node == null ) return null;
		TreeNode res = new TreeNode( node.val + inc );
		res.left = copyTree( node.left, inc );
		res.right = copyTree( node.right, inc );
		return res;
	}
}
