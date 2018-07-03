package com.gpnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpnu.entity.Message;
import com.gpnu.manger.CommonManger;
import com.gpnu.table.Article;
import com.gpnu.table.Articletype;

@Controller
@RequestMapping("/articletypeController")
public class ArticletypeController {
	@Autowired
	private CommonManger commonManger;
   
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Articletype articletype){
		
		commonManger.delete( articletype);
		
		Message message = new Message();
		message.setMsg("ɾ���ɹ�");
		message.setSuccess(true);
		
		return message;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object add(Articletype articletype){

		commonManger.save(articletype);
		Message message = new Message();
		message.setMsg("��ӳɹ�");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Object findAll(){
    	
		return commonManger.findAll("Articletype");
    }
}
