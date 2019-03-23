package com.my.test;

import java.io.PrintWriter;
import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int[] max=new int[3];
		while(sc.hasNext()) {
			int a=sc.nextInt();
			if(a>0&&a>max[0]) {
				max[0]=a;
				update(max);
			}
		}
		pw.println(max[0]*max[1]*max[2]);
		pw.close();
		sc.close();
	}
    
	private static void update(int[] max) {
		for(int i=0;i<max.length-1;i++) {
			if(max[i]>max[i+1]) {
				int temp=max[i+1];
				max[i+1]=max[i];
				max[i]=temp;
			}
		}
	}
}

