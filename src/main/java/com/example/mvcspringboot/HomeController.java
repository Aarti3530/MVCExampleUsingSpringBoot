package com.example.mvcspringboot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	
	//using HttpServletRequest
	@RequestMapping("add")
	public String add(HttpServletRequest req) {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		int res = num1 + num2;
	    
		HttpSession session = req.getSession();
		session.setAttribute("res", res);
		
		return "result";
	}
	
	//using HttpSession and @RequestParam
	@RequestMapping("sub")
	public String sub(@RequestParam("num1") int num1,@RequestParam("num2") int num2,HttpSession session) {
		int res = num1 - num2;
		session.setAttribute("res", res);
		return "result";
	}
	
	//using model and view
	@RequestMapping("mul")
	public ModelAndView mul(@RequestParam("num1") int num1,@RequestParam("num2") int num2) {
		ModelAndView mv = new ModelAndView();
		int res = num1 * num2;
		mv.setViewName("result");
		mv.addObject("res",res);
		return mv;
	}
	
	//using ModelMap
	@RequestMapping("div")
	public String div(@RequestParam("num1") int num1,@RequestParam("num2") int num2,Model m) {
		int res = num1/num2;
		m.addAttribute("res",res);
		return "result";
	}
	
}
