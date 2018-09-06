package com.leetcode.easy;

import org.junit.Test;

public class TestLong {
   
   public int output(long n) {
	   int count = 0;
	   for(int i=0;i<64;i++) {
		   count+=n&1;
		   n=n>>1;
	   }
	   return count;
   }
   @Test
   public void test() {
	   long n=8;
	   System.out.println(output(n));
   }
}
