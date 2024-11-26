package com.project.ims.svc;

import java.util.List;
import java.util.Map;

import com.project.ims.dto.MemberDto;

public interface AdminSvc {

	//관리자용 모든 멤버의 리스트를 불러오기위한 메서드
	List<MemberDto> mtdMemberList();
	
	//관리자용 멤버의 관리매장추가를 위한 메서드
	void mtdMemberShopAuthUpdate(Map<String,Object> map);
	
	//관리자용 매장추가 메서드
	int mtdAddShopProc (Map<String, Object> map) ;
}
