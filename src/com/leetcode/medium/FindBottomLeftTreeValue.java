package com.leetcode.medium;

public class FindBottomLeftTreeValue {
	
	 public int findBottomLeftValue(TreeNode root) {
		int[][] max=new int[1][2];
		max[0][1]=0;
		max[0][1]=root.val;
		if(root.left!=null) {
			max[0][0]+=1;
			max[0][1]=root.left.val;
		}
		if(root.right!=null) {
			if(1>max[0][0]) {
				max[0][0]=1;
				max[0][1]=root.right.val;
			}
			findMax(root.right,max,1);
		}
		return max[0][1];
	        
	 }
	 private void findMax(TreeNode node, int[][] max, int i) {
		if(node.left!=null) {
			if(max[0][0]<i+1) {
				max[0][0]+=1;
				max[0][1]=node.left.val;
			}
			findMax(node.left,max,i+1);
		}
		if(node.right!=null) {
			if(i+1>max[0][0]) {
				max[0][0]=i+1;
				max[0][1]=node.right.val;
			}
			findMax(node.right,max,i+1);
		}
		
	}
	public class TreeNode {
		  int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
		  }
}
