package com.leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class CustomSortString {
	 public String customSortString(String S, String T) {
		 char[] tt=T.toCharArray();
		 Map<Character,Integer> map=new TreeMap<>();
		 for(int i=0;i<tt.length;i++) {
			 char c=tt[i];
			 Integer count=map.get(c);
			 if(count==null) {
				 map.put(c, 1);
			 }else {
				 map.put(c, (++count));
			 }
		 }
		StringBuffer ss=new StringBuffer();
		for(int i=0;i<S.length();i++) {
			char s=S.charAt(i);
			Integer count=map.get(s);
			if(count!=null) {
				for(int j=0;j<count;j++) {
					ss.append(s);
				}
				map.remove(s);
			}
		}
		for(Map.Entry<Character, Integer> entry:map.entrySet()) {
			char key=entry.getKey();
			int count =entry.getValue();
			for(int i=0;i<count;i++) {
				ss.append(key);
			}
		}
		return ss.toString(); 
	    }
	 @Test
	 public void test() {
		 long t1=System.nanoTime();
		 System.out.println(customSortString("kqep", "pekeq"));
		 long t2=System.nanoTime();
		 System.out.println(t2-t1);
	 }
}
