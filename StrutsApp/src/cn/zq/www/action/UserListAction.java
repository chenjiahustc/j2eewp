package cn.zq.www.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.zq.www.entity.User;
import cn.zq.www.service.UserService;

@SuppressWarnings("serial")
public class UserListAction extends ActionSupport{
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
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public String listUser(){
		Map request = (Map) ActionContext.getContext().get("request");
		List<User> userList = service.findAll();
		request.put("list", userList);
		
		return "listSuc";
	}

}
