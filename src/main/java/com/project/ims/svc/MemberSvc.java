package com.project.ims.svc;

import java.util.List;
import java.util.Map;

import com.project.ims.dto.MemberDto;

public interface MemberSvc {
	
	//멤버 회원가입 시 중복아이디 체크 메서드
	int chkID(String JoinUserID);
	
	//멤버 회원가입 처리 메서드
	void mtdJoinProc(Map<String, Object> map);
	
	//멤버 로그인처리 메서드
	int LoginProc(String LoginID, String LoginPW);
	
	//로그인한 멤버정보 세션을 담기위한 메서드
	MemberDto findMemInfo(String uid);
	
}
