package com.leetcode.medium;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
    	TreeNode[] nodes=new TreeNode[nums.length];
    	int child=nums.length-1;
    	int lastparent=(child-1)>>1;
    	int[] A=buildHeap(nums,lastparent,nodes.length);
    	for(int i=A.length;i>=0;i--) {
    		nodes[i]=new TreeNode(A[i]);
    		if(leftchild(i)<A.length) {
    			nodes[i].left=nodes[leftchild(i)];
    			if(leftchild(i)!=A.length-1) {
    				nodes[i].right=nodes[leftchild(i)+1];
    			}
    		}
    	}
    	return nodes[0];
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMax( nums, 0, nums.length-1);
    	
    }
	private TreeNode constructMax(int[] nums, int i, int l) {
		if(i==l) {
			return new TreeNode(nums[i]);
		}
		int index=finMax(nums,i,l);
    	TreeNode node=new TreeNode(nums[index]);
    	if(index>i) {
    		node.left=constructMax(nums,i,index-1);
    	}
    	if(index<l) {
    		node.right=constructMax(nums,index+1,l);
    	}
		return node;
	}
	private int finMax(int[] nums,int s,int l) {
		int maxindex=s;
		int max=nums[s];
		for(int i=1;i<=l;i++) {
			if(max<nums[i]) {
				max=nums[i];
				maxindex=i;
			}
		}
		return maxindex;
	}
	private int[] buildHeap(int[] nodes, int lastparent, int length) {
		for(int i=lastparent;i>=0;i--) {
			int temp;
			int parent=i;
			int child = 0;
			for(temp=nodes[i];leftchild(parent)<length;) {
				child=leftchild(parent);
				if(child!=length-1) {
					if(nodes[child]<nodes[child+1]) {
						child++;
					}
				}else {
					
				}
			if(temp<nodes[child]) {
				nodes[parent]=nodes[child];
			}
			}
			nodes[parent]=temp;
		}
		return nodes;
	}
	private int leftchild(int parent) {
		return (parent<<1)+1;
	}
	class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
     }
	@Test
	public void test() {
		int[] A= {3,2,1,6,0,5};
		TreeNode root=constructMaximumBinaryTree(A);
		ArrayList<TreeNode> nodes=new ArrayList<TreeNode>();
		ArrayList<TreeNode> nodestemp=new ArrayList<TreeNode>();
		nodestemp.add(root);
		while(nodestemp!=null&&nodestemp.size()>0) {
			ArrayList<TreeNode> mntemp=new ArrayList<TreeNode>();
			for(int i=0;i<nodestemp.size();i++) {
				nodes.add(nodestemp.get(i));
				if(nodestemp.get(i)!=null&&(nodestemp.get(i).left!=null||nodestemp.get(i).right!=null)) {
					mntemp.add(nodestemp.get(i).left);
					mntemp.add(nodestemp.get(i).right);
				}
			}
			nodestemp=new ArrayList<>(mntemp);
		}
		for(int i=0;i<nodes.size();i++) {
			System.out.print(nodes.get(i));
		}
		
	}
}
