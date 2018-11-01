package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
public class PalindromicSubstrings {
	 public int countSubstrings(String s) {
		char[]ss=s.toCharArray();
		Map<Character,List<Integer>> map=new TreeMap<>();
		int count=ss.length;
		for(int i=0;i<ss.length;i++) {
			List<Integer> list=map.get(ss[i]);
			if(list==null) {
				list=new ArrayList<>();
				list.add(i);
				map.put(ss[i], list);
			}else {
				list.add(i);
			}
		}
		boolean is=false;
		for(Map.Entry<Character, List<Integer>> entry:map.entrySet()) {
			List<Integer> list=entry.getValue();
			int begin=0;
			int end=0;
			for(int i=0;i<list.size()-1;i++) {
				for(int j=i+1;j<list.size();j++) {
					begin=list.get(i);
					end=list.get(j);
					is=judge(ss,begin+1,end-1);
					if(is) {
						count++;
					}
				}
			}
		}
		return count;
	        
	}

	private boolean judge(char[] ss, int begin, int end) {
		if(begin>=end) {
			return true;
		}
		while(true&&begin<end) {
			if(ss[begin]!=ss[end]) {
				return false;
			}
			begin+=1;
			end-=1;
		}
		return true;
	}
   @Test
   public void test() {
	   String a="abba";
	   System.out.println(countSubstrings(a));
   }
}
