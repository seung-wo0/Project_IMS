package com.project.ims.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ims.dto.ShopInventoryDto;
import com.project.ims.svc.ShopInventorySvc;
import com.project.ims.svc.ShopSellStatusSvc;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class InventoryManagerController {
	
	@Autowired
	ShopInventorySvc ShopInventorySvc;
	@Autowired
	ShopSellStatusSvc ShopSellStatusSvc;
	
	
	//재고관리 전체 페이지 (ajax) 관련 mainController에서 테스트완료후 코드이식 (script/script  ajax => url: "/test", 부분 변경해야함)
	@RequestMapping("/ShopManageMent") 
	public String mtdShopManageMentList (Model model, 
			@RequestParam("Shop_Code") int Shop_Code, 
			@RequestParam("Shop_Name") String Shop_Name ) {
		
//		System.out.println("컨트롤러 Shop_Code: " + Shop_Code);
//		System.out.println("컨트롤러 Shop_Name: " + Shop_Name);
		
		model.addAttribute("Shop_InventoryList", ShopInventorySvc.mtdInventoryListLimit(Shop_Code));
		model.addAttribute("Shop_SellStatusList", ShopSellStatusSvc.mtdShopSellStatusList(Shop_Code));
		System.out.println(ShopSellStatusSvc.mtdShopSellStatusList(Shop_Code));
		return "Inventory/InventoryAreaPage";
	}
	

	//인벤토리 재고변경 페이지 관련
	@RequestMapping("/InventoryUpdateCntView") 
	public String mtdInventoryAddNDel (HttpServletRequest req, Model model) {
//		String Shop_Name = req.getParameter("Shop_Name");
		int Shop_Code = Integer.parseInt(req.getParameter("Shop_Code"));
		model.addAttribute("Inven_List", ShopInventorySvc.mtdAllInventoryList(Shop_Code));
//		System.out.println("Shop_Name : " + Shop_Name);
//		System.out.println("Shop_Code : " + Shop_Code);
	
		return "Inventory/InventoryUpdateCnt";
	}
	

	//인벤토리재고 추가,삭제,판매 처리관련
	@RequestMapping("/invenUpdateProc")
	public String mtdInventoryUpdateProc(HttpServletRequest req, RedirectAttributes redirectAttributes) {
	    int NowCnt = Integer.parseInt(req.getParameter("NowCnt"));
	    int Shop_Code = Integer.parseInt(req.getParameter("Shop_Code"));
	    int item_Price = Integer.parseInt(req.getParameter("item_Price"));
	    String item_Name = req.getParameter("item_Name");
	    int item_InputCnt = Integer.parseInt(req.getParameter("Inven_UpdateCnt"));
	    String ClickBtn = req.getParameter("ClickBtn");
	    String SuccessMsg = "페이지에 오류 발생! 재시도 해 주세요";
	    String WhatIsClickBtn = (ClickBtn != null && ClickBtn.length() > 12) ? ClickBtn.substring(12) : "";
	    int item_UpdateCnt = WhatIsClickBtn.equals("AddBtn") ? item_InputCnt : -item_InputCnt;
	    int item_Num = Integer.parseInt(req.getParameter("item_Num"));
	    
	    if (NowCnt + item_UpdateCnt <= -1) {
	        SuccessMsg = "변경 실패ㅠ_ㅠ 재시도 해주세요!";
	    } else {
	        Map<String, Object> map = new HashMap<>();
	        map.put("item1", item_UpdateCnt); // 변경된 수량
	        map.put("item2", item_Price); // 변경된 가격
	        map.put("item3", Shop_Code);     // 샵 코드
	        map.put("item4", item_Name);     // 아이템 이름
	        ShopInventorySvc.mtdInventoryItemCntUpdate(map); // 서비스 호출
	        SuccessMsg = "변경 완료!";
	    }
	    
	    // 재고변경이아닌 "입고" 버튼이라면 판매리스트에 추가
	    if (WhatIsClickBtn.equals("AddBtn")) {
	    	Map<String, Object> map = new HashMap<>();

	    	map.put("item1", Shop_Code); // 매장코드
	    	map.put("item2", item_Name); // 판매 물품명
	    	map.put("item3", item_InputCnt); // 판매한 갯수
	    	ShopInventorySvc.mtdInventoryRecordProc(map);
	    	
	    	SuccessMsg = "입고 완료!";
	    }
	    
	    
	    // 재고변경이아닌 "출고" 버튼이라면 판매리스트에 추가
	    if (WhatIsClickBtn.equals("OutBtn")) {
	    	Map<String, Object> map = new HashMap<>();
	    	map.put("item1", Shop_Code); // 매장코드
	    	map.put("item2", item_Name); // 판매 물품명
	    	map.put("item3", -item_InputCnt); // 판매한 갯수
	    	ShopInventorySvc.mtdInventoryRecordProc(map);
	    	SuccessMsg = "출고 완료!";
	    }
	    
	    // 재고변경이아닌 "판매" 버튼이라면 판매리스트에 추가
	    if (WhatIsClickBtn.equals("SellBtn")) {
	    	Map<String, Object> map = new HashMap<>();
	    	int per_price = ShopInventorySvc.mtdInventoryItemPrice(Shop_Code, item_Name);
	    	
	    	map.put("item1", Shop_Code); // 매장코드
	    	map.put("item2", item_Name); // 판매 물품명
	    	map.put("item3", item_InputCnt); // 판매한 갯수
	    	map.put("item4", per_price); // 물품의 개당가격
	    	map.put("item5", item_InputCnt*per_price); // 갯수*개당가격
	    	ShopSellStatusSvc.mtdSellStatusUpdate(map);
	    	SuccessMsg = "판매 완료!";
	    }
	    
	    // 재고변경,판매 가아닌 삭제버튼이라면
	    if (WhatIsClickBtn.equals("DelBtn")) {
	    	Map<String, Object> map = new HashMap<>();	    	
	    	map.put("item1", item_Num); // 상품고유번호
	    	map.put("item2", item_Name); // 판매 물품명
	    	
	    	ShopInventorySvc.mtdInventoryDelItem(map); // 서비스 호출
	    	SuccessMsg = "삭제 완료!";
	    }
	    
	    redirectAttributes.addFlashAttribute("SuccessMsg", SuccessMsg);
	    return "redirect:/InventorySuccess";
	}

	//인벤토리재고 추가,삭제 처리결과 관련
	@RequestMapping("InventorySuccess")
	public String mtdInventoryUpdateSuccessPage(@ModelAttribute("SuccessMsg") String SuccessMsg, Model model) {
	    model.addAttribute("SuccessMsg", SuccessMsg);
	    return "Inventory/InventoryUpdateSuccess";
	}
	
	@RequestMapping("InventoryAddItem")
	public String mtdInventoryAddItem (HttpServletRequest req, Model model) {
		
		return "Inventory/InventoryAddItem";
	}
	
	@RequestMapping("InventoryAddItemUpdate")
	public String mtdInventoryAddItemProc (HttpServletRequest req, Model model) {
		String Shop_Name = req.getParameter("Shop_Code");
		String addItemName = req.getParameter("AdditemName");
		String AdditemCnt = req.getParameter("AdditemCnt");
		String AdditemPrice = req.getParameter("AdditemPrice");
//		System.out.println("Shop_Name : " + Shop_Name);
//		System.out.println("addItemName : " + addItemName);
//		System.out.println("AdditemCnt : " + AdditemCnt);
//		System.out.println("AdditemPrice : " + AdditemPrice);
		Map<String, Object> map = new HashMap<>();
		map.put("item1", Shop_Name);
		map.put("item2", addItemName);
		map.put("item3", AdditemCnt);
		map.put("item4", AdditemPrice);
		int updateProc = ShopInventorySvc.mtdInventoryAddItemProc(map);
		String ProcMessage = "";
		if (updateProc == 1) {
			ProcMessage = "상품추가가 완료 되었습니다 !";
		} else {
			ProcMessage = "상품추가에 실패 하였습니다 !";
		}
		req.setAttribute("ProcMessage", ProcMessage);

//		System.out.println("처리결과 : " + updateProc);
		return "Inventory/InventoryAddItemProc";
	}
	
}
