package com.my.test;

import java.util.Scanner;

public class TouTiao3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			sc.nextLine();
			int[] grade=new int[num];
			for(int j=0;j<num;j++) {
				grade[j]=sc.nextInt();
			}
			if(num==1) {
				System.out.println(1);
			}else {
			  int min=getMin(grade);
			  System.out.println(min);
			}
			sc.nextLine();
		}
	}

	private static int getMin(int[] grade) {
		int minIndex=0;
		int min=grade[0];
		for(int i=1;i<grade.length;i++) {
			if(grade[i]<min) {
				minIndex=i;
				min=grade[i];
			}
		}
		int endIndex=minIndex-1;
		if(endIndex<0) {
			endIndex=grade.length-1;
		}
		int[]gg=new int[grade.length];
		gg[minIndex]=1;
		int nextindex=minIndex+1;
		check(nextindex,gg,grade);
		int sum=0;
		for(int i=0;i<gg.length;i++) {
			sum+=gg[i];
		}
		return sum;
	}

	private static boolean check(int nextindex, int[] gg, int[] grade) {
		int lastIndex=nextindex-1;
		if(nextindex>=gg.length) {
			nextindex=0;
		}
		if(gg[nextindex]!=0) {
			if(grade[nextindex]>grade[lastIndex]&&gg[nextindex]>gg[lastIndex]) {
				return true;
			}
			if(grade[nextindex]<grade[lastIndex]&&gg[nextindex]<gg[lastIndex]) {
				return true;
			}else {
				return false;
			}
		}
		int k=1;
		boolean can=false;
		if(grade[nextindex]>grade[lastIndex]) {
			while(!can) {
				int next=gg[lastIndex]+k;
				gg[nextindex]=next;
				can=check(nextindex+1, gg,  grade) ;
				if(!can) {
					gg[nextindex]=0;
				}
				k++;
			}
		}else {
			while(!can) {
				int next=k;
				if(grade[nextindex]<grade[lastIndex]&&next>=gg[lastIndex]) {
					return false;
				}
				gg[nextindex]=next;
				can=check(nextindex+1, gg,  grade) ;
				if(!can) {
					gg[nextindex]=0;
				}
				k++;
			}
		}
		return can;
	
	}

}
