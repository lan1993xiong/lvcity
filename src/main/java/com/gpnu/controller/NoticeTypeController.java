package com.gpnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpnu.entity.Message;
import com.gpnu.entity.Page;
import com.gpnu.manger.CommonManger;
import com.gpnu.table.Article;
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
		List<Noticetype> noticetypelist = commonManger.findAll("Noticetype");
		modelAndView.addObject("noticetypelist",noticetypelist);
		modelAndView.addObject("contact",listContact.get(0));
		modelAndView.setViewName("user/notice/noticetype");
		return modelAndView;
	}
	

	@RequestMapping("/noticelist")
	public ModelAndView noticeList(Page page){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/notice/noticelist");
		List<Contact> listContact = commonManger.findAll("Contact");
		List<Notice> noticelist = commonManger.findAll("Notice");
		List<Article> articlelist = commonManger.findAll("Article");
		int pageCount = noticelist.size() / 18;

		if((noticelist.size() % 18 )  > 0){
			pageCount += 1;
		}
	
		modelAndView.addObject("pageNow",1);
		modelAndView.addObject("rowCount",noticelist.size());
		modelAndView.addObject("pageCount",pageCount);
		modelAndView.addObject("contact",listContact.get(0));
		modelAndView.addObject("noticelist",noticelist);
		modelAndView.addObject("articlelist",articlelist);
		return modelAndView;
	}
	
	
	@RequestMapping("/ByPage")
	public ModelAndView findClasByPage(Page page){
		System.out.println(page.toString());
		ModelAndView andView = new ModelAndView();
		List<Notice> noticelist = commonManger.findListClassByPaging("Notice", page);
		List<Article> articlelist = commonManger.findAll("Article");
		int pageCount = noticelist.size() / 18;
		if(noticelist.size() % 18 > 0){
			pageCount += 1;
		}
		
		System.out.println(noticelist.size());
		andView.addObject("pageNow",page.getPageNow());
		andView.addObject("rowCount",noticelist.size());
		andView.addObject("pageCount",page.getPageCount());
		andView.addObject("noticelist",noticelist);
		andView.addObject("articlelist",articlelist);
		andView.setViewName("user/notice/noticelist");
		return andView;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(Integer ntid,Integer pageNow){
		ModelAndView modelAndView = new ModelAndView();
		Noticetype noticetype = commonManger.findClassByIdAndTableName("Noticetype", "ntid", ntid);
		List<Article> articlelist = commonManger.findAll("Article");
		int pageCount = noticetype.getNotices().size() / 18;
		if(noticetype.getNotices().size() % 18 > 0){
			pageCount += 1;
		}
		modelAndView.addObject("pageNow",pageNow);
		modelAndView.addObject("rowCount",noticetype.getNotices().size());
		modelAndView.addObject("pageCount",pageCount);
		modelAndView.setViewName("user/notice/noticelist");
		modelAndView.addObject("articlelist",articlelist);
		modelAndView.addObject("noticelist",noticetype.getNotices());
		return modelAndView;
	}
	

}
