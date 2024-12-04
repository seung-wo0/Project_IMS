package com.project.ims.dto;

import lombok.Data;
	
@Data
public class ShopListDto {
	private int num; // AutoIncrement 적용
	private String Shop_Name; // 매장명
	private int Shop_Code; // 매장코드
}
