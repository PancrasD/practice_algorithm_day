package com.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 *  The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted
 *   at that node (including the node itself). So what is the most frequent subtree sum value? 
 *   If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum {
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  public int[] findFrequentTreeSum(TreeNode root) {
		  if(root==null) {
			  return null;
		  }
		  if(root.left==null&&root.right==null) {
			  return new int[]{root.val};
		  }
		  List<Integer> list=new ArrayList<>();
	      compute(root,list);
	      Map<Integer,Integer>map=new HashMap<>();
	      for(Integer sum:list) {
	    	  if(map.get(sum)==null) {
	    		  map.put(sum, 1);
	    	  }else {
	    		  map.put(sum, map.get(sum)+1);
	    	  }
	      }
	      int max=0;
	      for(Map.Entry<Integer, Integer>entry:map.entrySet()) {
	    	  if(entry.getValue()>max) {
	    		  max=entry.getValue();
	    	  }
	      }
	      List<Integer> list1=new ArrayList<>();
	      for(Map.Entry<Integer, Integer>entry:map.entrySet()) {
	    	  if(entry.getValue()==max) {
	    		  list1.add(entry.getKey());
	    	  }
	      }
	      int []sumarray=new int[list1.size()];
	      for(int i=0;i<list1.size();i++) {
	    	  sumarray[i]=list1.get(i);
	      }
	      return sumarray;
	  }
	private int compute(TreeNode root,List<Integer>list) {
		if(root==null) {
			  return 0;
		  }
		int leftSum=compute(root.left,list);
		int rightSum=compute(root.right,list);
		int sum=root.val+leftSum+rightSum;
		list.add(sum);
		return sum;
	}
}
