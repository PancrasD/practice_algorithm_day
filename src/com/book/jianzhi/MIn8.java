package com.book.jianzhi;

import org.junit.Test;

public class MIn8 {
   public void findMin(int[] a) {
	   if(a==null||a.length==0) {
		   return;
	   }
	   if(a.length==1) {
		   System.out.println(a[0]);
	   }
	   int min=find(a,0,a.length-1);
	   System.out.println(min);
   }

private int find(int[] a, int i, int j) {
	if(i==j) {
		return a[i];
	}
	if(i==j-1) {
		return a[i]<a[j]?a[i]:a[j];
	}
	int mid=(i+j)/2;
	if(a[mid]<a[j]) {
		return find(a,i,mid);
	}
	return find(a,mid,j);
}
@Test
public void test() {
	int[] a= {5,6,7,9,13,13,13,0,1,1,3,4};
	int[] b = null;
	int[] c= {1,1,1,1,1,1,1,1};
	int[] d= {1,2,3,4,5,8};
	findMin(d);
}
}
