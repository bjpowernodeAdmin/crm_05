package com.bjpowernode.crm.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.bjpowernode.crm.utils.DateTimeUtil;

public class Test4 {

	public static void main(String[] args) {
		
		//浏览器的ip
		String ip = "192.168.3.1";
		
		//允许访问的ip地址群
		String allowIps = "192.168.1.1,192.168.1.2,192.168.1.3";
		
		if(allowIps.contains(ip)){
			
			System.out.println("允许访问的ip");
			
		}else{
			
			System.out.println("不允许访问的ip");
			
		}
	
		
		
	}

}
