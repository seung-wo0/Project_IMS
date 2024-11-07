package com.project.ims.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ims.svc.MemberSvc;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
	
	@Autowired
	MemberSvc MemberSvc;
	
	@RequestMapping("Member_Edit")
	public String mtdMember_Edit (Model model) { //관리자 로그인시 관리자편집기능체크
		model.addAttribute("memberList", MemberSvc.mtdMemberList());
		//System.out.println(MemberSvc.mtdMemberList());
		return "Admin/MemberEdit";
	}
	
	@RequestMapping("EditUserPage")
	public String mtdSelectUserEdit (HttpServletRequest req , Model model) {
		String SelectUserID = req.getParameter("SelectUserID");
		model.addAttribute("SelectUserID", SelectUserID);
		return "Admin/SelectEditUser";
	}
	
}
