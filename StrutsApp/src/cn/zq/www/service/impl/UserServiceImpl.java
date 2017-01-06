package cn.zq.www.service.impl;

import java.util.List;
import cn.zq.www.dao.UserDAO;
import cn.zq.www.entity.User;
import cn.zq.www.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		this.userDao.saveUser(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userDao.findAllUsers();
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		this.userDao.removeUser(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		this.userDao.updateUser(user);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return this.userDao.findUserById(id);
	}

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.loginUser(user);
	}
}
