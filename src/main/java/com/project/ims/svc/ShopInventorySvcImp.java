package com.project.ims.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ims.dao.ShopInventoryDao;
import com.project.ims.dto.ShopInventoryDto;

@Service
public class ShopInventorySvcImp implements ShopInventorySvc {

	@Autowired 
	ShopInventoryDao ShopInventoryDao;
	
	@Override
	public List<ShopInventoryDto> mtdAllInventoryList(int Shop_Code) {
		return ShopInventoryDao.mtdAllInventoryList(Shop_Code);
	}
	
	@Override
	public List<ShopInventoryDto> mtdInventoryListLimit(int Shop_Code) {
		return ShopInventoryDao.mtdInventoryListLimit(Shop_Code);
	}

}
