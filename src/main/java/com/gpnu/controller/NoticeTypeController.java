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
import com.gpnu.table.Noticetype;

@RequestMapping("noticeTypeController")
@Controller
public class NoticeTypeController {
	@Autowired
	private CommonManger commonManger;
   
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Noticetype noticetype){
		
		commonManger.delete( noticetype);
		
		Message message = new Message();
		message.setMsg("删除成功");
		message.setSuccess(true);
		
		return message;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object addFoodType(Noticetype noticetype){
	

		commonManger.save(noticetype);
       
		Message message = new Message();
		message.setMsg("添加成功");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Object findAllFoodType(){
    	
		return commonManger.findAll("Noticetype");
    }
	
	@RequestMapping("noticeType")
	public ModelAndView noticeType(){
		ModelAndView modelAndView = new ModelAndView();
		List<Contact> listContact = commonManger.findAll("Contact");
		List<Noticetype> listNoticetypes = commonManger.findAll("Noticetype");
		modelAndView.addObject("noticetype",listNoticetypes);
		modelAndView.addObject("contact",listContact.get(0));
		modelAndView.setViewName("user/notice/noticetype");
		return modelAndView;
	}

}
