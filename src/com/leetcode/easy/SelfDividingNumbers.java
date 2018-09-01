package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * A self-dividing number is a number that is divisible by every digit it contains.

   For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

   Also, a self-dividing number is not allowed to contain the digit zero.

   Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
   The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class SelfDividingNumbers {
	 public List<Integer> selfDividingNumbers(int left, int right) {
	        List<Integer> numbers=new ArrayList<>();
	        for(int number=left;number<=right;number++) {
	        	int temp=number;
	        	boolean is=true;
	        	for(;temp>0;) {
	        		int digit=temp%10;
	        		temp=temp/10;
	        		if(digit==0||number%digit!=0) {
	        			is=false;
	        			break;
	        		}
	        	}
	        	if(is) {
	        		numbers.add(number);
	        	}
	        }
	        return numbers;
	    }
	 @Test
	 public void test() {
		List<Integer> numbers=selfDividingNumbers(1,22);
		for(int i=0;i<numbers.size();i++) {
			System.out.print(numbers.get(i)+" ");
		}
	 }
}
