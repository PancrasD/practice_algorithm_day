package com.my.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TX01 {
	public static void main(String[] args) {
		/*BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));*/
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
		int n=sc.nextInt();
		int m=sc.nextInt();
		int sum=0;
		for(int i=n;i>=1;) {
			int c=m/i;
			sum+=c;
			m=m-c*i;
			if(m>0) {
			  i=m;
			}else {
				break;
			}
		}
		pw.print(sum);
		pw.flush();
		pw.close();
		sc.close();
		//
	}
	
}
