package com.project.ims.svc;

import java.util.List;

import com.project.ims.dto.ShopListDto;

public interface ShopListSvc {
	ShopListDto mtdfindShopName(int Shop_Code);
	List<ShopListDto> mtdAllShopList();
}
