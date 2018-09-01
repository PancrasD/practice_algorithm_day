package com.leetcode.easy;

import org.junit.Test;

public class ToLowerCase {
   public String toLowerCase(String str) {
	   char[] s=str.toCharArray();
	   int len=s.length;
	   StringBuffer ss=new StringBuffer();
	   for(int i=0;i<len;i++) {
		   if(s[i]>=65&&s[i]<=90) {
			   s[i]+=32;
		   }
		   ss.append(s[i]);
	   }
	   String news=ss.toString();	   
	   return news;
	   
   }
   @Test
   public void test() {
	   System.out.println(toLowerCase("Hello"));
   }
}
