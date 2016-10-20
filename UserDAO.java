package com.niit.collabration2.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collabration2.model.User;
@Repository
public interface UserDAO {

	public boolean save(User user);

	public boolean update(User user);

	public boolean delete(User user);

	public User get(String id);

	public List<User> list();
}
