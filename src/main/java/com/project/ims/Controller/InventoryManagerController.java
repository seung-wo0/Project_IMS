package com.project.ims.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ims.svc.ShopInventorySvc;

@Controller
public class InventoryManagerController {
	
	@Autowired
	ShopInventorySvc ShopInventorySvc;
	
	@RequestMapping("/ShopManageMent") //재고관리페이지 ajax
	public String mtdShopManageMentList (Model model, 
			@RequestParam("Shop_Code") int Shop_Code, 
			@RequestParam("Shop_Name") String Shop_Name ) {
		
//		System.out.println("컨트롤러 Shop_Code: " + Shop_Code);
//		System.out.println("컨트롤러 Shop_Name: " + Shop_Name);
		
		model.addAttribute("Shop_InventoryList", ShopInventorySvc.mtdInventoryListLimit(Shop_Code));
		
		return "Inventory/InventoryAreaPage";
	}
}
