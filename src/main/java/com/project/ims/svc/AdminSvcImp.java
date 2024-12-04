package com.project.ims.svc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ims.dao.MemberDao;
import com.project.ims.dto.MemberDto;
import com.project.ims.dao.AdminDao;

@Service
public class AdminSvcImp implements AdminSvc{
	
	@Autowired
	MemberDao MemberDao;
	@Autowired
	AdminDao AdminDao;
	
	@Override
	public List<MemberDto> mtdMemberList() {
		return AdminDao.mtdMemberList();
	}

	@Override
	public void mtdMemberShopAuthUpdate(Map<String, Object> map) {
		AdminDao.mtdMemberShopAuthUpdate(map);
	}
	
	@Override
	public int mtdAddShopProc(Map<String, Object> map) {
		return AdminDao.mtdAddShopProc(map);
	}
	
}
