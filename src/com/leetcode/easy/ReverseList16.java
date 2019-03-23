package com.leetcode.easy;

import org.junit.Test;

public class ReverseList16 {
	public Node reverse(Node head) {
		if(head==null||head.next==null) {
			return head;
		}
		Node pre=null;
		Node p2=head;
		Node p1=head.next;
		while(p1!=null) {
			Node next=p1.next;
			p2.next=pre;
			p1.next=p2;
			pre=p2;
			p2=p1;
			p1=next;
		}
		return p2;
	}
    @Test
    public void test() {
    	//null 单节点  多节点
    	/*Node head=null;
    	Node newH=reverse(head);
    	while(newH!=null) {
    		System.out.print(newH.next+" ");
    		newH=newH.next;
    	}*/
    	Node head=new Node(1);
    	Node next1=new Node(2);
    	head.next=next1;
    	Node next2=new Node(3);
    	next1.next=next2;
    	Node next3=new Node(4);
    	next2.next=next3;
    	Node newH=reverse(head);
    	while(newH!=null) {
    		System.out.print(newH.val+" ");
    		newH=newH.next;
    	}
    }
	class Node {
		int val;
		Node next;
		Node(int val){
			this.val=val;
		}
	}
}
