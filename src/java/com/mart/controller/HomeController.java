package com.mart.controller;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mart.model.Merchant;
import com.mart.service.UserService;
import com.mart.utilities.SessionManager;

@Controller
public class HomeController {
	private static final Logger log = Logger.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "index")
	public String login(@ModelAttribute("command") Merchant merchant,
			BindingResult errors,HttpServletRequest req) {
		Merchant m=null;
		try {
			if ((m = userService.isValidUser(merchant, "MERCHANT"))!=null){
				SessionManager.dataMap.put(req.getSession(), merchant.getMerchantId());
				SessionManager.userRoles.put(req.getSession(), "MERCHANT");
				req.getSession().setAttribute("LoggedInUser", m);
				return "redirect:/merchant/home.htm";
			}
			else if ((m = userService.isValidUser(merchant, "ADMIN"))!=null){
				SessionManager.dataMap.put(req.getSession(), merchant.getMerchantId());
				SessionManager.userRoles.put(req.getSession(), "ADMIN");
				return "redirect:/admin/home.htm";
			}
			else {
				errors.reject("invalid.credientials");
				return "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			errors.reject("InternalServerError");
			return "index";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/index.htm")
	public ModelAndView index() {
		Merchant m = new Merchant();
		return new ModelAndView("index", "command", m);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "admin")
	public ModelAndView admin() {
		return new ModelAndView("merchant/home");
	}
	
	@RequestMapping(method = RequestMethod.GET,value="logout")
	public ModelAndView logout(HttpServletRequest req){
		log.info("in logout");
		req.getSession().invalidate();
		Merchant m = new Merchant();
		return new ModelAndView("index", "command", m);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="bkp")
	public ModelAndView bkp(){
		log.info("in bkp");
		return new ModelAndView("home_backup");
	}
}
