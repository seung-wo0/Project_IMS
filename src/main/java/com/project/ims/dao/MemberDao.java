package com.project.ims.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.ims.dto.MemberDto;

@Mapper
public interface MemberDao {
	
	int LoginProc(String LoginID, String LoginPW);
	MemberDto findMemInfo(String uid);
	List<MemberDto> mtdMemberList();
	void mtdMemberShopAuthUpdate(Map<String,Object> map);
}
