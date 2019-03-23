package com.leetcode.easy;


public class DeleteLinkedListNode13 {
	//O(1)时间要求   1从头遍历O(n) 2删除下一节点O(1)
	public void deleteNode(Node head,Node node) {//确保删除的节点一定在链表中
		if(head==null||node==null) {
			return ;
		}
		if(head==node) {
			head=head.next;
			node=null;//注意置null
		}
		if(node.next!=null) {
			Node next=node.next;
			node.val=next.val;
			node.next=next.next;
			next.next=null;
		}else if(node.next==null) {
			Node p=head;
			Node last=p;
			while(p.next!=null) {
				last=p;
				p=p.next;
			}
			last.next=null;
			p=null;//注意置null
		}
	}
	 public class Node {
	    int val;
	    Node next;
	    Node(int x) { val = x; }
	 }
}
