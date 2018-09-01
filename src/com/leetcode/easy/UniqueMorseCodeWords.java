package com.leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
/*
 * The length of words will be at most 100.
 *Each words[i] will have length in range [1, 12].
 *words[i] will only consist of lowercase letters.
 */
public class UniqueMorseCodeWords {

     public int uniqueMorseRepresentations(String[] words) {
    	
    	String[] morse= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        //使用Map统计
    	Map<String,Integer> countdiff=new TreeMap<>();
    	int len=words.length;
    	int count=0;
    	for(int i=0;i<len;i++) {
    		StringBuffer key=new StringBuffer();
    		char[] w=words[i].toCharArray();
    		for(int j=0;j<w.length;j++) {
    			int index=w[j]-97;
    			key.append(morse[index]);
    		}
    		String keys=key.toString();
    		Integer value=countdiff.get(keys);
    		if(value==null) {
    			count+=1;
    			value=1;
    			countdiff.put(keys, value);
    		}
    	}
    	return count;
    }
     @Test
     public void test() {
    	 String[] words= {"english","math","chinese","physics","fish","dog","man","hero","woman"};
    	 System.out.println(uniqueMorseRepresentations(words));
     }
}
