package com.list.mylist;

import org.junit.jupiter.api.Test;

public class ListTest {
  @Test
  public void Test() {
	  MyLinkedList m=new MyLinkedList();
	  m.addAtHead(1);
	  m.addAtIndex(1, 2);
  }
}
