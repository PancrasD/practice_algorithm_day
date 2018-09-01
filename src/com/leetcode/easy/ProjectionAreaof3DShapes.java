package com.leetcode.easy;

import org.junit.Test;
/*
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.

   Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

   Now we view the projection of these cubes onto the xy, yz, and zx planes.

   A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane. 

   Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

   Return the total area of all three projections.
 */
public class ProjectionAreaof3DShapes {
    public int projectionArea(int[][] grid) {
        int row=grid.length;
        int column=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++) {
        	int max=0;
        	for(int j=0;j<column;j++) {
        		if(grid[i][j]>max) {
        			max=grid[i][j];
        		}
        		if(grid[i][j]!=0) {
        			count+=1;
        		}
        	}
        	count+=max;
        }
        for(int j=0;j<column;j++) {
        	int max=grid[0][j];
        	for(int i=1;i<row;i++) {
        		if(grid[i][j]>max) {
        			max=grid[i][j];
        		}
        	}
        	count+=max;
        }
        return count;
    }
    @Test
    public void test() {
    	int[][] a= {{1,2},{3,4}};
    	System.out.println(projectionArea(a));
    }
    
}
