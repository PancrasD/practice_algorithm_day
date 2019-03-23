package com.my.test;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TouTiao2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String str=sc.nextLine();
			String s=check(str);
			System.out.println(s);
		}
		sc.close();
	}

	private static String check(String str) {
		StringBuffer sb=new StringBuffer(str);
		int l=sb.length();
		for(int i=0;i<l;i++) {
			while(i+2<l&&sb.charAt(i)==sb.charAt(i+1)&&sb.charAt(i+1)==sb.charAt(i+2)) {
				sb.deleteCharAt(i+2);
				l=l-1;
			}
			while(i+3<l&&sb.charAt(i)==sb.charAt(i+1)&&sb.charAt(i+2)==sb.charAt(i+3)) {
				sb.deleteCharAt(i+3);
				l=l-1;
			}
		}
		return new String(sb);
	}
}
