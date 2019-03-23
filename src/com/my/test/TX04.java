package com.my.test;

import java.util.Scanner;

public class TX04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();

        if(S>N){
            throw new RuntimeException();
        }
		for(int i=0; i<S; i++) {
			sc.nextLine();
		}
		
		int result=1;
		int cns = 1;
		int temp=N;
		for(int i=0;i<S; i++) {
			cns*=temp--;
		}
		cns /= jiecheng(S);
		int s2 = (int) Math.pow(2,(N-S));
		result = cns *s2;
		
		System.out.println(result%(10^9+7));
	}

	private static int jiecheng(int n) {
		int s = 1;
		for(int i=0; i<n;i++) {
			s*=n--;
		}
		return s;
		
	}
}
