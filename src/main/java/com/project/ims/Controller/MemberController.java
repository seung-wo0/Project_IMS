package com.project.ims.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ims.dto.MemberDto;
import com.project.ims.dto.ShopListDto;
import com.project.ims.svc.MemberSvc;
import com.project.ims.svc.ShopListSvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberSvc MemberSvc;
	@Autowired
	ShopListSvc ShopListSvc;
	
	// 회원가입 페이지
	@RequestMapping("/Join") 
	public String mtdJoin() {
		return "Member/MemberJoin";
	}
	
	// 로그인 처리 페이지
	@RequestMapping("/LoginProc")
	public String mtdLoginProc(HttpServletRequest req, HttpSession session, Model model) {
		
		String LoginID = req.getParameter("LoginID");
		String LoginPW = req.getParameter("LoginPW");
		
		int chk = MemberSvc.LoginProc(LoginID,LoginPW);
		
		if (chk==1) {
			System.out.println("로그인 성공");
			MemberDto mlist = MemberSvc.findMemInfo(LoginID);
			ShopListDto slist;
			
			session.setAttribute("userID_session", mlist.getUserID());
			session.setAttribute("userPW_session", mlist.getUserPW());
			session.setAttribute("userPhone_session", mlist.getUserPhone());
			session.setAttribute("userAuth_session", mlist.getUserAuth());
			session.setAttribute("shop_Code_session", mlist.getShop_Code());
			session.setAttribute("shop_Auth_session", mlist.getShop_Auth());
			if (mlist.getUserAuth() > 0) {
				System.out.println("관리자 shopList 진입");
				//model.addAttribute("shopList", ShopListSvc.mtdAllShopList());
				session.setAttribute("shopList", ShopListSvc.mtdAllShopList());
//				System.out.println(ShopListSvc.mtdAllShopList());
			}
			
			if (mlist.getShop_Code() > 0) {
				slist = ShopListSvc.mtdfindShopName(mlist.getShop_Code());
				session.setAttribute("Shop_Name_Session", slist.getShop_Name());
				System.out.println("slist.getShop_Name() : " + slist.getShop_Name());
			}
//			System.out.println("mlist.getShop_Code() : " + mlist.getShop_Code());
			session.setMaxInactiveInterval(10*60*60);
			//model.addAllAttributes("UserMGment", )
			
			return "redirect:/";
		} else {
			System.out.println("로그인 실패");

			model.addAttribute("LoginID",LoginID);
		
			return "Member/LoginFail";
		}
	
	}
	
	//로그아웃 처리
	@RequestMapping("/Logout")
	public String mtdLogout(HttpServletRequest req, HttpSession session) {
		
		session = req.getSession();
		
		if(session != null) {
			session.invalidate();
		} 
		return "redirect:/";
	}
}
