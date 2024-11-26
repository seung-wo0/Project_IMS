package com.project.ims.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ims.svc.MemberSvc;
import com.project.ims.svc.ShopListSvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	MemberSvc MemberSvc;
	@Autowired
	ShopListSvc ShopListSvc;
	
	//관리자용 멤버의전체 리스트 관련
	@RequestMapping("/Member_Edit")
	public String mtdMember_Edit (Model model) { 
		model.addAttribute("memberList", MemberSvc.mtdMemberList());
//		System.out.println(MemberSvc.mtdMemberList());
		return "Admin/MemberEdit";
	}
	
	//관리자용 멤버의 관리매장 추가 관련
	@RequestMapping("/EditUserPage")
	public String mtdSelectUserEdit (HttpServletRequest req , Model model, HttpSession session) {
		String SelectUserID = req.getParameter("SelectUserID");
		model.addAttribute("SelectUserID", SelectUserID);
//		System.out.println("ShopListSvc.mtdAllShopList(): " + ShopListSvc.mtdAllShopList());
//		session.setAttribute("shopList", ShopListSvc.mtdAllShopList());
		model.addAttribute("shopList", ShopListSvc.mtdAllShopList());
		return "Admin/SelectEditUser";
	}
	
	//관리자용 멤버의 관리매장 추가처리 관련
	@RequestMapping("/MemberShopAuthProc")
	public String mtdMemberShopAuthProc (HttpServletRequest req , Model model, HttpSession session) {
		String SelectUserID = req.getParameter("SelectUserID");
		String selectShop = req.getParameter("selectShop");
//		System.out.println("SelectUserID : " + SelectUserID);
//		System.out.println("selectShop : " + selectShop);
		Map<String,Object> map = new HashMap<String, Object>();
		if (selectShop == "" || selectShop == null) {
//			System.out.println("selectShop공백 : " + selectShop);
			selectShop = "0";
		} 
			map.put("item1", SelectUserID);
			map.put("item2", selectShop);
			MemberSvc.mtdMemberShopAuthUpdate(map);
		
		return "Admin/CloseWindow";
	}
	
	@RequestMapping("addShop")
	public String mtdAddShopPage (Model model) {
		int RandomShopCode = 0;
		Random random = new Random();
		RandomShopCode += random.nextInt(100000,999999);
		model.addAttribute("RandomShopCode", RandomShopCode);
		System.out.println("랜덤생성된 샵코드 : " + RandomShopCode);
		return "Admin/AddShop";
	}
	
	@RequestMapping("addShopProc")
	public String mtdAddShopTestPage (HttpServletRequest req, Model model) {
		
//		System.out.println("랜덤생성된 샵코드 : " + RandomShopCode);
		return "Admin/CloseWindow";
	}
}
