package com.project.ims.svc;

import java.util.List;

import com.project.ims.dto.ShopInventoryDto;

public interface ShopInventorySvc {
	List<ShopInventoryDto> mtdAllInventoryList(int Shop_Code); //매장전체물품
	List<ShopInventoryDto> mtdInventoryListLimit(int Shop_Code); //매장물품5개
}
