package com.leetcode.easy;

import org.junit.Test;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.

   If there are two middle nodes, return the second middle node.
   The number of nodes in the given list will be between 1 and 100.
   */
public class MiddleoftheLinkedList {
	 public ListNode middleNode(ListNode head) {
		 ListNode [] a=new ListNode[100];
	     int count=1;
	     a[0]=head;
	     ListNode node=head;
	     while (node.next!=null) {
	    	   a[count]=node.next;
	    	   node=node.next;
	    	   count++;
	       }
	     return a[count/2];
	    }
	 class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}
	 @Test
	 public void test() {
		 
	 }
}
