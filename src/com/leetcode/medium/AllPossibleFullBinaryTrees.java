package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
	
    public List<TreeNode> allPossibleFBT(int N) {
    	return findP(N);
        
    }
	 private List<TreeNode> findP(int n) {
		List<TreeNode> trees=new ArrayList<>(); 
		if(n==1) {
			trees.add(new TreeNode(0));
			return trees;
		}
		int lefthave=1;
		int righthave=n-2;
		while(righthave>=1) {
			List<TreeNode> rights=findP(righthave);
			List<TreeNode> lefts=findP(lefthave);
			for(int i=0;i<rights.size();i++) {
				for(int j=0;j<lefts.size();j++) {
					TreeNode node=new TreeNode(0);
					node.left=lefts.get(j);
					node.right=rights.get(i);
					trees.add(node);
				}
			}
			righthave-=2;
			lefthave+=2;
		}
		return trees;
	}
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
}
