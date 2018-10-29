package com.book.jianzhi;

import java.util.Random;
import java.util.Stack;

import org.junit.Test;

public class PrintListReverse {
	public class ListNode{
		int value;
		ListNode next;
		ListNode(int value,ListNode node){
			this.value=value;
			this.next=node;
		}
		ListNode(int value){
			this.value=value;
		}
	}
	//栈版本
	public void print1(ListNode head) {
		if(head==null) {
			return ;
		}
		if(head.next==null) {
			System.out.println(head.value);
		}
		Stack<Integer> stack =new Stack<Integer>();
		stack.push(head.value);
		while(head.next!=null) {
			stack.push(head.next.value);
			head=head.next;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	//递归版本
	public void print2(ListNode head) {
		if(head==null) {
			return ;
		}
		if(head.next==null) {
			System.out.println(head.value);
		}
		printNext(head);
	}
	
   private void printNext(ListNode head) {
		if(head.next!=null) {
			printNext(head.next);
		}
	    System.out.print(head.value+" ");
		
	}
@Test
   public void test() {
	   //常规
	   int k=(new Random()).nextInt(10);
	   ListNode head=new ListNode(k);
	   addNext(head,k);
	   System.out.println();
	   print2(head);
	   int [] t=new int[10];
	   int len=t.length;
	   
	}
   private void addNext(ListNode head,int count) {
	   if(head==null) {
		   return;
	   }
	    System.out.print(head.value+" ");
	    count--;
		int k=(new Random()).nextInt(100);
		ListNode node=new ListNode(k);
		head.next=node;
		if(count>0) {
			addNext(node,count);
		}else {
			System.out.print(node.value+" ");
		}
  }
}
