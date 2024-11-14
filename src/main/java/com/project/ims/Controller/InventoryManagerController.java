package com.project.ims.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InventoryManagerController {
	@RequestMapping("/ShopManageMent") 
	public String mtdShopManageMentList() {
		return "Inventory/InventoryAreaPage";
	}
}
