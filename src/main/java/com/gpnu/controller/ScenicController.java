package com.gpnu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.gpnu.entity.Message;
import com.gpnu.entity.Page;
import com.gpnu.manger.CommonManger;
import com.gpnu.table.Article;
import com.gpnu.table.Contact;
import com.gpnu.table.Foodtype;
import com.gpnu.table.Scenic;
import com.gpnu.table.Scenictype;


@Controller
@RequestMapping("scenicController")
public class ScenicController {
	
    @Autowired
	private CommonManger commonManger;
    
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Scenic scenic){
		
		commonManger.delete(scenic);
		
		Message message = new Message();
		message.setMsg("删除成功");
		message.setSuccess(true);
		
		return message;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object addFood(Scenic scenic,HttpServletRequest request,@RequestParam(value="file",required=false)MultipartFile myFile) throws IllegalStateException, IOException{
	
		String filename = myFile.getOriginalFilename();
		ServletContext sc = request.getSession().getServletContext();
	    String path = sc.getRealPath("\\images") + "\\"; 
	    myFile.transferTo(new File(path + filename));
	    String realpath = "images/" + filename;
	    scenic.setImage(realpath);
		commonManger.save(scenic);
       
		Message message = new Message();
		message.setMsg("添加成功");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
    public Object findAll(){
    	
		return commonManger.findAll("Scenic");
    }
	
	@RequestMapping("/scenicView")
	public ModelAndView scenicView(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/tour/tourism");
		List<Contact> listContact = commonManger.findAll("Contact");
		List<Scenictype> scenictype = commonManger.findAll("Scenictype");
		modelAndView.addObject("contact",listContact.get(0));
		modelAndView.addObject("scenictype",scenictype);
		return modelAndView;
	}
    
	@RequestMapping("/showList")
	public ModelAndView showList(Integer stid,Integer aid,Integer pageNow){
		
		ModelAndView andView = new ModelAndView();
		List<Scenic> sceniclist = commonManger.findAll("Scenic");
		int pageCount = sceniclist.size() / 18;
		if(sceniclist.size() % 18 > 0){
			pageCount += 1;
		}
		
		andView.addObject("pageNow",pageNow);
		andView.addObject("rowCount",sceniclist.size());
		andView.addObject("pageCount",pageCount);
		andView.addObject("sceniclist",sceniclist);
		andView.setViewName("user/tour/tourismlist");
		return andView;
		
		
	}
	@RequestMapping("/detail")
	public ModelAndView detail(Integer stid,Integer aid){
		ModelAndView andView = new ModelAndView();
		Article article =  commonManger.findClassByIdAndTableName("Article","aid", aid);
		andView.addObject(article);
		andView.setViewName("user/tour/tourismtext");
		return andView;
		
		
	}
	
	@RequestMapping("/search2")
	public ModelAndView findClasByPage(Page page){
		System.out.println(page.toString());
		ModelAndView andView = new ModelAndView();
		List<Scenic> sceniclist = commonManger.findListClassByPaging("Scenic", page);
		int pageCount = sceniclist.size() / 18;
		if(sceniclist.size() % 18 > 0){
			pageCount += 1;
		}
		
		System.out.println(sceniclist.size());
		andView.addObject("pageNow",page.getPageNow());
		andView.addObject("rowCount",sceniclist.size());
		andView.addObject("pageCount",page.getPageCount());
		andView.addObject("sceniclist",sceniclist);
		andView.setViewName("user/tour/tourismlist");
		return andView;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(Integer stid){
		ModelAndView modelAndView = new ModelAndView();
		Scenictype scenictype = commonManger.findClassByIdAndTableName("Scenictype", "stid", stid);
		modelAndView.setViewName("user/tour/tourismlist");
		modelAndView.addObject("sceniclist",scenictype.getScenics());
		return modelAndView;
	}
}
