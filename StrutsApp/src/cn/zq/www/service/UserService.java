package cn.zq.www.service;

import java.util.List;

import cn.zq.www.entity.User;

public interface UserService {
	public void save(User user);
	public List<User> findAll();
	public void delete(User user);
	public void update(User user);
	public User findById(int id);
	public User loginUser(User user);
}
