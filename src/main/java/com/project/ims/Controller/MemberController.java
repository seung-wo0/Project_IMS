package com.project.ims.Controller;


import java.util.HashMap;
import java.util.Map;

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
	
	// 회원가입 전 동의 페이지
	@RequestMapping("/tos") 
	public String mtdJoinTos() {
		return "Member/tos";
	}
	
	// 회원가입 페이지
	@RequestMapping("/join") 
	public String mtdJoin() {
		return "Member/MemberJoin";
	}
	
	//ID 중복 체크
	@RequestMapping("/chkID")
	public String mtdChkID(HttpServletRequest req, HttpSession session) {
		
		String resTxt = "";
		String JoinUserID = req.getParameter("JoinUserID");
		
		int chknum = MemberSvc.chkID(JoinUserID);
		
		if(chknum==1) {
			resTxt = "이미 있는 아이디입니다.";
			session.setAttribute("nowID",JoinUserID);
			session.setAttribute("resTxt",resTxt);
		} else {
			resTxt = "사용 가능한 아이디입니다.";
			session.setAttribute("nowID",JoinUserID);
			session.setAttribute("resTxt",resTxt);
		}
		
		return "redirect:/join";
	}
	
	// 회원가입 처리 페이지
	@RequestMapping("/JoinProc") 
	public String mtdJoinProc(HttpServletRequest req) {
		String JoinUserID = req.getParameter("JoinUserID");
		String JoinUserPW = req.getParameter("JoinUserPW");
		String userPhone = req.getParameter("userPhone");
		String userEmail = req.getParameter("userEmail");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item1", JoinUserID);
		map.put("item2", JoinUserPW);
		map.put("item3", userPhone);
		map.put("item4", userEmail);
		
		MemberSvc.mtdJoinProc(map);
//		System.out.println("JoinUserID : " + JoinUserID);
//		System.out.println("JoinUserPW : " + JoinUserPW);
//		System.out.println("userPhone : " + userPhone);
//		System.out.println("userEmail : " + userEmail);
		return "Member/MemberJoinProc";
	}
	
	
	// 로그인 처리 페이지
	@RequestMapping("/LoginProc")
	public String mtdLoginProc(HttpServletRequest req, HttpSession session, Model model) {
		
		String LoginID = req.getParameter("LoginID");
		String LoginPW = req.getParameter("LoginPW");
		
		int chk = MemberSvc.LoginProc(LoginID,LoginPW);
		
		if (chk==1) {
//			System.out.println("로그인 성공");
			MemberDto mlist = MemberSvc.findMemInfo(LoginID);
			ShopListDto slist = ShopListSvc.mtdfindShopName(mlist.getShop_Code());
			
			session.setAttribute("userID_session", mlist.getUserID());
			session.setAttribute("userPW_session", mlist.getUserPW());
			session.setAttribute("userPhone_session", mlist.getUserPhone());
			session.setAttribute("userAuth_session", mlist.getUserAuth());
			session.setAttribute("Shop_Code_session", mlist.getShop_Code());
			session.setAttribute("shop_Auth_session", mlist.getShop_Auth());
		
			if (mlist.getUserAuth() > 0) { // 만약 관리자라면
//				System.out.println("관리자 shopList 진입");
				session.setAttribute("shopList", ShopListSvc.mtdAllShopList());
//				System.out.println("관리자 shopList 진입끝");
			} 
			
			if (mlist.getShop_Code() > 0) {
				session.setAttribute("Shop_Name_Session", slist.getShop_Name());
//				System.out.println("일반멤버 shopList 진입");
//				System.out.println("일반멤버 shopList 진입끝");
			}
			
//			System.out.println("mlist.getShop_Code() : " + mlist.getShop_Code());
			session.setMaxInactiveInterval(10*60*60);
			return "redirect:/";
		} else {
//			System.out.println("로그인 실패");
			model.addAttribute("LoginID",LoginID);
		
			return "Member/LoginFail";
		}
	
	}
	
	//로그아웃 처리
	@RequestMapping("/Logout")
	public String mtdLogout(HttpServletRequest req, HttpSession session) {
		session = req.getSession();

		if(session != null) session.invalidate();
		
		return "redirect:/";
	}
	
}
