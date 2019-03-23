package com.my.test;
//我的github:https://github.com/ygj0930
//我的博客：http://www.cnblogs.com/ygj0930/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Client{
	public int port=8080;
	Socket socket=null;
	@Test
	public void test() {
		/*for(int i=3;i<=36;i++) {
			System.out.println("HV_"+i);
			System.out.println("MID_"+i);
			System.out.println("SNS_"+i);
		}*/
		/*for(int i=2;i<=36;i++) {
			System.out.print("="+i+"!H"+3+" ");
			System.out.print("="+i+"!D"+3+" ");
			System.out.print("="+i+"!L"+3+" ");
		}*/
		/*for(int i=1;i<=108;i++) {
			System.out.print("="+"E"+(4+i)+" ");
			if(i%3==0) {
				System.out.println();
			}
		}*/
		for(int i=2;i<=36;i++) {
			System.out.println("="+i+"!U35");
		}
	}
	
	public static void main(String[] args)
	{
		new Client();
	}
	
	public Client()
	{
		 
		try {  
		    socket=new Socket("172.28.211.111",port);
			
			new Cthread().start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket  
                  .getInputStream()));  
            String msg1;  
            while ((msg1 = br.readLine()) != null) { 
							
                System.out.println(msg1);  
			}
		}catch (Exception e) {  
  
			} 
			
		
	}
	
	class Cthread extends Thread
	{
		 
			public void run() {  
            try {  
			
				BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);  
                String msg2;  
  
                while (true) {  
				
                    msg2 = re.readLine();  
                    pw.println(msg2);  
                }  
            }catch (Exception e) {  
                e.printStackTrace();  
            }  
		
	
		}
	}
	

}