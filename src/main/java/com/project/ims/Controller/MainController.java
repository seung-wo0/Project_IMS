package com.project.ims.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "index";
	}
	
}
