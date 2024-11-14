package com.project.ims.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ims.dto.ShopInventoryDto;
import com.project.ims.svc.MemberSvc;
import com.project.ims.svc.ShopInventorySvc;

@Controller
public class MainController {
	
	@Autowired
	MemberSvc MemberSvc;
	
	// 메인페이지
	@RequestMapping("/") 
	public String mtdMainIndex() {
		return "index";
	}
	
	@Autowired
	ShopInventorySvc ShopInventorySvc;
	// 테스트 재고관리페이지 비동기 ajax실행?
	@RequestMapping("/test") 
	public String mtdTestPage(
			Model model, 
			@RequestParam("Shop_Code") int Shop_Code, 
			@RequestParam("Shop_Name") String Shop_Name ) {
		System.out.println("컨트롤러 Shop_Code: " + Shop_Code);
		System.out.println("컨트롤러 Shop_Name: " + Shop_Name);
		
		model.addAttribute("Shop_InventoryList", ShopInventorySvc.mtdInventoryListLimit(Shop_Code));
		
		
		return "Inventory/InventoryAreaPage";
	}
	
	
}
