package com.bjpowernode.crm.test;

import com.bjpowernode.crm.utils.MD5Util;

public class Test1 {

	public static void main(String[] args) {
		
		String str = "bjpowernode@ymj.com";
		
		str = MD5Util.getMD5(str);

		System.out.println(str);
		
	}

}
