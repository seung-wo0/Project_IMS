package com.project.ims.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ShopSellStatusDto {
	private int num; //AutoIncrement
	private int Shop_Code; //매장코드
	private String item_Name; //상품명
	private int item_SellCnt; // 판매된 상품갯수
	private int item_Price; // 제품의 개별 가격
	private int item_SellPrice; // 판매한재고*개당가격 의 합
	private Timestamp item_SellTM; // 판매한 시간 
}
