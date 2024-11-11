package com.project.ims.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.ims.dao.ShopListDao;
import com.project.ims.dto.ShopListDto;

@Service
public class ShopListSvcImp implements ShopListSvc {
	
	@Autowired
	ShopListDao ShopListDao;
	
	@Override
	public ShopListDto mtdfindShopName(int Shop_Code) {
		return ShopListDao.mtdfindShopName(Shop_Code);
	}
	
	@Override
	public List<ShopListDto> mtdAllShopList() {
		return ShopListDao.mtdAllShopList();
	}
	
}
