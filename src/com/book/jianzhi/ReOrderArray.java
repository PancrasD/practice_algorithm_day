package com.book.jianzhi;

import java.util.ArrayDeque;

import org.junit.Test;

public class ReOrderArray {
	 //分区对 没有保持顺序
	  public void reOrderArray(int [] array) {
	        if(array==null||array.length==1){
	            return ;
	        }
	        int left=0;
	        int len=array.length;
	        int right=array.length-1;
	        while(true){
	            while(((array[left]&1)==1)&& (left<len)){
	                left++;
	            }
	             while(((array[right]&1)==0)&& (right>=0)){
	                right--;
	            } 
	            if(left<right){
	                
	                swap(array,left,right);
	            }else{
	                break;
	            }
	        }
	    }
	    public void swap(int[] array,int left,int right){
	        int a=array[left];
	        array[left]=array[right];
	        array[right]=a;
	    }
	    //先入先出 栈  分区及顺序对 额外空间 
	    public void reOrderArray1(int []array) {
	    	 if(array==null||array.length==1){
		            return ;
		        }
	    	 ArrayDeque<Integer> queue1=new ArrayDeque<Integer>();
	    	 ArrayDeque<Integer> queue2=new ArrayDeque<Integer>();
	    	 for(int i=0;i<array.length;i++) {
	    		 if((array[i]&1)==1) {
	    			 queue1.add(array[i]);
	    		 }else {
	    			 queue2.add(array[i]);
	    		 }
	    	 }
	    	 int index=0;
	    	 while(!queue1.isEmpty()) {
	    		 array[index++]=queue1.poll();
	    	 }
	    	 while(!queue2.isEmpty()) {
	    		 array[index++]=queue2.poll();
	    	 }
	    	 for(int i=0;i<array.length;i++) {
	    		 System.out.print(array[i]+" ");
	    	 }
	    }
	    //分区 顺序不对
	    public void reOrderArray2(int []array) {
	    	if(array==null||array.length==1){
	            return ;
	        }
	        int left=0;
	        int len=array.length;
	        while(true){
	            while((left<len)&&((array[left]&1)==1)){
	                left++;
	            }
	            int i=left+1;
	            while((i<len)&&((array[i]&1)==0)){
	                i++;
	            }
                if((left<len) &&(i<len)&&(left<i)) {
                	swap(array,left,i);
                }else {
                	break;
                }
	        }
	        for(int i=0;i<array.length;i++) {
	    		 System.out.print(array[i]+" ");
	    	 }
	    }
	   @Test
	   public void test() {
		   int[]array= {1,2,3,4,5,6,7};
		   reOrderArray2(array);
	   }
	    
}
