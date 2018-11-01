package com.leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

/*
 * 冒泡排序 将大值|小值从前往后冒 直到顶端(顶端就是最大值)
 */
public class BubbleSort {
    public void bubbleSort(int arr[]) {
    	for(int i=0;i<arr.length-1;i++) {
    		boolean is=true;
    		for(int j=0;j<arr.length-1;j++) {
    			if(arr[j+1]<arr[j]) {
    				swap(arr,j,j+1);
    				is=false;
    			}
    		}
    		if(is) {
    			break;
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
   		bubbleSort(arr);
   		System.out.println(Arrays.toString(arr));
   	}
}
