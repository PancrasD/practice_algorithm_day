package com.book.jianzhi;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

public class ConstructBinaryTree {
	//入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则
	    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        if(pre==null||in==null||pre.length==0||in.length==0){
	            return null;
	        }
	        if(pre.length!=in.length){
	            return null;
	        }
	        if(pre.length==1){
	            return new TreeNode(pre[0]);
	        }
	        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	        for(int i=0;i<in.length;i++){
	            map.put(in[i],i);
	        }
	        TreeNode node=constuct(pre,0,pre.length-1,in,0,in.length-1,map);
	        return node;
	    }
	private TreeNode constuct(int[] pre, int i, int j, int[] in, int k, int l,HashMap<Integer,Integer> map) {
		if(i>j||k>l) {
			return null;
		}
		if(k==l) {
			 return new TreeNode(in[k]);
		}
		int index=map.get(pre[i]);
		TreeNode head=new TreeNode(pre[i]);
		head.left=constuct(pre,i+1,i+index-k,in,k,index-1,map);
		head.right=constuct(pre,i+index-k+1,j,in,index+1,l,map);
		return head;
	}
	@Test
	public void test() {
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in ={4,7,2,1,5,3,8,6};
		TreeNode node=reConstructBinaryTree(pre,in);
		//
		Stack stack=new Stack();
		stack.pop();
		stack.peek();
    }
	 // Definition for binary tree
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
}
