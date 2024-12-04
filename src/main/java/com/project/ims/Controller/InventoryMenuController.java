package com.project.ims.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ims.svc.ShopInventorySvc;
import com.project.ims.svc.ShopSellStatusSvc;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class InventoryMenuController {
	
	@Autowired
	ShopInventorySvc ShopInventorySvc;
	@Autowired
	ShopSellStatusSvc ShopSellStatusSvc;
	
	//재고목록 더보기 메서드
	@RequestMapping("/Menu_Inventory") 
	public String mtd_Menu_Inventory (HttpServletRequest req, Model model) {
//		String Shop_Name = req.getParameter("Shop_Name");
		int Shop_Code = Integer.parseInt(req.getParameter("Shop_Code"));
		model.addAttribute("ShopInventoryList", ShopInventorySvc.mtdAllInventoryList(Shop_Code));
//		System.out.println("Shop_Name : " + Shop_Name);
//		System.out.println("Shop_Code : " + Shop_Code);

		return "MenuList/Inventory";
	}
	
	//판매정산 더보기 메서드
	@RequestMapping("/Menu_SellStatus")
	public String mtd_Menu_SellStatus(HttpServletRequest req, Model model) {
		int Shop_Code = Integer.parseInt(req.getParameter("Shop_Code"));
		model.addAttribute("Shop_SellStatusList", ShopSellStatusSvc.mtdAllSellStatusList(Shop_Code));
		return "MenuList/SellStatus";
	}
	
	@RequestMapping("/Menu_InventoryRecord")
	public String mtd_Menu_InventoryRecord(HttpServletRequest req, Model model) {
		int Shop_Code = Integer.parseInt(req.getParameter("Shop_Code"));
		model.addAttribute("Shop_InventoryRecord", ShopInventorySvc.mtdInventoryRecordList(Shop_Code));
		return "MenuList/InventoryRecord";
	}
	
	@RequestMapping("/Menu_4")
	public String mtd_Menu_4() {
		return "MenuList/4";
	}
	
}
