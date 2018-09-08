package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
    	Map<Character,Integer> map=new HashMap<Character,Integer>();
    	char[] ss=S.toCharArray();
    	for(int i=0;i<ss.length;i++) {
    			map.put(ss[i], i);
    		
    	}
    	List<Integer> a=new ArrayList<>();
    	a=findmaxPart(ss,map,0,a);
		return a;
        
    }

	private List<Integer> findmaxPart(char[] ss, Map<Character, Integer> map, int k, List<Integer> a) {
		if(k==ss.length) {
			return a;
		}
		int begin=k;
		int end=map.get(ss[begin]);
		int max=0;
		boolean is=true;
		while(is) {
			for(int i=begin;i<=end;i++) {
				if(map.get(ss[i])>max) {
					max=map.get(ss[i]);
				}
			}
			if(max==end) {
				is=false;
			}else {
				begin=end+1;
				end=max;
			}
		}
		a.add(max-k+1);
		a=findmaxPart(ss,map,max+1,a);
		return a;
	}
	@Test
	public void test() {
	  String S = "ababcbacadefegdehijhklij";
	  List<Integer> a=partitionLabels(S);
	  for(int i=0;i<a.size();i++) {
		  System.out.println(a.get(i));
	  }
	}
}
