package com.book.jianzhi;

import org.junit.Test;

public class PowerImple {
    public double power(double base,int ex) throws Exception {
    	if(base==0.0&&ex<0) {
    		throw new Exception();
    	}
    	
    	if(base==0.0) {
    		return 0;
    	}
    	if(ex==0) {
    		return 1;
    	}
    	int abex=ex;
    	if(ex<0) {
    		abex=(-abex);
    	}
    	double result=compute(base,abex);
        if(ex<0) {
			result=1.0/result;
		}
		return result;
    	
    }

	private double compute(double base, int abex) {
		if(abex==0) {
			return 1;
		}
		if(abex==1) {
			return base;
		}
		double result=compute( base, abex>>1);
		result*=result;
		if((abex&1)==1) {
			result*=base;
		}
		return result;
	}
	@Test
	public void test() {
		try {
			System.out.println(power(2.0,-3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
