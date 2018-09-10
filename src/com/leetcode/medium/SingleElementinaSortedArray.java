package com.leetcode.medium;

import org.junit.Test;

public class SingleElementinaSortedArray {
	public int singleNonDuplicate(int[] nums) {
		int start=0;
		int end=nums.length-1;
		return findSingle(nums,start,end);
	    }

	private int findSingle(int[] nums, int start, int end) {
		if(start==end) {
			return nums[end];
		}
		int mid=(start+end)>>1;
		if(mid%2!=0){
			mid--;
		}
		if(nums[mid]!=nums[mid+1]) {
			return findSingle(nums,start,mid);
		}else {
			return findSingle(nums,mid+2,end);
		}
	}
	@Test
	public void test() {
		int[]m= {3,3,7,7,10,11,11};
		System.out.println(singleNonDuplicate(m));
	}
}
