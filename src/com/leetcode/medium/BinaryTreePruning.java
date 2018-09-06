package com.leetcode.medium;

public class BinaryTreePruning {
     public TreeNode pruneTree(TreeNode root) {
    	 if(root==null) {
    		 return root;
    	 }
    	 boolean islefthave=checkHave(root.left);
    	 boolean isrighthave=checkHave(root.right);
    	 if(!islefthave&&!isrighthave&&root.val==0) {
    		 return null;
    	 }
    	 if(!islefthave) {
    		 root.left=null;
    	 }
    	 if(!isrighthave) {
    		 root.right=null;
    	 }
		return root;
        
    }
	 private boolean checkHave(TreeNode node) {
		 boolean islefthave=false;
		 boolean isrighthave=false;
	     if(node.left!=null) {
	    	 islefthave=checkHave(node.left);
	     }
		 if(node.right!=null) {
			 isrighthave=checkHave(node.right);
		 }
    	 if(!islefthave&&!isrighthave&&node.val==0) {
    		 return false;
    	 }
    	 if(!islefthave) {
    		 node.left=null;
    	 }
    	 if(!isrighthave) {
    		 node.right=null;
    	 }
		return true;
	}
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

}
