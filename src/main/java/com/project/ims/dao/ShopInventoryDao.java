package com.project.ims.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.ims.dto.ShopInventoryDto;

@Mapper
public interface ShopInventoryDao {
	List<ShopInventoryDto> mtdAllInventoryList(int Shop_Code); //매장전체물품
	List<ShopInventoryDto> mtdInventoryListLimit(int Shop_Code); //매장물품5개
	ShopInventoryDto mtdInventoryItemCntViews(int Shop_Code, String item_Name); // 개별재고불러오기
	int mtdInventoryItemCntUpdate(Map<String, Object> map);
}
