package com.book.jianzhi;

import org.junit.Test;

public class StringFindNumber {
   public boolean findnumber(int[][] A,int b) {
	   if(A==null) {
		   return false;
	   }
	   boolean exit=false;
	   int i=0;
	   int j=A[0].length-1;
	   while(i<A.length&&j>=0) {
		   if(A[i][j]==b) {
			   exit=true;
			   break;
		   }else if(A[i][j]<b){
			   i++;
		   }else {
			   j--;
		   }
	   }
	   return exit;
   }
   @Test
   public void test1() {
	   int[][] A= {{1,2,8,9,10},
			      {3,6,11,23,25},
			      {5,12,14,29,32},
			      {89,123,544,567,987},
			      {125,234,578,789,999}};
	   boolean is=findnumber(A,111);
	   System.out.println(is);      
   }
}
