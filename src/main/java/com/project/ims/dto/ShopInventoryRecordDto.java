package com.project.ims.dto;

import java.sql.Timestamp;

import lombok.Data;
	
@Data
public class ShopInventoryRecordDto {
	private int num; // 일련번호
	private int Shop_Code; // 매장코드
	private String item_Name; // 제품명
	private int item_Cnt; // 입/출고된 수량
	private Timestamp item_RecordTM; // 입/출고 된 시간
}
