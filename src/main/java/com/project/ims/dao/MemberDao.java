package com.project.ims.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.ims.dto.MemberDto;

@Mapper
public interface MemberDao {
	
	//멤버 회원가입 시 중복아이디 체크 메서드
	int chkID(String JoinUserID);
	
	//멤버 회원가입 처리 메서드
	void mtdJoinProc(Map<String, Object> map);
	
	//멤버 로그인처리 메서드
	int LoginProc(String LoginID, String LoginPW);
	
	//로그인한 멤버정보 세션을 담기위한 메서드
	MemberDto findMemInfo(String uid);
	
	//관리자용 모든 멤버의 리스트를 불러오기위한 메서드
	List<MemberDto> mtdMemberList();
	
	//관리자용 멤버의 관리매장추가를 위한 메서드
	void mtdMemberShopAuthUpdate(Map<String,Object> map);
	
}
