package com.bjpowernode.crm.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.bjpowernode.crm.utils.DateTimeUtil;

public class Test2 {

	public static void main(String[] args) {
		
		
		String expireTime = "2018-02-10 10:10:10";
		
		String currentTime = DateTimeUtil.getSysTime();
		
		int count = expireTime.compareTo(currentTime);
		
		System.out.println(count);
		
	}

}
