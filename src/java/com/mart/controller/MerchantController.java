package com.mart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mart.model.Comment;
import com.mart.model.Customer;
import com.mart.model.Merchant;
import com.mart.model.Order;
import com.mart.service.ItemService;
import com.mart.service.OrderService;
import com.mart.service.UserService;

@Controller
@RequestMapping("merchant")
public class MerchantController {

	private Logger log = Logger.getLogger(MerchantController.class);
	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.GET, value = "home")
	public ModelAndView home(HttpSession session) {
		log.info("home");
		Merchant user = (Merchant) session.getAttribute("LoggedInUser");
		return new ModelAndView("home", "command", user);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "orderHistory")
	public ModelAndView orderHistory(HttpSession session) {
		log.info("order history ");
		List<Order> orders = orderService.getAllOrdersByShopId(((Merchant) session.getAttribute("LoggedInUser")).getShopId());
		return new ModelAndView("orderHistory", "command", orders);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "cancelOrders")
	public ModelAndView cancelOrdersList(HttpSession session) {
		log.info("Cancel Orders List ");
		List<Order> orders = orderService.getCancelOrdersByShopId(((Merchant) session.getAttribute("LoggedInUser")).getShopId());
		return new ModelAndView("cancelOrders", "command", orders);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "dispatchedOrders")
	public ModelAndView dispatchedOrdersList(HttpSession session) {
		log.info("rejected Orders List ");
		List<Order> orders = orderService.getDispatchedOrdersList(((Merchant) session.getAttribute("LoggedInUser")).getShopId());
		return new ModelAndView("rejectedOrders", "command", orders);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "newOrders")
	public ModelAndView pendingOrdersList(HttpSession session) {
		log.info("Cancel Orders List ");
		List<Order> orders = orderService.getPendingOrdersByShopId(((Merchant) session.getAttribute("LoggedInUser")).getShopId());
		return new ModelAndView("pendingOrders", "command", orders);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rejectedOrders")
	public ModelAndView rejectedOrdersList(HttpSession session) {
		log.info("rejected Orders List ");
		List<Order> orders = orderService.getRejectedOrdersByShopId(((Merchant) session.getAttribute("LoggedInUser")).getShopId());
		return new ModelAndView("rejectedOrders", "command", orders);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "dispatch")
	public String dispatchOrder(HttpServletRequest req) {
		log.info("dispatch order ");
		orderService.dispatchOrder(req.getParameter("id"));
		return "redirect:newOrders.htm";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rejectOrder")
	public String rejectOrder(HttpServletRequest req) {
		log.info("reject orders ");
		orderService.rejectchOrder(req.getParameter("id"));
		return "redirect:newOrders.htm"; 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "reviews")
	public ModelAndView reivews(HttpSession session) {
		log.info("ratings & reviews");
		List<Comment> comments = userService.getReviewsAndRatingsById(((Merchant) session.getAttribute("LoggedInUser")).getShopId());
		double avgRating = 0;
		for(Comment c:comments)avgRating+=c.getRating();
		if(comments.size()!=0)avgRating=avgRating/comments.size();
		ModelAndView mav = new ModelAndView("reviews","command",comments);
		mav.addObject("avgRating", avgRating);
		return mav; 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "viewCustomers")
	public ModelAndView viewCustomers(HttpSession session) {
		log.info("viewCustomers () ");
		List<Customer> comments = userService.getCustomersByShopId(((Merchant) session.getAttribute("LoggedInUser")).getShopId());
		return new ModelAndView("viewCustomers","command",comments); 
	}
}
