package com.leetcode.medium;

import java.util.Stack;

import org.junit.Test;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
    	if(A==null||A.length<3) {
    		return 0;
    	}
    	Stack<Integer> stack=new Stack<>();
    	int count=0;
    	stack.push(A[0]);
    	stack.push(A[1]);
    	int diff=A[1]-A[0];
    	for(int i=2;i<A.length;i++) {
    		if(stack!=null&&(A[i]-stack.peek()==diff)) {
    			stack.push(A[i]);
    		}else {
    			if(stack.size()>=3) {
    				if(stack.size()==3) {
    					count+=1;	
    				}else {
    					count+=0.5*(stack.size()-2)*(stack.size()-1);
    				}
    			}
    			int top=stack.pop();
    			stack.clear();
    			stack.push(top);
    			stack.push(A[i]);
    			diff=A[i]-top;
    		}
    	}
    	if(stack.size()>=3) {
			if(stack.size()==3) {
				count+=1;	
			}else {
				count+=0.5*(stack.size()-2)*(stack.size()-1);
			}
		}
		return count;
    }
    @Test
    public void test() {
    	int[] a= {1,2,3,8,9,10};
    	System.out.println(numberOfArithmeticSlices(a));
    }
}
