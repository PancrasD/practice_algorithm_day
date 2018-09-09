package com.leetcode.medium;

public class InsertintoaBinarySearchTree {
	
public TreeNode insertIntoBST(TreeNode root, int val) {
	return insert(root,val);
        
    }
	private TreeNode insert(TreeNode node, int val) {
		if(node==null) {
			return new TreeNode(val);
		}
		int value=node.val;
		if(value<val) {
			node.right=insert(node.right,val);
		}else {
			node.left=insert(node.left,val);
		} 
	    return node;
    }
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
}
