package com.gpnu.controller;

import java.io.File;
import java.io.IOException;

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
import com.gpnu.table.Scenic;
import com.gpnu.table.Scenictype;

@RequestMapping("scenictypeController")
@Controller
public class ScenictypeController {
     
	 @Autowired
		private CommonManger commonManger;
	    
		
		@RequestMapping("/delete")
		@ResponseBody
		public Object delete(Scenictype scenictype){
			
			commonManger.delete(scenictype);
			
			Message message = new Message();
			message.setMsg("删除成功");
			message.setSuccess(true);
			
			return message;
		}
		
		@RequestMapping("/add")
		@ResponseBody
		public Object add(Scenictype scenictype){
			 
			commonManger.save(scenictype);
			Message message = new Message();
			message.setMsg("添加成功");
			message.setSuccess(true);
			return message;
		}
		
		@RequestMapping("/findAll")
		@ResponseBody
	    public Object findAll(){
	    	
			return commonManger.findAll("Scenictype");
	    }
	
}
