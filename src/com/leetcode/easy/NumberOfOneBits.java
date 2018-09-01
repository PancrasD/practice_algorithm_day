package com.leetcode.easy;

import org.junit.Test;

/*
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has 
 * (also known as the Hamming weight).
 */
public class NumberOfOneBits {
	 public int hammingWeight(int n) {
		int count=0;
		for(int i=0;i<32;i++){
			count+=(n&1);//&位操作符
			n=n>>1;
		}
		return count;
	    /* int nn=toBinaryCount(n);
	     return nn;*/
	    
	 }
	 private Integer toBinaryCount(long n) {
			int count=0;
			int x1=(int) (n/2);
	        int x2=(int) (n%2);
	        if(x2==1) {
	        	count++;
	        }
	        n=x1;
	        while(n>0) {
	        	x1=(int) (n/2);
	            x2=(int) (n%2);
	            n=x1;
	            if(x2==1) {
		        	count++;
		        }
	        }
			return count;
		}
	 @Test
	 public  void test() {
		 System.out.println(hammingWeight(128));
	 }
}
