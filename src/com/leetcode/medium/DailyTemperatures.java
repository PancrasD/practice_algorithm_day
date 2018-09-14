package com.leetcode.medium;

import java.util.Stack;

import org.junit.Test;

public class DailyTemperatures {
	 public int[] dailyTemperatures1(int[] temperatures) {
		for(int i=0;i<temperatures.length-1;i++) {
			boolean is=true;;
			for(int j=i+1;j<temperatures.length;j++) {
				if(temperatures[i]<temperatures[j]) {
					temperatures[i]=j-i;
					is=false;
					break;
				}
			}
			if(is) {
				temperatures[i]=0;
			}
		}
		temperatures[temperatures.length-1]=0;
		return temperatures; 
	    }
	 public int[] dailyTemperatures(int[] temperatures) {
		 int[] re=new int[temperatures.length];
		 Stack<Integer> stack=new Stack<>();
		 for(int i=0;i<temperatures.length;i++) {
			 while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]) {
				 int k=stack.pop();
				 re[k]=i-k;
			 }
			 stack.push(i);
		 }
		 return re;
	 }
	 @Test
	 public void test() {
		 int[] a= {73, 74, 75, 71, 69, 72, 76, 73};
		 a=dailyTemperatures(a);
		 for(int i=0;i<a.length;i++) {
			 System.out.print(a[i]+" ");
		 }
		 }
}
