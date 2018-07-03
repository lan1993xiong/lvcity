package com.gpnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpnu.entity.Message;
import com.gpnu.manger.CommonManger;
import com.gpnu.table.Contact;
import com.gpnu.table.Foodtype;

@Controller
@RequestMapping("/messageController")
public class MessageController {
	
	@Autowired
	private CommonManger commonManger;
   
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(com.gpnu.table.Message me){
		
		commonManger.delete(me);
		
	    Message message = new Message();
		message.setMsg("删除成功");
		message.setSuccess(true);
		
		return message;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object add(com.gpnu.table.Message me){
	

		commonManger.save(me);
       
		Message message = new Message();
		message.setMsg("添加成功");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Object findAll(){
    	
		return commonManger.findAll("Message");
    }
    
	@RequestMapping("/messageView")
	public ModelAndView messageView(){
		ModelAndView modelAndView = new ModelAndView();
		List<Contact> listContact = commonManger.findAll("Contact");
		modelAndView.setViewName("user/leave/leave");
		modelAndView.addObject("contact",listContact.get(0));
		return modelAndView;
	}
}
