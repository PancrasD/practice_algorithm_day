package com.leetcode.medium;

public class OptimalDivision {
     public String optimalDivision(int[] nums) {
    	if(nums==null) {
    		return null;
    	}
    	if(nums.length==1) {
    		return nums[0]+"";
    	}
    	if(nums.length==2) {
    		return nums[0]+"/"+nums[1];
    	}
    	StringBuilder s=new StringBuilder();
    	s.append(nums[0]);
    	s.append("/");
    	s.append("(");
    	int i=1;
    	for(;i<nums.length-1;i++) {
    		s.append(nums[i]);
    		s.append("/");
    	}
    	s.append(nums[i]);
    	s.append(")");
		return s.toString();
        
    }
} 
