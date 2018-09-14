package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class ConstructBinaryTreefromPreorderandPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
    	if(pre==null||pre.length==0) {
    		return null;
    	}
    	Map<Integer,Integer> map1=new TreeMap<>();
    	Map<Integer,Integer> map2=new TreeMap<>();
    	for(int i=0;i<pre.length;i++) {
    		map1.put(pre[i], i);
    		map2.put(post[i], i);
    	}
    	int len=pre.length;
    	TreeNode root=new TreeNode(pre[0]);
    	pre[0]=0;
    	post[post.length-1]=0;
    	find(map1,map2,root,pre,post,len);
		return root;
        
    }
   
	private void find(Map<Integer, Integer> map1, Map<Integer, Integer> map2, TreeNode node, int[] pre, int[] post, int len) {
		int leftbegin=map1.get(node.val)+1;
		int rightbegin=map2.get(node.val)-1;
		if(leftbegin<len&&leftbegin>=0&&rightbegin<len&&rightbegin>=0) {
			if(pre[leftbegin]!=0&&post[rightbegin]!=0) {
				if(pre[leftbegin]!=post[rightbegin]) {
					
					TreeNode left=new TreeNode(pre[leftbegin]);
					node.left=left;
					post[map2.get(pre[leftbegin])]=0;
					pre[leftbegin]=0;
					TreeNode right=new TreeNode(post[rightbegin]);
					node.right=right;
					pre[map1.get(post[rightbegin])]=0;
					post[rightbegin]=0;
					find(map1,map2,left,pre,post,len);
					find(map1,map2,right,pre,post,len);
				}else {
					TreeNode left=new TreeNode(pre[leftbegin]);
					node.left=left;
					post[map2.get(pre[leftbegin])]=0;
					pre[leftbegin]=0;
					find(map1,map2,left,pre,post,len);
				}
			}
		}
	}

	public class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) { val = x; }
    	  }
	@Test
	public void test() {
		int[]pre = {1,2,4,5,3,6,7};
		int[]post = {4,5,2,6,7,3,1};
		TreeNode root=constructFromPrePost(pre,post);
		List<TreeNode> nodes=new ArrayList<>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			List<TreeNode> newnodes=new ArrayList<>();
			for(int i=0;i<nodes.size();i++) {
				System.out.print(nodes.get(i).val);
				if(nodes.get(i).left!=null) {
					newnodes.add(nodes.get(i).left);
				}
				if(nodes.get(i).right!=null) {
					newnodes.add(nodes.get(i).right);
				}
			}
			nodes=newnodes;
		}
	}
}
