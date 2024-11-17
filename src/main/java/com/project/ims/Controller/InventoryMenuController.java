package com.project.ims.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ims.svc.ShopInventorySvc;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class InventoryMenuController {
	
	@Autowired
	ShopInventorySvc ShopInventorySvc;
	
	@RequestMapping("/Menu_Inventory") //첫번째 메뉴 더보기
	public String mtd_Menu_Inventory (HttpServletRequest req, Model model) {
//		String Shop_Name = req.getParameter("Shop_Name");
		int Shop_Code = Integer.parseInt(req.getParameter("Shop_Code"));
		model.addAttribute("ShopInventoryList", ShopInventorySvc.mtdAllInventoryList(Shop_Code));
//		System.out.println("Shop_Name : " + Shop_Name);
		System.out.println("Shop_Code : " + Shop_Code);
		
		
		
		return "MenuList/Inventory";
	}
	
	@RequestMapping("/Menu_SellStatus")
	public String mtd_Menu_SellStatus() {
		
		return "MenuList/SellStatus";
	}
	
	@RequestMapping("/Menu_3")
	public String mtd_Menu_3() {
		
		return "MenuList/Inventory";
	}
	
	@RequestMapping("/Menu_4")
	public String mtd_Menu_4() {
		return "MenuList/4";
	}
	

	
}
