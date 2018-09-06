package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class FindandReplacePattern {
   public List<String> findAndReplacePattern(String[] words, String pattern) {
	  List<String> patternWords=new ArrayList<>();
	  for(int i=0;i<words.length;i++) {
		  char[] wordchar=words[i].toCharArray();
		  char[] patternchar=pattern.toCharArray();
		  boolean is=true;
		  if(wordchar.length!=patternchar.length){
			  is=false;
		  }else {
			  Map<Character, Character> map1=new TreeMap<Character,Character>();
			  Map<Character, Character> map2=new TreeMap<Character,Character>();
			  for(int j=0;j<wordchar.length;j++) {
				  Character value1= (Character) map1.get(wordchar[j]);
				  Character value2= (Character) map2.get(patternchar[j]);
				  if(value1==null&&value2==null) {
					  map1.put(wordchar[j], patternchar[j]);
					  map2.put(patternchar[j], wordchar[j]);
				  }else if((value1==null&&value2!=null)||(value1!=null&&value2==null)) {
					  is=false;
					  break;
				  }else if(value1!=patternchar[j]||value2!=wordchar[j]) {
					  is=false;
					  break;
				  }
			  }
		  }
		  if(is) {
			  patternWords.add(words[i]);
		  }
	  }
	  return patternWords;
    }
   @Test
   public void test() {
	   String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
	   String pattern = "abb";
	   List<String> map=findAndReplacePattern(words,pattern);
	   for(int i=0;i<map.size();i++) {
		   System.out.println(map.get(i)+" ");
	   }
   }
}
