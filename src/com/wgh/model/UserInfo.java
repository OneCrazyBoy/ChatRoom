package com.wgh.model;

import java.util.Vector;

public class UserInfo {
	private static UserInfo user = new UserInfo(); // 利用private调用构造函数，防止被外界产生新的instance对象，为什么呢？
	private Vector vector = null;
	/*
   Vector其实也是一个类集，Vector类可以实现可增长的对象数组。与数组一样，它包含可以使用整数索引进行访问的组件。
	但是，Vector 的大小可以根据需要增大或缩小，以适应创建 Vector 后进行添加或移除项的操作。 
    */

	private UserInfo()
	{
		this.vector = new Vector();//?????????
	}
	
	// 外界使用的instance对象
	public static UserInfo getInstance() {
		return user;
	}

	// 增加用户
	public boolean addUser(String user) {
		if (user != null) {
			this.vector.add(user);//往vector里增加一个用户
			return true;
		} else {
			return false;
		}
	}

	// 获取用户列表
	public Vector getList()
	{
		return vector;
	}

	// 移除用户
	public void removeUser(String user)
	{
		if (user != null) {
			vector.removeElement(user);
		}
	}
}

