package com.leetcode.easy;

import org.junit.Test;

public class ArrayPartitionI {
	   public int arrayPairSum(int[] nums) {
	        int sum=0;
	        nums=insertsort(nums);
	        for(int i=0;i<nums.length-1;){
	            sum+=nums[i];
	            i+=2;
	        }
	        return sum;
	    }
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
	   @Test
	   public void test() {
		   int[] A= {1,4,3,2};
		   System.out.println(arrayPairSum(A));
	   }
}
