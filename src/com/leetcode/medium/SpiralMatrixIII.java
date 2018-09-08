package com.leetcode.medium;

import org.junit.Test;

public class SpiralMatrixIII {
	 public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		 int[][] walks=new int[R*C][2];
		int grids=1;//每方向步数
		int count=0;
		int direct=0;
		int sum=1;//转向数
		int walksevery=0;
		int max=R*C;
		walks[count][0]= r0;
		walks[count][1]= c0;
		while(count<max-1) {
			switch(direct) {
			case 0:{c0++;};break;
			case 1:{r0++;};break;
			case 2:{c0--;};break;
			case 3:{r0--;};break;
			}
			if(c0>=0&&r0>=0&&c0<C&&r0<R) {
				count++;
				walks[count][0]= r0;
				walks[count][1]= c0;
			}
			walksevery++;
			if(walksevery==grids) {
				walksevery=0;
				direct=(direct+1)%4;
				sum++;
				if(sum==3) {
					grids++;
					sum=1;
				}
			}
			
		}
		return walks;   
	 }
	 @Test
	 public void test() {
		 int R = 5, C = 6, r0 = 1, c0 = 4;
		 int[][] walks=spiralMatrixIII(R,C,r0,c0);
		 for(int i=0;i<walks.length;i++) {
			 for(int j=0;j<walks[i].length;j++) {
				 System.out.print(walks[i][j]+"  ");
			 }
		 }
	 }
}
