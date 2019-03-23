package com.my.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QIHU01 {

	public static void main(String[] args) {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
		try {
			int N=bf.read()-'0';
			bf.read();
			int M=bf.read()-'0';
			bf.readLine();
			int k;
			List<Integer>list=new ArrayList<>(N);
			for(int i=0;i<N;i++) {
				k=bf.read()-'0';
				list.add(k);
				bf.read();
			}
			if(N<=M) {
				pw.println(list.get(list.size()-1));
			}else {
			int two=N-M;
			int one=2*M-N;
			//排序
			Collections.sort(list);
			int sec=list.get(0)+list.get(list.size()-one-1);
			pw.println(sec);
			}
			pw.flush();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
