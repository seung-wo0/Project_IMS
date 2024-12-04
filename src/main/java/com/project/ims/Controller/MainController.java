package com.project.ims.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ims.svc.MemberSvc;
import com.project.ims.svc.ShopInventorySvc;
import com.project.ims.svc.ShopListSvc;
import com.project.ims.svc.ShopSellStatusSvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	MemberSvc MemberSvc;
	@Autowired
	ShopInventorySvc ShopInventorySvc;
	@Autowired
	ShopSellStatusSvc ShopSellStatusSvc;
	@Autowired
	ShopListSvc ShopListSvc;
	
	// 메인페이지
	@RequestMapping("/") 
	public String mtdMainIndex(HttpServletRequest req, Model model, HttpSession session) {
//		if (session.getAttribute("userAuth_session")) {
//			Object userAuth_session_str =  session.getAttribute("userAuth_session");
//			System.out.println("userAuth_session : " + userAuth_session_str);
//		} else {
//			return "intex";
//		}
//		if(userAuth_session_str.equals("2")) {
//			System.out.println("관리자임 : " + userAuth_session_str);
//			session.setAttribute("userAuth_session", userAuth_session_str);
//			session.setAttribute("shopList", ShopListSvc.mtdAllShopList());
//
//		} 
		return "index";
	}
	
	// 테스트 재고관리 페이지 (ajax처리) 테스트완료 후 InvenManageController 에 이식
	@RequestMapping("/test") 
	public String mtdTestPage(
			Model model, 
			@RequestParam("Shop_Code") int Shop_Code, 
			@RequestParam("Shop_Name") String Shop_Name ) {		
		
		LocalDate todayDate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		System.out.println(dtf.format(todayDate));
		model.addAttribute("Shop_InventoryList", ShopInventorySvc.mtdInventoryListLimit(Shop_Code));
		model.addAttribute("Shop_SellStatusList", ShopSellStatusSvc.mtdShopSellStatusList(Shop_Code));
		model.addAttribute("todayDate" ,dtf.format(todayDate));//오늘날짜 넣어주기
		model.addAttribute("Shop_AllStatusList" ,ShopSellStatusSvc.mtdAllSellStatusList(Shop_Code));//전체판매 목록불러오기
		model.addAttribute("InventoryRecordList" ,ShopInventorySvc.mtdInventoryRecordList(Shop_Code));//전체입/출고 목록불러오기
		
		return "Inventory/InventoryAreaPage";
	}
	
	
}
