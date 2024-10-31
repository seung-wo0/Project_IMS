package com.project.ims.dao;

import org.apache.ibatis.annotations.Mapper;

import com.project.ims.dto.MemberDto;

@Mapper
public interface MemberDao {
	int LoginProc(String uid, String upw);
	MemberDto findMemInfo(String uid);
}
