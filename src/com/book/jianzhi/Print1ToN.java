package com.book.jianzhi;

import org.junit.Test;

public class Print1ToN {
   public void print(int n) {
	   if(n<=0) {
		   return ;
	   }
	   int number[]=new int[n];
	   while(!increse(number)) {
		   printNumber(number);
	   }
   }

	private void printNumber(int[] number) {
		boolean can=false;
		for(int i=0;i<number.length;i++) {
			if(number[i]!=0) {
				can=true;
			}
			if(can) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
		
	}
	
	private boolean increse(int[] number) {
		boolean isover=false;
		int len=number.length;
		int taskover=0;
		for(int i=len-1;i>=0;i--) {
			int num=number[i]+taskover;
			if(i==len-1) {
				num++;
			}
			if(num>=10) {
				if(i==0) {
					isover=true;
				}
				num-=10;
				taskover=1;
				number[i]=num;
			}else {
				number[i]=num;
				break;
			}
			
		}
		return isover;
	}
	public void print2(int n) {
		if(n<=0) {
			   return ;
		}
		int[] number=new int[n];
		for(int i=0;i<=9;i++) {
			number[0]=i;
			addNext(number,n,0);
		}
	}
	
	private void addNext(int[] number, int n, int index) {
		if(index==n-1) {
			printNumber(number);
			return ;
		}
		for(int i=0;i<=9;i++) {
			number[index+1]=i;
			addNext(number,n,index+1);
		}
		
	}

	@Test
	public void test() {
		print2(2);
	}
}
