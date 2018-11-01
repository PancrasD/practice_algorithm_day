package com.leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

public class ShellSort {
   public void shellSort(int[] arr) {
	   for(int gap=arr.length/2;gap>0;gap/=2) {
		   for(int i=gap;i<arr.length;i++) {
			   int j=i;
			   while(j-gap>=0&&arr[j]<arr[j-gap]) {
				   swap(arr,j,j-gap);
				   j-=gap;
			   }
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
  		shellSort(arr);
  		System.out.println(Arrays.toString(arr));
  	}
}
