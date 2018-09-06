package com.leetcode.medium;

import org.junit.Test;

public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
    	if(A==null) {
    		return 0;
    	}
    	int row=A.length;
    	int column=A[0].length;
    	for(int i=0;i<row;i++) {
    		if(A[i][0]==0) {
    			for(int j=0;j<column;j++) {
    				A[i][j]=A[i][j]==0?1:0;
    			}
    		}
    	}
    	for(int j=1;j<column;j++) {
    		int sum=0;
    		for(int i=0;i<row;i++) {
    			if(A[i][j]==0) {
    				sum++;
    			}
    		}
    		if(sum>row/2) {
    			for(int i=0;i<row;i++) {
    				A[i][j]=A[i][j]==0?1:0;;
    			}
    		}
    	}
    	int count=0;
    	for(int i=0;i<row;i++) {
    		for(int j=0;j<column;j++) {
    			count+=A[i][j]<<(column-1-j);
    		}
    		
    	}
		return count;
        
    }
    @Test
    public void test() {
    	int[][]a= {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
    	System.out.println(matrixScore(a));
    }
}
