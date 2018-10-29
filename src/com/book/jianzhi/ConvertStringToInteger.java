package com.book.jianzhi;

import org.junit.Test;

public class ConvertStringToInteger {
    public void convert(String str) {
    	if(str==null||str.equals("")) {
    		System.out.println("str为空");
    	}
    	int number=0;
    	boolean flag=true;
    	if(str.charAt(0)=='-') {
    		if(str.compareTo(Integer.MIN_VALUE+"")>0) {
    			System.out.println("超出范围");
    			flag=false;
    		}else {
    		for(int i=1;i<str.length();i++) {
    			int k=str.charAt(i)-'0';
    			if(k<=9&&k>=0) {
    				number+=k*Math.pow(10, str.length()-1-i);
    			}else {
    				flag=false;
    				break;
    			}
    		}
    		number-=number*2;
    		}
    	}else {
    		if(str.compareTo(Integer.MAX_VALUE+"")>0) {
    			System.out.println("超出范围");
    			flag=false;
    		}else {
    		for(int i=0;i<str.length();i++) {
    			int k=str.charAt(i)-'0';
    			if(k<=9&&k>=0) {
    				number+=k*Math.pow(10, str.length()-i-1);
    			}else {
    				flag=false;
    				break;
    			}
    		}
    		}
    	}
    	if(flag) {
    		System.out.println(number);
    	}
    	else {
    		System.out.println("非法字符串"+str);
    	}
    }
    @Test
    public void test() {
    	String str1="123456";
    	String str2="-12345";
    	String str3="123m567";
    	String str4="1234***hii";
    	String str5="2147483647";
    	String str6="21474836473";
    	String str7="-2147483648";
    	String str8="-21474836489";
    	convert(str1);
    	convert(str2);
    	convert(str3);
    	convert(str4);
    	convert(str5);
    	convert(str6);
    	convert(str7);
    	convert(str8);
    	
    }
    @Test
    public void testExperial() {
    	System.out.println(Math.pow(0, 0));
    }
}
