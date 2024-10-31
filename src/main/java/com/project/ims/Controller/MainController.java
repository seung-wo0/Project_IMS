package com.project.ims.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.project.ims.dto.MemberDto;
import com.project.ims.svc.MemberSvc;

@Controller
public class MainController {
	
	@Autowired
	MemberSvc MemberSvc;
	
	// 메인페이지
	@RequestMapping("/") 
	public String mtdMainIndex() {
		return "index";
	}
	
	// 로그인 페이지
	@RequestMapping("/login") 
	public String mtdLogin() {
		return "Login";
	}
	
	// 로그인 처리 페이지
	@RequestMapping("/LoginProc")
	public String mtdLoginProc(HttpServletRequest req, HttpSession session, Model model) {
		
		String uid = req.getParameter("uid");
		String upw = req.getParameter("upw");
		
		int chk = MemberSvc.LoginProc(uid,upw);
		
		if (chk==1) {
			System.out.println("로그인 성공");
			MemberDto ulist = MemberSvc.findMemInfo(uid);
			session.setAttribute("uid_session", ulist.getUid());
			session.setAttribute("nickname_session", ulist.getNickname());
			session.setAttribute("phone_session", ulist.getUphone());
			session.setAttribute("auth_session", ulist.getAuth());
//			System.out.println(ulist.getUid());
			session.setMaxInactiveInterval(10*60*60);
			return "redirect:/";
		} else {
			System.out.println("로그인 실패");

			model.addAttribute("uid",uid);
		
			return "redirect:/";
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
