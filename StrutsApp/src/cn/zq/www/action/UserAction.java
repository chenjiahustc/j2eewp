package cn.zq.www.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.zq.www.dao.UserDAO;
import cn.zq.www.dao.impl.UserDAOImpl;
import cn.zq.www.entity.User;
import cn.zq.www.service.UserService;

public class UserAction extends ActionSupport {
	private User user;
	private String message;
	private UserService service;

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
	
	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public String login(){
		User userLogin = service.loginUser(user);
		if (userLogin != null){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", userLogin);
			
			return SUCCESS;
		}
		
		return INPUT;
	}
	
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return INPUT;		
	}
	
	public String register(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		service.save(user);
		session.setAttribute("user", this.user);
		
		return SUCCESS;
	}

}
