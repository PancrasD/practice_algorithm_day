package com.book.jianzhi;

import java.util.Random;

import org.junit.Test;

public class ReverseK {
	 public ListNode findreverseK(ListNode head,int k) {
		if(head==null||k<=0) {
			return null;
		}
		boolean flag=true;
		int count=1;
		ListNode node=head;
		
		while(count<k) {
			if(node.next!=null) {
				node=node.next;
				count++;
			}else {
				flag=false;//元素不足
				break;
			}
		}
		if(!flag) {
			System.out.println("k超过链表长度");
			return null;
		}
		ListNode p2=head;
		while(true) {
			if(node.next!=null) {
				node=node.next;
				p2=p2.next;
			}else {
				break;
			}
		}
		return p2;
		
	 }
     class ListNode{
    	 int val;
    	 ListNode next;
    	 ListNode(int val){
    		 this.val=val;
    	 }
     }
     @Test
     public void test() {
    	 int number=10;
    	 ListNode head=constructList(number);
    	 System.out.println();
    	 ListNode nullHead=null;
    	 ListNode knode=findreverseK(head,10);
    	 if(knode!=null) {
    		 System.out.println(knode.val);
    	 }
    	 
     }
	private ListNode constructList(int number) {
		int k=(new Random()).nextInt(10);
		System.out.print(k+" ");
		ListNode node=new ListNode(k);
		number--;
		if(number>0) {
			node.next=constructList(number);
		}
		return node;
	}
}
