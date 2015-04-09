package testLeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import testLeetCode.util.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversalSolution {
	
	private Stack<TreeNode> leftStack = new Stack<TreeNode>();
	private Stack<TreeNode> rightStack = new Stack<TreeNode>();
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if ( root != null ) {
        	leftStack.push( root );
        	while ( !leftStack.empty() || !rightStack.empty() ) {
        		if ( !leftStack.empty() ) {
        			List<Integer> array = new ArrayList<Integer>();
        			while ( !leftStack.empty() ) {
        				TreeNode node = leftStack.pop();
        				array.add( node.val );
        				if ( node.left != null ) rightStack.push( node.left );
        				if ( node.right != null ) rightStack.push( node.right );
        			}
        			if ( array.size() > 0 ) res.add( array );
        		} else if ( !rightStack.empty() ) {
        			List<Integer> array = new ArrayList<Integer>();
        			while ( !rightStack.empty() ) {
        				TreeNode node = rightStack.pop();
        				array.add( node.val );
        				if ( node.right != null ) leftStack.push( node.right );
        				if ( node.left != null ) leftStack.push( node.left );
        			}
        			if ( array.size() > 0 ) res.add( array );
        		} else break;
        	}
        } 
        return res;
    }
}
