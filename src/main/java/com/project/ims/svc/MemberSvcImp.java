package com.project.ims.svc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ims.dao.MemberDao;
import com.project.ims.dto.MemberDto;

@Service
public class MemberSvcImp implements MemberSvc {
	
	@Autowired
	MemberDao MemberDao;
	
	@Override
	public int chkID(String JoinUserID) {
		return MemberDao.chkID(JoinUserID);
	}
	@Override
	public int LoginProc(String LoginID, String LoginPW) {
		return MemberDao.LoginProc(LoginID,LoginPW);
	}
	
	@Override
	public MemberDto findMemInfo(String uid) {
		return MemberDao.findMemInfo(uid);
	}
	
	@Override
	public List<MemberDto> mtdMemberList() {
		return MemberDao.mtdMemberList();
	}

	@Override
	public void mtdMemberShopAuthUpdate(Map<String, Object> map) {
		MemberDao.mtdMemberShopAuthUpdate(map);
	}
	
	@Override
	public void mtdJoinProc(Map<String, Object> map) {
		MemberDao.mtdJoinProc(map);
	}
	
}
