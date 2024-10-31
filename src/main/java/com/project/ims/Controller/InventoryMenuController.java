package com.project.ims.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InventoryMenuController {
	
	@RequestMapping("/Menu_Inventory") //첫번째 메뉴 더보기
	public String mtd_Menu_Inventory() {
		
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
