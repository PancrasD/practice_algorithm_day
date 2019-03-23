package com.my.test;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TX03 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[]mm=new int[m+1];
		sc.nextLine();
		int sum=0;
		boolean flag=false;
		int[] nn=new int[n];
		int has=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			int color=sc.nextInt();
			nn[i]=color;
			if(color!=0&&mm[color]==0) {
				mm[color]++;
				sum++;
			}
			if(sum%m==0) {
				has=i;
				int[] m1=new int[m+1];
				int l=0;
				for(int j=has;j>=0;j--) {
					int color1=nn[j];
					if(color1!=0&&m1[color1]==0) {
						m1[color]=1;
						l++;
					}
					if(l==m) {
						int k=has-i+1;
						if(k<min) {
							min=k;
						}
						mm[nn[j]]--;
						if(mm[nn[j]]==0) {
							sum--;
						}
					}
			}
		}
		}
		if(!flag) {
			pw.print(-1);
		 }else {
			 pw.println(min);
		 }
		
		pw.flush();
		pw.close();
		sc.close();
	}

}
