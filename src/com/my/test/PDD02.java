package com.my.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class PDD02 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt();
		int d=sc.nextInt();
		sc.nextLine();
		int max=0;
		int[] position=new int[n];
		int[] money=new int[n];
		position[0]=sc.nextInt();
		money[0]=sc.nextInt();
		sc.nextLine();
		for(int i=1;i<n;i++) {
			position[i]=sc.nextInt();
			money[i]=sc.nextInt();
			sc.nextLine();
			for(int j=i-1;j>=0;j--) {
				if(position[i]-position[j]>=d) {
					int getMoney=money[i]+money[j];
					if(max<getMoney) {
						max=getMoney;
					}
				}
			}
		}
		pw.println(max);
		pw.flush();
		pw.close();
		sc.close();
	}
}
