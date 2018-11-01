package com.leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSort {
    public void insertionSort(int[] arr) {
    	for(int i=1;i<arr.length;i++) {
    		int j=i;
    		while(j>0&&arr[j]<arr[j-1]) {
    			swap(arr,j,j-1);
    			j--;
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
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
