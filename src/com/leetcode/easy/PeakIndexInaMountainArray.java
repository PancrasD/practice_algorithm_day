package com.leetcode.easy;

import org.junit.Test;

/*
 * Let's call an array A a mountain if the following properties hold:A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 */
public class PeakIndexInaMountainArray {
	public int peakIndexInMountainArray(int[] A) {
		int i;
		for(i=0;i<A.length-2;i++) {
			if(A[i]>A[i+1]) {
				break;
			}
		}
		return i;
	}
    public int peakIndexInMountainArray1(int[] A) {
    	int a1=0;
    	int a2=A.length;
    	while(a1<a2) {
    		if(A[a1]<A[(a1+a2)>>1]) {
        		a1=(a1+a2)>>1;
        	}else {
        		a2=(a1+a2)>>1;
        	}
    	}
    	
		return a1;
        
    }
    @Test
    public void test() {
    	int[] A= {0,1,2,3,4,5,6,7,5,4,3,2,1};
    	System.out.println(peakIndexInMountainArray(A));
    }
}
