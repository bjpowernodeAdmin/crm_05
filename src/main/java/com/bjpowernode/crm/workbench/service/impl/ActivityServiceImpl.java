package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.utils.SqlSessionUtil;
import com.bjpowernode.crm.workbench.dao.ActivityDao;
import com.bjpowernode.crm.workbench.dao.ActivityRemarkDao;
import com.bjpowernode.crm.workbench.domain.Activity;
import com.bjpowernode.crm.workbench.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
	
	private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
	private ActivityRemarkDao activityRemarkDao = SqlSessionUtil.getSqlSession().getMapper(ActivityRemarkDao.class);
	@Override
	public boolean save(Activity a) {
		
		int count = activityDao.save(a);
		
		boolean flag = true;
		
		if(count!=1){
			
			flag = false;
			
		}
		
		return flag;
	}
	
}
