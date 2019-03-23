package com.my.test;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TX02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			sc.nextLine();
			if(a==b) {
				if(a%2==0) {
					pw.println(a);
				}else {
					pw.println(-a);
				}
				continue;
			}
			if(a%2==0) {//偶数
				if(b%2==0) {
					pw.println(-(b-a)/2+b);
				}else {
					pw.println(-(b-a+1)/2);
				}
			}else {
				if(b%2==0) {
					pw.println((b-a+1)/2);
				}else {
					pw.println((b-a)/2-b);
				}
			}
		}
		pw.flush();
		pw.close();
		sc.close();
	}
}
