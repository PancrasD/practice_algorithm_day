package com.book.jianzhi;

import org.junit.Test;

public class RepalceBlank {
	@Test
    public void test1() {
    	//char[]strs=str.toCharArray();
		String str="we aaa  sedd ee rtt er er erq qw er qewrr";
    	//1
		long t1=System.nanoTime();
		String str1=replace1(str);
		long t2=System.nanoTime();
    	System.out.println(str1);
    	System.out.println(t2-t1);
    	long t3=System.nanoTime();
		String str2=replace1(str);
		long t4=System.nanoTime();
    	System.out.println(str2);
    	System.out.println(t4-t3);
    	long t5=System.nanoTime();
		String str3=replace1(str);
		long t6=System.nanoTime();
    	System.out.println(str3);
    	System.out.println(t6-t5);
    	
    }
    //单线程  StringBuilder O(n) 创建新的字符串  多线程StringBuffer 复制一次
    public  String  replace1(String str) {
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)==' ') {
    			sb.append("%20");
    		}else {
    		  sb.append(str.charAt(i));
    		}
    	}
    	return sb.toString();
    }
    //单线程  StringBuilder 多线程StringBuffer O(n)  本方法较replace3  复制两次
    public String replace2(String str) {
    	int numspace=0;
    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)==' ') {
    			numspace++;
    		}
    	}
    	StringBuffer strb=new StringBuffer(str);//StringBuffer StringBuilder 内部是创建了一个char 数组
        strb.setLength(str.length()+2*numspace);//
        int newi=str.length()+2*numspace-1;
        for(int i=str.length()-1;i>=0;i--) {
        	if(str.charAt(i)==' ') {
        		strb.setCharAt(newi--, '%');
        		strb.setCharAt(newi--, '2');
        		strb.setCharAt(newi--, '0');
        	}else {
        		strb.setCharAt(newi--, str.charAt(i));
        	}
        }
        return strb.toString();
    }
    //char array O(n) 创建新的字符串 复制一次
    public String replace3(String str) {
    	int numspace=0;
    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)==' ') {
    			numspace++;
    		}
    	}
    	char[] strs=new char[str.length()+2*numspace];
    	int j=0;
    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)==' ') {
    			strs[j++]='%';
    			strs[j++]='2';
    			strs[j++]='0';
    		}
    		else {
    			strs[j++]=str.charAt(i);
    		}
    	}
    	return strs.toString();
    }
}
