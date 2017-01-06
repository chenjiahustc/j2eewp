package cn.zq.www.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.zq.www.dao.UserDAO;
import cn.zq.www.entity.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{

	@Override
	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		String hql = "from User as user";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public void removeUser(User user) {
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		User user = (User)this.getHibernateTemplate().get(User.class, id);
		
		return user;
	}

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		User loginUser = null;
		String hql = "from User as user where user.username='" + user.getUsername() + "' and user.password='" + user.getPassword() +"'" ;
		@SuppressWarnings("unchecked")
		List<User> users = this.getHibernateTemplate().find(hql);
		
		if (users.size() > 0)
			loginUser = users.get(0);
		
		return loginUser;
	}

}
