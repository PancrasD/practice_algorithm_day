package com.leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

/*
 * 选择排序  每次选择最大|最小的置放直至完成
 */
public class SelectSort {
    public void selectsort(int[] arr) {
    	for(int i=0;i<arr.length-1;i++) {
    		int min=i;
    		for(int j=i+1;j<arr.length;j++) {
    			if(arr[j]<arr[min]) {
    				min=j;
    			}
    		}
    		if(min!=i) {
    			swap(arr,min,i);
    		}
    	}
    }
    public void swap(int[] arr,int a,int b) {
    	arr[a]^=arr[b];
    	arr[b]^=arr[a];
    	arr[a]^=arr[b];
    }
    @Test
	public void test() {
		int[]arr= {1,4,2,45,9,43,24,5656,34,56,2,5,7,6};
		selectsort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
