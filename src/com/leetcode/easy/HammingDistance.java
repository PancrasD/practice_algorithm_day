package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * The Hamming distance between two integers is the number of positions at 
 * which the corresponding bits are different
 */
public class HammingDistance {
	public int hammingDistance2(int x, int y) {
		int count=0;
		for(int i=0;i<32;i++) {
		   count+=(x&1)^(y&1);
		   x=x>>1;
		   y=y>>1;
		}
		return count;
	}
    public int hammingDistance1(int x, int y) {
    	int hd=0;
        List<Integer> xx=new ArrayList<>();
        List<Integer> yy=new ArrayList<>();
        xx=toBinary(x);
        yy=toBinary(y);
        int len1=xx.size();
        int len2=yy.size();
        int max=len1<len2?len2:len1;
        for(int i=max-1;i>=0;i--) {
        	int xb;
        	int yb;
        	try {
				xb=xx.get(i);
			} catch (Exception e) {
				xb=0;
			}
        	try {
				yb=yy.get(i);
			} catch (Exception e) {
				yb=0;
			}
        	if(xb!=yb) {
        		hd++;
        	}
        }
        return hd;
    }

	private List<Integer> toBinary(int x) {
		List<Integer> xx=new ArrayList<>();
		int x1=x/2;
        int x2=x%2;
        xx.add(x2);
        x=x1;
        while(x>0) {
        	x1=x/2;
            x2=x%2;
            xx.add(x2);
            x=x1;
        }
		return xx;
	}
	@Test
	public void test() {
		long t1=System.nanoTime();
		System.out.println(hammingDistance1(134223432,123234455));
		long t2=System.nanoTime();
		System.out.println(t2-t1);
		long t3=System.nanoTime();
		System.out.println(hammingDistance2(134223432,123234455));
		long t4=System.nanoTime();
		System.out.println(t4-t3);
	}
}
