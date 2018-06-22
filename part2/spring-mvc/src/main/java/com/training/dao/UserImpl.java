package com.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.bean.User;

@Repository
@Transactional
public class UserImpl implements UserDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User login(User user) {
		User userobj = em.find(User.class, user.getUsername());
		return userobj;
	}

}
