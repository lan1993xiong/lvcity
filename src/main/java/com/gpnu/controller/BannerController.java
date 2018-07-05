package com.gpnu.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.gpnu.entity.Message;
import com.gpnu.manger.CommonManger;
import com.gpnu.table.Banar;
import com.gpnu.table.Notice;

@Controller
@RequestMapping("/bannerController")
public class BannerController {
	@Autowired
	private CommonManger commonManger;
   
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Banar banar){
		
		commonManger.delete( banar);
		
		Message message = new Message();
		message.setMsg("删除成功");
		message.setSuccess(true);
		
		return message;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object add(Banar banar,HttpServletRequest request,@RequestParam(value="file",required=false)MultipartFile myFile) throws IllegalStateException, IOException{
	    
		String filename = myFile.getOriginalFilename();
		ServletContext sc = request.getSession().getServletContext();
	    String path = sc.getRealPath("\\images") + "\\"; 
	    myFile.transferTo(new File(path + filename));
	    String realpath = "images/" + filename;
		
	    banar.setImage(realpath);
		
		
		commonManger.save(banar);
       
		Message message = new Message();
		message.setMsg("添加成功");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Object findAll(){
    	
		return commonManger.findAll("Banar");
    }

	
}
