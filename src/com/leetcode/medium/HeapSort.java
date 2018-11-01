package com.leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

public class HeapSort {
	   public void heapSort(int arr[]) {
		   int n=arr.length-1;
		   int parent=(n-1)/2;
		   int len=arr.length;
		   buildHeap(arr,parent,len);
		   for(int i=arr.length-1;i>=0;i--) {
			   swap(arr,0,i);
			   buildHeap(arr,0,i);
		   }
	   }
	
	 private void swap(int[] arr, int i1, int i2) {
		int t=arr[i1];
		arr[i1]=arr[i2];
		arr[i2]=t;
	}

	private void buildHeap(int[] arr, int parent, int len) {
		  for(int i=parent;i>=0;i--) {
			  int temp=arr[i];
			  int j;
			  for(j=i;leftchild(j)<len;) {
				  int child=leftchild(j);
				  if(child<len-1) {
					 if(arr[child]<arr[child+1]) {
						 child++;
					 }
				  }
				  if(temp<arr[child]) {
					  arr[j]=arr[child];
				  }else {
					  break;
				  }
				  j=child;
			  }
			  arr[j]=temp;
		  }
	 }

	private int leftchild(int i) {
		return 2*i+1;
	}
	@Test
	public void test() {
		int[]arr= {1,4,2,45,9,43,24,5656,34,56,2,5,7,6};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
