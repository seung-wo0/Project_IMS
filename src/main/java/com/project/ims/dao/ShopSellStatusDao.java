package com.project.ims.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.ims.dto.ShopSellStatusDto;

@Mapper
public interface ShopSellStatusDao {
	
	//매장 전체물품리스트 처리 메서드
	List<ShopSellStatusDto> mtdAllSellStatusList(int Shop_Code);
	
	//index페이지 에서 매장 판매목록 최근순 5개씩 보여주는 메서드
	List<ShopSellStatusDto> mtdShopSellStatusList(int Shop_Code);
	
	// 매장 재고판매시 기록 메서드
	void mtdSellStatusUpdate(Map<String, Object> map);
	
}
