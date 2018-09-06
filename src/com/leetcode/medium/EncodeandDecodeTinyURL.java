package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class EncodeandDecodeTinyURL {
   private Map<Integer,String> map=new HashMap<>();
   public String encode(String longUrl) {
	   Integer size=map.keySet().size();
       map.put(size, longUrl);
       return String.valueOf(size);
   }

   // Decodes a shortened URL to its original URL.
   public String decode(String shortUrl) {
	 Integer key=Integer.valueOf(shortUrl);
	return map.get(key);  
   }
   @Test
   public void test() {
	   String url="http://dfghjhgfdsa/ertyu/asdfgh";
	   EncodeandDecodeTinyURL codec = new EncodeandDecodeTinyURL();
	   System.out.println(codec.decode(codec.encode(url)));
   }
   @Test
   public void test1() {
	   List<Integer> a=new ArrayList<>();
	   for(int i=0;i<10;i++) {
		   a.add(i);
	   }
	   List<Integer> b=new ArrayList<>();
	   for(int i=0;i<10;i++) {
		   b.add(((new Random()).nextInt(30)));
	   }
	   Collections.sort(a,new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			int is=0;
			//升序
			if(b.get(o1)>b.get(o2)) {
				is=1;
			}else if(b.get(o1)<b.get(o2)) {
				is=-1;
			}
			return is;
		}
	   });
	   for(int i=0;i<a.size();i++) {
		   System.out.print(b.get(a.get(i))+" ");
	   }
   }
}
