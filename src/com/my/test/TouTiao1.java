package com.my.test;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TouTiao1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        int get=1024;
        int pay=sc.nextInt();
        if(pay==get) {
        	System.out.println(0);
        	return;
        }
        int sum=0;
        int left=get-pay;
        int[]has= {64,16,4,1};
        for(int i=0;i<4;i++) {
        	int per=left/has[i];
            sum+=per;
            left=left-per*has[i];
        }
        System.out.println(sum);
        sc.close();
	}

}
