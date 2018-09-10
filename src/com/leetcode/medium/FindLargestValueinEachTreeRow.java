package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
    	if(root==null) {
    		return new ArrayList<>();
    	}
    	List<TreeNode> list=new ArrayList<>();
    	list.add(root);
    	List<Integer> list1=new ArrayList<>();
    	list1=findMax(list,list1);
		return list1;
        
    }
	 private List<Integer> findMax(List<TreeNode> list, List<Integer> list1) {
		if(list==null||list.size()==0) {
				return list1;
		}
		int max=Integer.MIN_VALUE;
		List<TreeNode> newlist=new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(max<list.get(i).val) {
				max=list.get(i).val;
			}
			if(list.get(i).left!=null) {
				newlist.add(list.get(i).left);
			}
			if(list.get(i).right!=null) {
				newlist.add(list.get(i).right);
			}
		}
		list1.add(max);
		return findMax(list,list1);
	}
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
}
