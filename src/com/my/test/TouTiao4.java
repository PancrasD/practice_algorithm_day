package com.my.test;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

public class TouTiao4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n; 
		int m; 
		n = sc.nextInt();
		m = sc.nextInt();
		double[] has = new double[n]; 
		for(int i=0; i<n; i++) {
			has[i] = sc.nextInt();
		}
		if(m <= n) {
			Arrays.sort(has);
			System.out.println(String.format("%.2f", has[n-m])); 
		}
		sc.close();
	}
}