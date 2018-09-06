package com.leetcode.easy;

import java.util.Random;

import org.junit.Test;

/*
 * insert sort p=1-N-1 保证每一趟0-p为有序状态
 */
public class Sort {
    public int[] insertsort(int[] A) {
    	for(int p=1;p<A.length;p++) {
    		int temp=A[p];
    		for(int j=p-1;j>=0;j--) {
    			if(temp<A[j]) {
    				A[j+1]=A[j];
    				A[j]=temp;
    			}else {
    				temp=A[j];
    			}
    		}
    	}
		return A;
   }
    public int[] shellSort(int [] A) {
    	int k=(int) (Math.log(A.length)/Math.log(2));
    	for(int gap=(1<<k)-1;gap>0;) {
    		for(int p=gap;p<A.length;p++) {
    			int temp=A[p];
    			for(int j=p-gap;j>=0;j-=gap) {
    				if(temp<A[j]) {
    					A[j+gap]=A[j];
    					A[j]=temp;
    				}else {
    					temp=A[j];
    				}
    			}	
    		}
    		gap=((gap+1)/2)-1;
    	}
		return A;
    }
    public int[] heapsort(int[] A) {
    	int n=A.length-1;
    	//从lastparent 往上增 增到根节点父亲  在更新过程中保证父亲是最小值
    	int lastparent=(n-1)/2;
    	int[] heap=buildheap(A,A.length,lastparent);
    	for(int i=A.length-1;i>0;i--) {
    		swapRefference(A,0,i);
    		buildheap(A,i,0);//之前建立的堆跟节点不满足结构 所以从根节点往下更新值 替换的儿子继续往下更新 没有替换的儿子结构满足要求
    	}
    	return A;
    }
    private void swapRefference(int[] A, int i1, int i2) {
		int a=A[i2];
		A[i2]=A[i1];
		A[i1]=a;
	}
	private int[] buildheap(int[] A,int length,int lastparent) {
    	//从lastparent 往上增 增到根节点父亲  在更新过程中保证父亲是最小值
    	for(int i=lastparent;i>=0;i--) {
    		int parent=i;
    		int temp;
    		//parent 要往下child比  选择小的->parent  被替换了小值的child作为parent 继续往下比  这样父亲都是小值 
    		//被更新替换的小值作为父亲需要往下比 保证结构 而如果小值不是父亲 则不需要往下更新 同时没有被替换的儿子 要么是叶节点 要么是之前已经更新了的父亲 是最小值 不需更新
    		for(temp=A[parent];leftchild(parent)<length;) {
    			int leftchild=leftchild(parent);
    			int child=leftchild;
    			//如果有右儿子 则比较两者中的最小
    			if(leftchild!=length-1) {
    				if(A[leftchild]>A[leftchild+1]) {
    					child++;
    				}
    			}
    			//最小的儿子和parent比
    			if(temp>A[child]) {
    				A[parent]=A[child];
    			}else {
    				break;
    			}
    			//更新父亲
    			parent=child;
    		}
    		A[parent]=temp;
    	}
		return A;
    	
	}
	private int leftchild(int parent) {
		return parent*2+1;
	}
	@Test
    public void test() {
    	int A[]=new int[1000];
    	for(int i=0;i<1000;i++) {
    		A[i]=(new Random()).nextInt(10000000);
    	}
    	long t1=System.nanoTime();
    	A=shellSort(A);
    	long t2=System.nanoTime();
    	for(int i=0;i<100;i++) {
    		System.out.print(A[i]+" ");
    	}
    	System.out.println();
    	System.out.println(t2-t1);
    }
}
