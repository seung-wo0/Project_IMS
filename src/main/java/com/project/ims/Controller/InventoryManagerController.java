package com.project.ims.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ims.dto.ShopInventoryDto;
import com.project.ims.svc.ShopInventorySvc;

import jakarta.servlet.http.HttpServletRequest;

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
	
	/////////////////////////////////////////
	////// 인벤토리재고 추가,삭제 관련 //////
	/////////////////////////////////////////
	@RequestMapping("/InventoryUpdateCntView") //페이지 내 
	public String mtdInventoryAddNDel (HttpServletRequest req, Model model) {
//		String Shop_Name = req.getParameter("Shop_Name");
		int Shop_Code = Integer.parseInt(req.getParameter("Shop_Code"));
		model.addAttribute("Inven_List", ShopInventorySvc.mtdAllInventoryList(Shop_Code));
//		System.out.println("Shop_Name : " + Shop_Name);
//		System.out.println("Shop_Code : " + Shop_Code);
	
		return "Inventory/InventoryUpdateCnt";
	}
	
	@RequestMapping("/InventoryItemCnt") //ajax 재고수량카운터
	@ResponseBody
	public ShopInventoryDto mtdInventoryItemCntViews(HttpServletRequest req, Model model) {
		int Shop_Code = Integer.parseInt(req.getParameter("Shop_Code"));
		String item_Name = req.getParameter("item_Name");
		ShopInventoryDto ShopInventoryDto = ShopInventorySvc.mtdInventoryItemCntViews(Shop_Code, item_Name);
		model.addAttribute("ShopInventoryDto", ShopInventoryDto);
		return ShopInventoryDto;
	}

	@RequestMapping("/invenUpdateProc")
	public String mtdInventoryUpdateProc(HttpServletRequest req, RedirectAttributes redirectAttributes) {
	    int NowCnt = Integer.parseInt(req.getParameter("NowCnt"));
	    int Shop_Code = Integer.parseInt(req.getParameter("Shop_Code"));
	    String item_Name = req.getParameter("ShopInvenList");
	    int item_InputCnt = Integer.parseInt(req.getParameter("Inven_UpdateCnt"));
	    String ClickBtn = req.getParameter("ClickBtn");
	    String SuccessMsg = "페이지에 오류 발생! 재시도 해 주세요";

	    // 클릭된 버튼 분석
	    String WhatIsClickBtn = (ClickBtn != null && ClickBtn.length() > 12) ? ClickBtn.substring(12) : "";

	    // 추가/삭제 버튼에 따른 변경량 계산
	    int item_UpdateCnt = WhatIsClickBtn.equals("AddBtn") ? item_InputCnt : -item_InputCnt;

	    // 재고 검증 및 처리
	    if (NowCnt + item_UpdateCnt <= -1) {
	        SuccessMsg = "변경 실패ㅠ_ㅠ 재시도 해주세요!";
	    } else {
	        Map<String, Object> map = new HashMap<>();
	        map.put("item1", item_UpdateCnt); // 변경된 수량
	        map.put("item2", Shop_Code);     // 샵 코드
	        map.put("item3", item_Name);     // 아이템 이름
	        ShopInventorySvc.mtdInventoryItemCntUpdate(map); // 서비스 호출
	        SuccessMsg = "변경 완료!";
	    }

	    // 성공 메시지 전달
	    redirectAttributes.addFlashAttribute("SuccessMsg", SuccessMsg);
	    return "redirect:/InventorySuccess";
	}

	@RequestMapping("InventorySuccess")
	public String mtdInventoryUpdateSuccessPage(@ModelAttribute("SuccessMsg") String SuccessMsg, Model model) {
	    model.addAttribute("SuccessMsg", SuccessMsg);
	    return "Inventory/InventoryUpdateSuccess";
	}
	
}
