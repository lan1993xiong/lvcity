package com.gpnu.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gpnu.entity.Message;
import com.gpnu.manger.CommonManger;
import com.gpnu.table.Article;
import com.gpnu.table.Foodtype;

@Controller
@RequestMapping("/foodTypeController")
public class FoodTypeController {
	
	@Autowired
	private CommonManger commonManger;
   
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Foodtype foodtype){
		
		commonManger.delete(foodtype);
		
		Message message = new Message();
		message.setMsg("ɾ���ɹ�");
		message.setSuccess(true);
		
		return message;
	}
	
	@RequestMapping("/addFoodType")
	@ResponseBody
	public Object addFoodType(Foodtype foodtype){
	

		commonManger.save(foodtype);
       
		Message message = new Message();
		message.setMsg("��ӳɹ�");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/findAllFoodType")
	@ResponseBody
    public Object findAllFoodType(){
    	
		return commonManger.findAll("Foodtype");
    }
	
	
}
