package com.leetcode.easy;

import org.junit.Test;

public class TransposeMatrix {
 public int[][] transpose(int[][] A) {
	 if(A==null) {
		 return null;
	 }
	 int[][] B=new int[A[0].length][A.length];
        for(int i=0;i<A.length;i++) {
        	for(int j=0;j<A[0].length;j++) {
        		B[j][i]=A[i][j];
        	}
        }
        return B;
    }
 @Test
 public void test() {
	 int A[][]= {{1,2,3},{4,5,6},{7,8,9}};
	 int[][]B=transpose(A);
	 for(int i=0;i<B.length;i++) {
		 for(int j=0;j<B[0].length;j++) {
			 System.out.print(B[i][j]+" ");
		 }
		 System.out.println();
	 }
 }
}
