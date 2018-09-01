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
