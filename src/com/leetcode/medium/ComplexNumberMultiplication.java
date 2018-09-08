package com.leetcode.medium;

import org.junit.Test;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
    	String[] aa=a.split("\\+");
    	String[] bb=b.split("\\+");
    	int m=Integer.valueOf(aa[0])*Integer.valueOf(bb[0]);
    	String[]  aaa=aa[1].split("i");
    	String[]  bbb=bb[1].split("i");
    	int n=Integer.valueOf(aaa[0])*Integer.valueOf(bbb[0])*-1;
    	int kk=Integer.valueOf(aa[0])*Integer.valueOf(bbb[0])+Integer.valueOf(bb[0])*Integer.valueOf(aaa[0]);
		String head=String.valueOf((m+n));
    	String tail=kk+"i";
    	return head+"+"+tail;
        
    }
    @Test
    public void test1() {
    	String a= "1+1i";
    	String b="1+1i";
    	System.out.println(complexNumberMultiply(a,b));
    }
}
