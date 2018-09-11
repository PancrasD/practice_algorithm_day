package com.leetcode.medium;

import org.junit.Test;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
    	int sum1=0;
    	int sum2=0;
    	int left=0;
    	int right=piles.length-1;
		return findWin(left,right,sum1,sum2,piles);
        
    }

	private boolean findWin(int left, int right, int sum1, int sum2, int[] piles) {
		if(left==right-1) {
			sum1+=piles[left]<piles[right]?piles[right]:piles[left];
			sum2+=piles[left]<piles[right]?piles[left]:piles[right];
			return sum1>sum2?true:false;
		}
		int selected=findSelect(left,right,piles);
		if(selected==left) {
			left+=1;
		}else {
			right-=1;
		}
		sum1+=piles[selected];
		if(left==right) {
			sum2+=piles[left];
			return sum1>sum2?true:false;
		}
		selected=findSelect(left,right,piles);
		if(selected==left) {
			left+=1;
		}else {
			right-=1;
		}
		sum2+=piles[selected];
		return findWin(left,  right, sum1, sum2, piles);
	}

	private int findSelect(int left, int right, int[] piles) {
		int selected1=left;
		int value1=piles[left];
		int value2=piles[left+1]<piles[right]?piles[right]:piles[left+1];
		int tem1=value2-value1;
		int value11=piles[right];
		int value22=piles[left]<piles[right-1]?piles[right-1]:piles[left];
		int tem2=value22-value11;
		if(tem2<tem1) {
			selected1=right;
		}else if(tem2==tem1) {
			if(value22<value2) {
				selected1=right;
			}
		}
		return selected1;
	}
	@Test
	public void test() {
		int a[]= {6,3,9,9,3,8,8,7};
		System.out.println(stoneGame(a));
	}
}
