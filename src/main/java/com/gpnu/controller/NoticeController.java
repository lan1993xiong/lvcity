package com.gpnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpnu.entity.Message;
import com.gpnu.manger.CommonManger;
import com.gpnu.table.Article;
import com.gpnu.table.Contact;
import com.gpnu.table.Foodtype;
import com.gpnu.table.Notice;
import com.gpnu.table.Noticetype;

@Controller
@RequestMapping("/noticeController")
public class NoticeController {
	@Autowired
	private CommonManger commonManger;
   
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Notice notice){
		
		commonManger.delete( notice);
		
		Message message = new Message();
		message.setMsg("ɾ���ɹ�");
		message.setSuccess(true);
		
		return message;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object addFoodType(Notice notice){
	

		commonManger.save(notice);
       
		Message message = new Message();
		message.setMsg("���ӳɹ�");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Object findAllFoodType(){
    	
		return commonManger.findAll("Notice");
    }
	
	@RequestMapping("/noticeView")
	public ModelAndView NoticeView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/notice/noticelist");
		List<Contact> listContact = commonManger.findAll("Contact");
		List<Notice> noticelist = commonManger.findAll("Notice");
		List<Article> articlelist = commonManger.findAll("Article");
		modelAndView.addObject("contact",listContact.get(0));
		modelAndView.addObject("noticelist",noticelist);
		modelAndView.addObject("articlelist",articlelist);
		return modelAndView;
	}
	
	@RequestMapping("/noticeArtice")
	public ModelAndView NoticeArticle( Integer ntid,Integer aid){
		
		ModelAndView modelAndView = new ModelAndView();
		
	   // Article article =	commonManger.get(Article.class, aid);
	   // System.out.print(article.getContent());
		Article article = commonManger.findClassByIdAndTableName("Article", "aid",aid);
		modelAndView.addObject("article",article);
		modelAndView.setViewName("user/notice/noticetext");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/findContent")
	@ResponseBody
	public Object findContent(Integer ntid){
		Noticetype noticetype = commonManger.findClassByIdAndTableName("Noticetype", "ntid",ntid);
		return noticetype;
	}
	

}