package com.project.ims.svc;

import com.project.ims.dto.MemberDto;

public interface MemberSvc {
	int LoginProc(String uid, String upw);
	MemberDto findMemInfo(String uid);
}
