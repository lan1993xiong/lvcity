package com.gpnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpnu.entity.Message;
import com.gpnu.manger.AdminManger;
import com.gpnu.table.Admin;

@Controller
@RequestMapping("/loginController")
public class LoginController {
    
	@Autowired
	private AdminManger adminManger;
   
	
	@RequestMapping("/isUser")
	@ResponseBody
    public Object isUser(Admin admin){
		boolean flag =  adminManger.findUserByAdmin(admin);
		Message message = new Message();
		if(flag){
		    message.setMsg("µÇÂ¼³É¹¦");
		    message.setSuccess(true);
		    return message;
		}
		
		message.setMsg("µÇÂ¼Ê§°Ü");
		message.setSuccess(false);
		return message;
	
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("Admin/index");
	}
	

	
}
