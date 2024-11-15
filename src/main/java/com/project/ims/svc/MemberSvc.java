package com.project.ims.svc;

import java.util.List;
import java.util.Map;

import com.project.ims.dto.MemberDto;

public interface MemberSvc {
	int LoginProc(String uid, String upw);
	MemberDto findMemInfo(String uid);
	List<MemberDto> mtdMemberList();
	void mtdMemberShopAuthUpdate(Map<String,Object> map);
}
