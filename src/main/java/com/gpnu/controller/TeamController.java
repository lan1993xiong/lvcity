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
import com.gpnu.table.Noticetype;
import com.gpnu.table.Team;

@Controller
@RequestMapping("teamController")
public class TeamController {
     
	@Autowired
	private CommonManger commonManger;
   
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Team team){
		
		commonManger.delete(team);
		
		Message message = new Message();
		message.setMsg("删除成功");
		message.setSuccess(true);
		
		return message;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object addFoodType(Team team){
	

		commonManger.save(team);
       
		Message message = new Message();
		message.setMsg("添加成功");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Object findAllFoodType(){
    	
		return commonManger.findAll("Team");
    }
	
	@RequestMapping("teamView")
	public ModelAndView team(){
		ModelAndView modelAndView = new ModelAndView();
		List<Contact> listContact = commonManger.findAll("Contact");
		List<Team> teams = commonManger.findAll("Team");
		modelAndView.addObject("contact",listContact.get(0));
		modelAndView.addObject("team",teams.get(0));
		modelAndView.setViewName("user/team/team");
		return modelAndView;
	}

}
