package com.project.ims.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDto {
	private int num;
	private String userID;
	private String userPW;
	private String userPhone;
	private String userEmail;
	private int userAuth;
	private int shop_Code;
	private int shop_Auth;
	private Timestamp joinTM;
}
