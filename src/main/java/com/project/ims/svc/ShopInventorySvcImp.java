package com.project.ims.svc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ims.dao.ShopInventoryDao;
import com.project.ims.dto.ShopInventoryDto;
import com.project.ims.dto.ShopInventoryRecordDto;

@Service
public class ShopInventorySvcImp implements ShopInventorySvc {

	@Autowired 
	ShopInventoryDao ShopInventoryDao;
	
	@Override
	public List<ShopInventoryDto> mtdAllInventoryList(int Shop_Code) {
		return ShopInventoryDao.mtdAllInventoryList(Shop_Code);
	}
	
	@Override
	public List<ShopInventoryDto> mtdInventoryItemInfo(int Shop_Code, int item_Num) {
		return ShopInventoryDao.mtdInventoryItemInfo(Shop_Code, item_Num);
	}
	
	@Override
	public List<ShopInventoryDto> mtdInventoryListLimit(int Shop_Code) {
		return ShopInventoryDao.mtdInventoryListLimit(Shop_Code);
	}
	
	@Override
	public ShopInventoryDto mtdInventoryItemCntViews(int Shop_Code, String item_Name) {
		return ShopInventoryDao.mtdInventoryItemCntViews(Shop_Code, item_Name);
	}
	
	@Override
	public int mtdInventoryItemPrice (int Shop_Code, String item_Name) {
		return ShopInventoryDao.mtdInventoryItemPrice(Shop_Code, item_Name);
	}
	
	@Override
	public int mtdInventoryItemCntUpdate(Map<String, Object> map) {
		return ShopInventoryDao.mtdInventoryItemCntUpdate(map);
	}
	
	@Override
	public int mtdInventoryAddItemProc(Map<String, Object> map) {
		return ShopInventoryDao.mtdInventoryAddItemProc(map);
	}
	
	@Override
	public int mtdInventoryDelItem(Map<String, Object> map) {
		return ShopInventoryDao.mtdInventoryDelItem(map);
	}
	
	@Override
	public int mtdInventoryRecordProc(Map<String, Object> map) {
		return ShopInventoryDao.mtdInventoryRecordProc(map);
	}
	
	@Override
	public List<ShopInventoryRecordDto> mtdInventoryRecordList(int Shop_Code) {
		return ShopInventoryDao.mtdInventoryRecordList(Shop_Code);
	}
	
	@Override
	public List<ShopInventoryRecordDto> mtdInventoryRecordListLimit(int Shop_Code) {
		return ShopInventoryDao.mtdInventoryRecordListLimit(Shop_Code);
	}
	
}
