package com.my.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Test1 {

	public static void main(String args[]) {
		StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		try {
			while(st.nextToken()!=StreamTokenizer.TT_EOF) {
				int n=(int) st.nval;
				int nn[]=new int[n];
				int k=st.nextToken();
				for(int i=0;i<n;i++) {
					nn[i]=(int) st.nval;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
