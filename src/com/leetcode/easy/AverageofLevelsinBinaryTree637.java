package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

/*
 * Given a non-empty binary tree, 
 * return the average value of the nodes on each level in the form of an array.
	Example 1:
	Input:
	    3
	   / \
	  9  20
	    /  \
	   15   7
	Output: [3, 14.5, 11]
	Explanation:
	The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. 
	Hence return [3, 14.5, 11].
	Note:
	The range of node's value is in the range of 32-bit signed integer.
 */
/*
 * 1 边界考虑 sum溢出
 * 
 *  节省空间可以使用两个list  一个存储当行元素个数  一个存储计算和
 */
public class AverageofLevelsinBinaryTree637 {
	 public List<Double> averageOfLevels(TreeNode root) {
	        if(root==null) {
			    	return null;
			 }
	        List<Double> list=new ArrayList<>();
	        List<TreeNode> curentNodes=new ArrayList<>();
	        curentNodes.add(root);
	        compute(curentNodes,list);
	        return list;
	    }
	    private void compute(List<TreeNode> curentNodes, List<Double> list) {
			
			long sum = 0;
			List<TreeNode> newNodes=new ArrayList<>();//新建list开销
			for(TreeNode node:curentNodes) {
				sum+=node.val;
				if(node.left!=null) {
					newNodes.add(node.left);
				}
				if(node.right!=null) {
					newNodes.add(node.right);
				}
			}
			list.add(sum*1.0/curentNodes.size());
	        if(newNodes!=null&&newNodes.size()>0){
	            compute(newNodes,list);
	        }
			
		}
	    public List<Double> averageOfLevels1(TreeNode root) {
	    	if(root==null) {
		    	return null;
		    }
	    	List<Integer> count=new ArrayList<>();
	    	List<Double>  sum=new ArrayList<>();
	    	List<Double> result=new ArrayList<>();
	    	computeGo(root,count,sum,0);
	    	for(int i=0;i<count.size();i++) {
	    		result.add(sum.get(i)/count.get(i));
	    	}
			return result;
	    	
	    }
	private void computeGo(TreeNode node, List<Integer> count, List<Double> sum,int index) {
			if(node==null) {
				return;
			}
			if(index>count.size()) {
				count.add(index, 1);
				sum.add(index, 0.0+node.val);
			}else {
				count.set(index, count.get(index)+1);
				sum.set(index, sum.get(index)+node.val);
			}
			computeGo(node.left,count,sum,index+1);
			computeGo(node.right,count,sum,index+1);
		}
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		}
	@Test
	public void test() {
		int sum=0;
		TreeNode root=produceTree(sum);
		List<Double> list=averageOfLevels(root);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	private TreeNode produceTree(int sum) {
		TreeNode root =new TreeNode((new Random().nextInt(10)));
		if(Math.random()<0.5&&sum>0) {
			root.left=produceTree(--sum);
		}
		if(Math.random()<0.5&&sum>0) {
			root.right=produceTree(--sum);
		}
		return root;
	}
}
