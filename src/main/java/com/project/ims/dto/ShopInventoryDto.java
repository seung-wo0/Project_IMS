package com.project.ims.dto;

import lombok.Data;

@Data
public class ShopInventoryDto {
	private int num;
	private int Shop_Code;
	private String item_Name;
	private int item_Cnt;
	private int item_Price;
}
