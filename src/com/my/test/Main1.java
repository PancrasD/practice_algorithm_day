package com.my.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
		
			try {
				int N=bf.read()-'0';
				bf.read();
				int M=bf.read()-'0';
				bf.read();
				int K=bf.read()-'0';
				int[][] a=new int[N][M];
				bf.readLine();
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						int l=bf.read()-'0';
						bf.read();
						a[i][j]=l;
					}
					bf.readLine();
				}
				List<Integer> li=new ArrayList<>();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			
		
	
	
	}
}

	
