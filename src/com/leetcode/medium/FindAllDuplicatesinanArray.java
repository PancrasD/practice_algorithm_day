package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
	    List<Integer> list=new ArrayList<>();
        int number;
        int sum;
     	for(int i=0;i<nums.length;i++) {
     		number=nums[i]%(nums.length+1);
     		sum=nums[number-1]/(nums.length+1);
     		if(sum==1) {
     			list.add(number);
     		}else {
     			nums[number-1]+=nums.length+1;
     		}
     	}
 		return list;
    	
    }
    @Test
    public void test () {
    	int[] p= {4,3,2,7,8,2,3,1};
    	List<Integer> list=findDuplicates(p);
    	for(int i=0;i<list.size();i++) {
    		System.out.print(list.get(i)+" ");
    	}
    }
}
