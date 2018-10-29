package com.book.jianzhi;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import org.junit.Test;

public class Move {
   //32位机器 64位机器 整数移位后0 负数移位后全1(-1)
   public int NumberOf1(int n) {
	   int count=0;
       for(int i=1;i<=32;i++){
           count+=n&1;
           n=n>>1;
       }
      return count;
   }
   //不改变输入 与机器位无关
   public int Number1(int n) {
	   int count=0;
	   int flag=1;
	   while(flag!=0) {
		   if((n&flag)!=0) {
			   count++;
		   }
		   flag=flag<<1;
	   }
	   return count;
   }
   @Test
   public void test() {
	   int n=-99;
	   System.out.println(NumberOf1(n));
	   System.out.println(Number1(n));
   }
   @Test
   public void privorityqueueTest() {
	   Queue<Integer> queue=new PriorityQueue<Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1<o2) {
				return 1;
			}else if(o1>o2){
				return -1;
			}
			return 0;
		}
		   
	   });
	   for(int i=0;i<10;i++) {
		   int k=(new Random()).nextInt(10);
		   System.out.print(k);
		   queue.add(k);
	   }
	   System.out.println();
	   while(!queue.isEmpty()) {
		   System.out.print(queue.poll());
	   }
   }
   @Test
   public void arrayQueueTest() {
	   ArrayDeque<Integer> queue=new ArrayDeque<Integer>();
	   for(int i=0;i<10;i++) {
		   int k=(new Random()).nextInt(10);
		   System.out.print(k);
		   queue.add(k);
	   }
	   System.out.println();
	   while(!queue.isEmpty()) {
		   System.out.print(queue.poll());
	   }
   }
   
}
