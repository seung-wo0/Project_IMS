package com.project.ims.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
}
