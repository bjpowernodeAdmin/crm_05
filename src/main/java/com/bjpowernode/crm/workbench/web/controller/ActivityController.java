package com.bjpowernode.crm.workbench.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.settings.service.impl.UserServiceImpl;
import com.bjpowernode.crm.utils.DateTimeUtil;
import com.bjpowernode.crm.utils.PrintJson;
import com.bjpowernode.crm.utils.ServiceFactory;
import com.bjpowernode.crm.utils.UUIDUtil;
import com.bjpowernode.crm.workbench.domain.Activity;
import com.bjpowernode.crm.workbench.service.ActivityService;
import com.bjpowernode.crm.workbench.service.impl.ActivityServiceImpl;

public class ActivityController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到市场活动控制器");
		
		String path = request.getServletPath();
		
		if("/workbench/activity/getUserList.do".equals(path)){
			
			getUserList(request,response);
			
		}else if("/workbench/activity/save.do".equals(path)){
			
			save(request,response);
			
		}
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("进入到 添加市场活动   的操作");
		
		String id = UUIDUtil.getUUID();
		String owner = request.getParameter("owner");
		String name = request.getParameter("name");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String cost = request.getParameter("cost");
		String description = request.getParameter("description");
		//创建时间：体统当前事件
		String createTime = DateTimeUtil.getSysTime();
		//创建人:当前登录用户
		String createBy = ((User)request.getSession().getAttribute("user")).getName();
		
		Activity a = new Activity();
		a.setId(id);
		a.setOwner(owner);
		a.setName(name);
		a.setStartDate(startDate);
		a.setEndDate(endDate);
		a.setOwner(owner);
		a.setCost(cost);
		a.setDescription(description);
		a.setCreateBy(createBy);
		a.setCreateTime(createTime);
		
		ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
		
		boolean flag = as.save(a);

		PrintJson.printJsonFlag(response, flag);
		
	}

	private void getUserList(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("进入到取得用户列表 的操作");
		
		UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
		
		List<User> uList = us.getUserList();
		
		//将uList解析为[{用户1},{用户2},{用户3}]
		PrintJson.printJsonObj(response, uList);
		
	}
	
	
	
}

















































