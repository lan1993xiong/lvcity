package com.gpnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpnu.entity.Message;
import com.gpnu.manger.AdminManger;
import com.gpnu.manger.CommonManger;
import com.gpnu.table.Admin;
import com.gpnu.table.Article;

@Controller
@RequestMapping("/adminController")
public class AdminController {
	
	@Autowired
	private AdminManger adminManger;
   
	
	@RequestMapping("/isUser")
	@ResponseBody
	public Message isUser(Admin admin){
		boolean flag =  adminManger.findUserByAdmin(admin);
		Message message = new Message();
		if(flag){
			 message = new Message();
			message.setMsg("登录成功");
			message.setSuccess(true);
			
		}
		message = new Message();
		message.setMsg("登录成功");
		message.setSuccess(true);
		
		return message;
	}
}
