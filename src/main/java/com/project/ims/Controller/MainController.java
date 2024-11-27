package com.project.ims.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ims.svc.MemberSvc;
import com.project.ims.svc.ShopInventorySvc;
import com.project.ims.svc.ShopSellStatusSvc;

@Controller
public class MainController {
	
	@Autowired
	MemberSvc MemberSvc;
	@Autowired
	ShopInventorySvc ShopInventorySvc;
	@Autowired
	ShopSellStatusSvc ShopSellStatusSvc;
	
	// 메인페이지
	@RequestMapping("/") 
	public String mtdMainIndex() {
		return "index";
	}
	
	// 테스트 재고관리 페이지 (ajax처리) 테스트완료 후 InvenManageController 에 이식
	@RequestMapping("/test") 
	public String mtdTestPage(
			Model model, 
			@RequestParam("Shop_Code") int Shop_Code, 
			@RequestParam("Shop_Name") String Shop_Name ) {		
		
		model.addAttribute("Shop_InventoryList", ShopInventorySvc.mtdInventoryListLimit(Shop_Code));
		model.addAttribute("Shop_SellStatusList", ShopSellStatusSvc.mtdShopSellStatusList(Shop_Code));

		return "Inventory/InventoryAreaPage";
	}
	
	
}
