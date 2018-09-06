package com.leetcode.medium;

import org.junit.Test;

public class MaxIncreasetoKeepCitySkyline {
	 public int maxIncreaseKeepingSkyline(int[][] grid) {
		 if(grid==null) {
			 return 0;
		 }
		 int left[]=new int[grid.length];
		 int top[]=new int[grid[0].length];
	     for(int i=0;i<grid.length;i++) {
	    	 for(int j=0;j<grid[0].length;j++) {
	    		 if(left[i]<grid[i][j]) {
	    			 left[i]=grid[i][j];
	    		 }
	    		 if(top[j]<grid[i][j]) {
	    			 top[j]=grid[i][j];
	    		 }
	    		 
	    	 }
	     }
	     int count = 0;
	     int min;
	     int crease;
	     for(int i=0;i<grid.length;i++) {
	    	 for(int j=0;j<grid[0].length;j++) {
	    		 min=left[i]<top[j]?left[i]:top[j];
	    		 if((crease=min-grid[i][j])>0) {
	    			 count+=crease;
	    		 }
	    	 }
	     }
	     return count;
	  }
	 @Test
	 public void test() {
		 int[][]grid= {{3, 0, 8, 4}, 
		               {2, 4, 5, 7},
		               {9, 2, 6, 3},
		               {0, 3, 1, 0}};
		 System.out.println(maxIncreaseKeepingSkyline(grid));
	 }
}
