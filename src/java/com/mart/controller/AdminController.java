package com.mart.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mart.model.Item;
import com.mart.model.ItemCategory;
import com.mart.model.Merchant;
import com.mart.model.Order;
import com.mart.service.ItemService;
import com.mart.service.MerchantService;
import com.mart.service.OrderService;
import com.mart.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {
	private static final Logger log = Logger.getLogger(AdminController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.GET,value="home")
	public ModelAndView home(){
		log.info("in home");
		return new ModelAndView("home");
	}
	
	@RequestMapping(method = RequestMethod.GET,value="viewItems")
	public ModelAndView viewItems(){
		log.info("in viewItems");
		List<Item> items=itemService.viewAllItem();
		
		return new ModelAndView("viewItems","command",items);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="addItems")
	public ModelAndView addItems(){
		log.info("in addItems");
		List<ItemCategory> itemCategories = itemService.getItemCategories();
		ModelAndView mav = new ModelAndView("addItems","command",new Item());
		log.info(itemCategories);
		mav.addObject("itemCategories", itemCategories);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET,value="viewShops")
	public ModelAndView viewShops(){
		log.info("in viewShops");
		List<Merchant> shops = userService.getShops();
		return new ModelAndView("viewShops","command",shops);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="addShops")
	public ModelAndView addShops(){
		log.info("in addShops");
		return new ModelAndView("addShops","command",new Merchant());
	}
	@RequestMapping(method = RequestMethod.POST, value = "addItems")
	public ModelAndView addItems(@ModelAttribute("command") Item item,
			BindingResult errors,HttpServletRequest req,@RequestParam("itemImage") CommonsMultipartFile  file) {
		try {
			byte barr[]=file.getBytes(); 
			String dbLoc = "resources/items/"+item.getItemName()+((int)(Math.random()*1000))+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			File f = new File(req.getSession().getServletContext().getRealPath("/")+dbLoc);
			BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(f));  
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();  

			log.info("IN AddItems Mthds"+item);
			log.info("Item Name:::"+item.getItemName());
			log.info("Item Brand:::"+item.getItemBrand());
			log.info("DB file location :  "+dbLoc);
			log.info("Item Image:new file::"+f.getAbsolutePath());
			item.setItemImage(dbLoc);
		    itemService.addItem(item);
				
		        
			return viewItems();
		} catch (Exception e) {
			log.info(e);
			errors.reject("InternalServerError");
			return new ModelAndView("addItems");
		}
	}
	@RequestMapping(method = RequestMethod.POST, value = "addShops")
	public ModelAndView addShops(@ModelAttribute("command") Merchant merchant,
			BindingResult errors,HttpServletRequest req,@RequestParam("merchantImage") CommonsMultipartFile  file,@RequestParam("shopImage") CommonsMultipartFile  shopFile) {
		try {
			byte barr[]=file.getBytes(); 
			String merchantImageDbLoc = "resources/merchants/"+merchant.getMerchantName()+"_"+merchant.getMobile()+"_"+((int)(Math.random()*1000))+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			File f = new File(req.getSession().getServletContext().getRealPath("/")+merchantImageDbLoc);
			BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(f));  
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();

		   log.info("----->"+req.getSession().getServletContext().getRealPath("/")+merchantImageDbLoc);
		        
	        String shopImageDbLoc = "resources/shops/"+merchant.getShopName()+"_"+merchant.getShopId()+"_"+((int)(Math.random()*1000))+shopFile.getOriginalFilename().substring(shopFile.getOriginalFilename().lastIndexOf("."));
			File f2 = new File(req.getSession().getServletContext().getRealPath("/")+shopImageDbLoc);
			barr = shopFile.getBytes();
			bout=new BufferedOutputStream(new FileOutputStream(f2));  
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();
		     
		   log.info("----->"+req.getSession().getServletContext().getRealPath("/")+shopImageDbLoc);
		        
			log.info("IN addShops Mthds");
			log.info("merchant Name:::"+merchant.getMerchantName());
			log.info("merchant password:::"+merchant.getPassword());
			log.info("merchant mailid:::"+merchant.getMailid());
			log.info("merchant mobile:::"+merchant.getMobile());
			log.info("merchant address:::"+merchant.getAddress());
			log.info("merchant shopId:::"+merchant.getShopId());
			log.info("merchant shopName:::"+merchant.getShopName());
			log.info("merchant shopLocation:::"+merchant.getShopLocation());
			log.info("merchant shopAddress:::"+merchant.getShopAddress());
			log.info("merchant shopImage:::"+merchant.getShopImage());
			log.info("merchant deliveryType:::"+merchant.getDeliveryType());
			log.info("merchant openingTime:::"+merchant.getOpeningTime());
			log.info("merchant closingTime:::"+merchant.getClosingTime());
			log.info("merchant shopType:::"+merchant.getShopType());
			log.info("DB file location :  "+merchantImageDbLoc);
			log.info("Item Image:new file::"+f.getAbsolutePath());
			merchant.setMerchantImage(merchantImageDbLoc);
			merchant.setShopImage(shopImageDbLoc);
			merchantService.addShop(merchant);
			return viewShops();
		} catch (Exception e) {
			log.info(e);
			errors.reject("InternalServerError");
			return new ModelAndView("addShops");
		}
	}
	
	@RequestMapping(method = RequestMethod.GET,value="editItem")
	public ModelAndView editItem(HttpServletRequest req){
		log.info("in editItem");
		Item item=itemService.getItemById(req.getParameter("id"));
		return new ModelAndView("editItem","command",item);
	}
	@RequestMapping(method = RequestMethod.GET,value="viewItemCategories")
	public ModelAndView viewItemCategories(){
		log.info("in viewItemCategories");
		List<ItemCategory> itemCategory=itemService.getItemCategories();
		log.info(itemCategory);
		return new ModelAndView("viewItemCategories","command",itemCategory);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="addCategory")
	public ModelAndView addItemCategory(@ModelAttribute("command") ItemCategory category){
		log.info("in addItemCategory"+category);
		itemService.addItemCategory(category);
		return viewItemCategories();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="manageItems")
	public ModelAndView manageItems(HttpServletRequest req){
		log.info("in manageItems"+req.getParameter("shopId"));
		String shopId= req.getParameter("shopId");
		List<Item> items = null;
		if(shopId!=null)
			items = itemService.getListOfItemsInShop(shopId);
		ModelAndView mav = new ModelAndView("manageItems","command",items);
		mav.addObject("shopId", shopId);
		return mav;
	}
	@RequestMapping(method = RequestMethod.GET,value="viewItemsForShops")
	public ModelAndView viewItemsForShops(HttpServletRequest req){
		log.info("in viewItemsForShops"+req.getParameter("shopId"));
		String shopId= req.getParameter("shopId");
		List<Item> items=itemService.viewAllItemExceptShopId(shopId);
		ModelAndView mav = new ModelAndView("viewItemsForShops","command",items);
		mav.addObject("shopId", shopId);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST,value="addItemToShop")
	public ModelAndView addItemToShop(@ModelAttribute Item item,HttpServletRequest req){
		log.info("in addItemToShop"+item);
		itemService.addItemToShop(item);
		return viewItemsForShops(req);
	}

	@RequestMapping(method = RequestMethod.GET, value = "orderHistory")
	public ModelAndView orderHistory(HttpServletRequest req) {
		String shopId = req.getParameter("shopId");
		log.info("order history ");
		List<Order> orders = orderService.getAllOrdersByShopId(shopId);
		return new ModelAndView("orderHistory", "command", orders);
	}
	

	@RequestMapping(method = RequestMethod.POST,value="updateShopItem")
	public ModelAndView updateShopItem(@ModelAttribute Item item,HttpServletRequest req){
		log.info("in updateShopItem"+item);
		itemService.updateShopItem(item);
		return manageItems(req);
	}

}
