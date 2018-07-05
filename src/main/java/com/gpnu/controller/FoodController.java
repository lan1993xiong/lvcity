package com.gpnu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gpnu.dao.CommonDao;
import com.gpnu.entity.Message;
import com.gpnu.entity.Page;
import com.gpnu.manger.CommonManger;
import com.gpnu.table.Article;
import com.gpnu.table.Contact;
import com.gpnu.table.Food;
import com.gpnu.table.Foodtype;
import com.gpnu.table.Scenic;
import com.gpnu.table.Scenictype;

@Controller
@RequestMapping("foodController")
public class FoodController {
     
	@Autowired
	private CommonManger commonManger;
	
	@RequestMapping("/findAllFood")
	@ResponseBody
	public Object findAllFood(){
		
		return commonManger.findAll("Food");
		
	}
	
	@RequestMapping("/addFood")
	@ResponseBody
	public Object addFood(Food food,HttpServletRequest request,@RequestParam(value="file",required=false)MultipartFile myFile) throws IllegalStateException, IOException{
		
		String filename = myFile.getOriginalFilename();
		ServletContext sc = request.getSession().getServletContext();
	    String path = sc.getRealPath("\\images") + "\\"; 
	    myFile.transferTo(new File(path + filename));
	    String realpath = "images/" + filename;
		
	    food.setImage(realpath);
	    
		commonManger.save(food);
		
		
		Message message = new Message();
		message.setMsg("添加成功");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/deleteFood")
	@ResponseBody
	public Object deleteFood(Food food){
		System.out.println(food.getFname()+"==================================");
		commonManger.delete(food);
		Message message = new Message();
		message.setMsg("删除成功");
		message.setSuccess(true);
		return message;
	}
	
	@RequestMapping("/foodView")
	public ModelAndView foodView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/food/foodIndex");
		List<Foodtype> foodtypelist = commonManger.findAll("Foodtype");
		List<Contact> contactList  = commonManger.findAll("Contact");
		modelAndView.addObject("pageNow", 1);
		modelAndView.addObject("foodtypelist",foodtypelist);
		modelAndView.addObject("contact", contactList.get(0));
		
		return modelAndView;
	}
	
	@RequestMapping("showList")
	public ModelAndView showList(String pageNow){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/food/foodList");
		List<Foodtype> foodtypelist = commonManger.findAll("Foodtype");
		List<Food> foodlist = commonManger.findAll("Food");
		int pageCount = foodlist.size() / 18;
		if(foodlist.size() % 18 > 0){
			pageCount += 1;
		}
		modelAndView.addObject("pageNow",pageNow);
		modelAndView.addObject("rowCount",foodlist.size());
		modelAndView.addObject("pageCount",pageCount);
		modelAndView.addObject("foodtypelist",foodtypelist);
		modelAndView.addObject("foodlist",foodlist);
		return modelAndView;
	}
	
	@RequestMapping("detailFood")
	public ModelAndView detailFood(Integer ftid,Integer aid){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/food/foodDetail");
		Article  article = commonManger.findClassByIdAndTableName("Article","aid", aid);
		modelAndView.addObject(article);
		return modelAndView;
	}
	
	@RequestMapping("/ByPage")
	public ModelAndView findClasByPage(Page page){
		System.out.println(page.toString());
		ModelAndView andView = new ModelAndView();
		List<Food> foodlist = commonManger.findListClassByPaging("Food", page);
		int pageCount = foodlist.size() / 18;
		if(foodlist.size() % 18 > 0){
			pageCount += 1;
		}
		
		System.out.println(foodlist.size());
		andView.addObject("pageNow",page.getPageNow());
		andView.addObject("rowCount",foodlist.size());
		andView.addObject("pageCount",page.getPageCount());
		andView.addObject("foodlist",foodlist);
		andView.setViewName("user/food/foodList");
		return andView;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(Integer ftid){
		ModelAndView modelAndView = new ModelAndView();
		Foodtype foodtype = commonManger.findClassByIdAndTableName("Foodtype", "ftid", ftid);
		modelAndView.setViewName("user/food/foodList");
		modelAndView.addObject("foodlist",foodtype.getFoods());
		return modelAndView;
	}
	
}
