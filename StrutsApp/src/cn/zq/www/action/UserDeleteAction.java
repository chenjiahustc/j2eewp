package cn.zq.www.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.zq.www.dao.UserDAO;
import cn.zq.www.dao.impl.UserDAOImpl;
import cn.zq.www.entity.User;
import cn.zq.www.service.UserService;

public class UserDeleteAction extends ActionSupport {
	private User user;
	private String message;
	private UserService service;

	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	@Override
	public String execute() throws Exception{;
		service.delete(user);
		
		return SUCCESS;
	}
}
