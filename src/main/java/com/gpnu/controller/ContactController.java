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
import com.gpnu.table.Notice;

@RequestMapping("/contactController")
@Controller
public class ContactController {
	@Autowired
	private CommonManger commonManger;
   
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Contact contact){
		
		commonManger.delete( contact);
		
		Message message = new Message();
		message.setMsg("删除成功");
		message.setSuccess(true);
		
		return message;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object addFoodType(Contact contact){
	

		commonManger.save(contact);
       
		Message message = new Message();
		message.setMsg("添加成功");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Object findAll(){
    	
		return commonManger.findAll("Contact");
    }
    
	@RequestMapping("contactView")
	public ModelAndView contactView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/contact/connection");
		List<Contact> listContact = commonManger.findAll("Contact");
		modelAndView.addObject("contact",listContact.get(0));
		return modelAndView;
	}
    @RequestMapping("map")
    public ModelAndView map(){
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/contact/map");
		return modelAndView;
    }

}
