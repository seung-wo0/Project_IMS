package com.project.ims.dto;

import lombok.Data;

@Data
public class ShopInventoryDto {
	private int num; // AutoIncrement 적용
	private int Shop_Code; // 매장 코드
	private String item_Name; // 매장에 상품명
	private int item_Cnt; // 매장에 상품수량
	private int item_Price;	// 매장의 상품가격
}
