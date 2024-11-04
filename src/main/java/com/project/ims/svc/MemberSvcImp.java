package com.project.ims.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ims.dao.MemberDao;
import com.project.ims.dto.MemberDto;

@Service
public class MemberSvcImp implements MemberSvc {
	
	@Autowired
	MemberDao MemberDao;
	
	
	@Override
	public int LoginProc(String LoginID, String LoginPW) {
		return MemberDao.LoginProc(LoginID,LoginPW);
	}
	
	@Override
	public MemberDto findMemInfo(String uid) {
		return MemberDao.findMemInfo(uid);
	}

}
