package com.project.ims.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDto {
	private int num; //AutoIncrement
	private String userID; //멤버 아이디
	private String userPW; // 멤버 비밀번호
	private String userPhone; // 멤버 핸드폰번호
	private String userEmail; // 멤버 이메일주소
	private int userAuth; // 멤버 홈페이지 권한(IMS페이지권한)
	private int shop_Code; // 멤버가 관리하고있는 매장
	private int shop_Auth; // 멤버가 관리하고 있는 매장의 관리자 권한
	private Timestamp joinTM; // 회원가입 시간
}
