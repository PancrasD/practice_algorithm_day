package com.leetcode.medium;

public class CountingBits {
	public int[] countBits(int num) {
        int[] all=new int[num+1];
        for(int i=1;i<=num;i++){
            all[i]=all[i>>1]+(i&1);
        }
        return all;
    }
}
