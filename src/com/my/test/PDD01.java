package com.my.test;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PDD01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		String line=sc.nextLine().toLowerCase();
		List<List<Integer>> list=new ArrayList<>();
		for(int i=0;i<26;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<line.length();i++) {
			char k=line.charAt(i);
			list.get(k-'a').add(i);
			
		}
		char minChar=line.charAt(0);
		int minIndex=0;
		for(int i=1;i<line.length();i++) {
			//找到第一个比minChar小的
			char k=line.charAt(i);
			if(k<minChar) {
				boolean can=true;
				for(int j=minIndex;j<=i;j++) {
					char c=line.charAt(j);
					List<Integer> charlist=list.get(c-'a');
					if(charlist.size()>0&&charlist.get(charlist.size()-1)<i) {
						can=false;
					}
				}
				if(can) {
					minIndex=i;
					minChar=k;
				}else {
					break;
				}
			}
		}
		pw.println(minChar);
		pw.flush();
		pw.close();
		sc.close();
	}
}
