package com.bjpowernode.crm.settings.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.utils.DateTimeUtil;
import com.bjpowernode.crm.utils.SqlSessionUtil;

public class UserServiceImpl implements UserService {

	private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

	public User login(String loginAct, String loginPwd, String ip) throws LoginException {
		
		/*
		 * 
		 * 登录验证流程
		 * 
		 *  User user = 验证账号密码;
		 * 	select * from tbl_user where loginAct=#{loginAct} and loginPwd=#{loginPwd}
		 * 
		 *  如果user对象为null，说明没查询到，为控制器抛出 自定义异常，异常信息为 ：账号密码错误
		 *  
		 *  如果user对象不为null，说明账号密码正确
		 *  从user对象中取得以下验证项
		 *  
		 *  expireTime 如果失效时间没有大于当前系统时间  为控制器抛出 自定义异常，异常信息为 ：账号已失效
		 *  lockState 如果锁定状态为0，表示账号已经被锁定  为控制器抛出 自定义异常，异常信息为 ：账号已锁定
		 *  allowIps 如果参数ip没有包含在允许访问的ip中 表示该ip地址无效 为控制器抛出 自定义异常，异常信息为 ：ip地址受限
		 *  
		 *  如果以上验证都成功，为控制器返回user对象，表示登录成功
		 *  
		 * 
		 * 
		 */
		
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("loginAct",loginAct);
		paramMap.put("loginPwd",loginPwd);
		
		//验证账号密码
		User user = userDao.login(paramMap);
		
		
		//如果user对象为null，说明没查询到，为控制器抛出 自定义异常，异常信息为 ：账号密码错误
		if(user==null){
			
			throw new LoginException("账号密码错误");
			
		}
		
		
		//如果user对象不为null，说明账号密码正确
		//从user中取得expireTime，验证expireTime
		String expireTime = user.getExpireTime();
		String currentTime = DateTimeUtil.getSysTime();
		//如果失效时间没有大于当前系统时间  为控制器抛出 自定义异常，异常信息为 ：账号已失效
		if(expireTime.compareTo(currentTime)<0){
			
			throw new LoginException("账号已失效");
			
		}
		
		//从user中取得lockState，验证lockState
		String lockState = user.getLockState();
		//如果锁定状态为0，表示账号已经被锁定  为控制器抛出 自定义异常，异常信息为 ：账号已锁定
		if("0".equals(lockState)){
			
			throw new LoginException("账号已锁定");
			
		}
		
		//从user中取得allowIps，验证ip地址是否存在在allowIps当中
		String allowIps = user.getAllowIps();
		//如果参数ip没有包含在允许访问的ip中 表示该ip地址无效 为控制器抛出 自定义异常，异常信息为 ：ip地址受限
		if(!allowIps.contains(ip)){
			
			throw new LoginException("ip地址受限");
			
		}
		
		
		return user;
	}

	@Override
	public List<User> getUserList() {
		
		List<User> uList = userDao.getUserList();
		
		return uList;
	}
	
}



















































