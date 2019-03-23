package com.list.mylist;

class MyLinkedList {

    /** Initialize your data structure here. */
    Node<Integer> head;
	Node<Integer> tail;
	int size;
	int modCount;
    public MyLinkedList() {
        clear();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node<Integer> node;
        if(size()==0){
            return -1;
        }
        if(index>=size()||index<0) {
        	return -1;
        }
        if(index<size()/2) {
        	node=head;
        	for(int i=0;i<index;i++) {
        		node=node.next;
        	}
        }else {
        	node=tail;
        	for(int i=size()-1;i>index;i--) {
        		node=node.pre;
        	}
        }
		return (int) node.val;
        
    }
    public Node<Integer> getNode(int index) {
        Node<Integer> node;
        if(index>=size()||index<0) {
        	return null;
        }
        //index 0 size-1
        if(index<size()/2) {
        	node=head.next;
        	for(int i=0;i<index;i++) {
        		node=node.next;
        	}
        }else {
        	node=tail.pre;
        	for(int i=size()-1;i>index;i--) {
        		node=node.pre;
        	}
        }
		return node;
        
    }
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node<Integer> nH=new Node<Integer>(val,null,head.next);
        head.next.pre=nH;
        head=nH;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node<Integer> nT=new Node<Integer>(val,tail.pre,null);
        tail.pre.next=nT;
        tail=nT;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<=size()&&index>=0){
            if(index==size()){
                addAtTail(val); 
            }else{
                Node<Integer> node=getNode(index);
        	    Node<Integer> oneNode=new Node<Integer>(val,node.pre,node);
                node.pre.next=oneNode;
        	    node.pre=oneNode;
                size++; 
            }
        }
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	
        if(index<size()&&index>=0){
            Node<Integer> node=getNode(index);
            node.pre.next=node.next;
            node.next.pre=node.pre;
            size--;
        }
    	
    }
    public int size() {
    	return size;
    }
    public void clear(){
        head=new Node<Integer>(null,null,null);
        tail=new Node<Integer>(null,head,null);
        head.next=tail;
        size=0;
        modCount++;
    }
    private static class Node<Integer>{
    	Object val;
        Node<Integer> next;
        Node<Integer> pre;
        public Node(Integer val,Node<Integer> pre,Node<Integer> next){
            this.val=val;
            this.pre=pre;
            this.next=next;
        }
       
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */