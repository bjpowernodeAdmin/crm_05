package com.bjpowernode.crm.settings.domain;

public class User {
	
	/*
	 * 
	 * 对于时间，我们以字符串的形式展现时间，通常有两种方式
	 * 年月日：yyyy-MM-dd 10位
	 * 年月日时分秒：yyyy-MM-dd HH:mm:ss 19位
	 * 
	 * 
	 * 对于登录：
	 * 	  我们的验证方式如下所述：
	 * 	  以前我们只验证账号和密码
	 *   现在我们不仅仅只是验证账号密码
	 *   我们还需要验证：
	 *   	失效时间
	 *      锁定状态
	 *      允许访问的ip地址 "192.168.1.1,192.168.1.2,192.168.1.3"
	 *   
	 * 
	 * 
	 */
	
	private String id;	//主键
	private String loginAct;	//登录账号
	private String name;	//用户真实姓名
	private String loginPwd;	//登录密码
	private String email;	//邮箱
	private String expireTime;	//账号失效时间
	private String lockState;	//锁定状态    0：锁定     1：启用
	private String deptno;	//部门编号
	private String allowIps;	//允许访问的ip地址
	private String createTime;	//创建时间 当前系统时间
	private String createBy;	//创建人 当前登录用户
	private String editTime;	//修改时间
	private String editBy;	//修改人
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginAct() {
		return loginAct;
	}
	public void setLoginAct(String loginAct) {
		this.loginAct = loginAct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
	public String getLockState() {
		return lockState;
	}
	public void setLockState(String lockState) {
		this.lockState = lockState;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getAllowIps() {
		return allowIps;
	}
	public void setAllowIps(String allowIps) {
		this.allowIps = allowIps;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getEditTime() {
		return editTime;
	}
	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}
	public String getEditBy() {
		return editBy;
	}
	public void setEditBy(String editBy) {
		this.editBy = editBy;
	}
	
	

}
