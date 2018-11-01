package com.leetcode.medium;

import java.util.Stack;

public class ScoreofParentheses {
	public int scoreOfParentheses(String S) {
		char[] ss=S.toCharArray();
        Stack<Character> stack=new Stack<Character>();
        stack.push(ss[0]);
        for(int i=1;i<ss.length;i++){
        	switch(ss[i]) {
        	   case '(':stack.push(ss[i]);break;
        	   case ')':i=doright(stack,i);break;
        	   default:doNumber(stack,ss[i]);break;
        }
        }
        int num=0;
        while(!stack.isEmpty()) {
        	num+=stack.pop();
        }
        return num;
        
    }

	private void doNumber(Stack<Character> stack, char c) {
		char i=stack.pop();
		if(i!='(') {
			stack.push((char) (i+c));
		}else {
			stack.push(c);
		}
		
	}

	private int doright(Stack<Character> stack, int i2) {
		char i=stack.pop();
		if(i=='(') {
			stack.push((char) 1);
		}else {
			//i是个数字
			char j=stack.pop();//
			if(j=='(') {
				stack.push((char) (i*2));
			}else {
				stack.push((char) (i+j));
				i2--;
			}
		}
		return i2;
	}
}
