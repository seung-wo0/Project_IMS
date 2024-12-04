package com.project.ims.svc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ims.dao.ShopSellStatusDao;
import com.project.ims.dto.ShopSellStatusDto;
	
@Service
public class ShopSellStatusSvcImp implements ShopSellStatusSvc {

	@Autowired
	ShopSellStatusDao ShopSellStatusDao;
	
	
	@Override
	public List<ShopSellStatusDto> mtdAllSellStatusList(int Shop_Code) {
		return ShopSellStatusDao.mtdAllSellStatusList(Shop_Code);
	}
	
	@Override
	public void mtdSellStatusUpdate(Map<String, Object> map) {
		ShopSellStatusDao.mtdSellStatusUpdate(map);
	}
	
	@Override
	public List<ShopSellStatusDto> mtdShopSellStatusList(int Shop_Code) {
		return ShopSellStatusDao.mtdShopSellStatusList(Shop_Code);
	}
	
}
