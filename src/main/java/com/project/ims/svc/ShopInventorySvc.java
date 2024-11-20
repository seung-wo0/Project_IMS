package com.project.ims.svc;

import java.util.List;
import java.util.Map;

import com.project.ims.dto.ShopInventoryDto;

public interface ShopInventorySvc {
	List<ShopInventoryDto> mtdAllInventoryList(int Shop_Code); //매장전체물품
	List<ShopInventoryDto> mtdInventoryListLimit(int Shop_Code); //매장물품5개
	ShopInventoryDto mtdInventoryItemCntViews(int Shop_Code, String item_Name); // 개별재고불러오기
	int mtdInventoryItemCntUpdate(Map<String, Object> map);
}
