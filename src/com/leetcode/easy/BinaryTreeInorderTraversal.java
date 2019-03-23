package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  public List<Integer> inorderTraversal(TreeNode root) {
	        if(root==null) {
	        	return new ArrayList<>();
	        }
	        List<Integer> list=new ArrayList<>();
	        List<Integer> list1=inorderTraversal(root.left);
	        List<Integer> list2=inorderTraversal(root.right);
	        if(list1!=null&&list1.size()>0) {
	        	list.addAll(0, list1);
	        }
	        list.add(root.val);
	        if(list2!=null&&list2.size()>0) {
	        	list.addAll( list2);
	        }
	        return list;
	 }
}
