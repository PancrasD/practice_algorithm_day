package com.my.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RcpspDel {
	@Test
	public void test1() {
		/*
		 * 进行是否显著检测
		 */
		String path="D:\\dengpc\\x_论文文档\\mann\\SFSFOA_VS_NTGA.txt";
		List<Double> HV=new ArrayList<>();
		List<Double> MID=new ArrayList<>();
		List<Double> SNS=new ArrayList<>();
		
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String line="";
			while((line=bf.readLine())!=null) {
				
				if(line.startsWith("P")) {
					line=bf.readLine();//再读一行
					for(int i=0;i<36;i++) {
						line=bf.readLine();
						String[] strs=line.split("\\s+");//HV          MID         SNS
						HV.add(convert(strs[0]));
						MID.add(convert(strs[1]));
						SNS.add(convert(strs[2]));
					}
				}
				line=bf.readLine();//DATA
				line=bf.readLine();//再读一行SFSFOA  NTGA
				line=bf.readLine();//再读一行MID     MID     HV      HV      SNS     SNS
				for(int i=0;i<36;i++) {
					line=bf.readLine();
					String[] strs=line.split("\\s+");
					//MID
					double mid_1=convert(strs[0]);
					double mid_2=convert(strs[1]);
					//HV
					double hv_1=convert(strs[2]);
					double hv_2=convert(strs[3]);
					//SNS
					double sns_1=convert(strs[4]);
					double sns_2=convert(strs[5]);
					//输出
					outputDATA(mid_1,mid_2,MID,i,0);
					outputDATA(hv_1,hv_2,HV,i,1);
					outputDATA(sns_1,sns_2,SNS,i,1);
					System.out.println();
					}
				}
				
			
			bf.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 科学计数转化为double
	 */
	private Double convert(String string) {
		BigDecimal bd = new BigDecimal(string);  
	    double number =  Double.parseDouble(bd.toPlainString());
		return number;
	}
	/*
	 * 输出显著性比较结果
	 * @param SFSFOA 算法指标值
	 * @param NTGA NTGA算法指标值
	 * @param k 第几个案例
	 * @param mark 0 越小越好 1越大越好
	 */
	private void outputDATA(double SFSFOA, double NTGA, List<Double> P, int k, int mark) {
		if(mark==1) {
			if(P.get(k)<0.05) {//原假设不符 
				if(SFSFOA<NTGA) {
					System.out.print(P.get(k)+"(-)"+" ");
				}else {
					System.out.print(P.get(k)+"(+)"+" ");
			  }
			}else {
				System.out.print(P.get(k)+"(=)"+" ");
			}
		}else{
			if(P.get(k)<0.05) {//原假设不符 
				if(SFSFOA<NTGA) {
					System.out.print(P.get(k)+"(+)"+" ");
				}else {
					System.out.print(P.get(k)+"(-)"+" ");
			  }
			}else {
				System.out.print(P.get(k)+"(=)"+" ");
			}
		}
	}
}
