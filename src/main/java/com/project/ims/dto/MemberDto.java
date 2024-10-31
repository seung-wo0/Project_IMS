package com.project.ims.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDto {
	private int num;
	private String uid;
	private String upw;
	private String nickname;
	private String uemail;
	private String uphone;
	private int auth;
	private Timestamp regTM;
}
