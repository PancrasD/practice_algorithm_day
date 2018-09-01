package com.leetcode.easy;

import org.junit.Test;

/*
 * Given a binary matrix A, we want to flip the image horizontally, 
 * then invert it, and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.  
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. 
 * For example, inverting [0, 1, 1] results in [1, 0, 0]
 * Notes:
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
    	if(A==null) {
    		return null;
    	}
        int i,j,k;
    	int a;
        for(i=0;i<A.length;i++) {
        	for(j=0,k=A[0].length-1;j<k;j++,k--) {
        		a=A[i][j]^1;
        		A[i][j]=A[i][k]^1;
        		A[i][k]=a;
        	}
        	if(j==k) {
        		A[i][j]=A[i][j]^1;
        	}
        }
        return A;
    }
    @Test
    public void test() {
    	int[][]a= {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
    	long t1=System.nanoTime();
    	int[][] b=flipAndInvertImage(a);
    	long t2=System.nanoTime();
    	for(int i=0;i<b.length;i++) {
    		System.out.println();
    		for(int j=0;j<b[0].length;j++) {
    			System.out.print(b[i][j]+" ");
    		}
    	}
    	System.out.println(t2-t1);
    }
    
}
