package com.training.dao;

import com.training.bean.User;

public interface UserDAO {
	
	public int save(User user);
	public User login(User loginUser);

}
