package com.project.ims.svc;

import java.util.List;
import java.util.Map;

import com.project.ims.dto.ShopInventoryDto;

public interface ShopInventorySvc {

	//매장 전체물품리스트 처리 메서드
	List<ShopInventoryDto> mtdAllInventoryList(int Shop_Code);
	
	//매장코드,물품넘버 정보를 ShopInventoryDto에 저장 메서드
	List<ShopInventoryDto> mtdInventoryItemInfo(int Shop_Code, int item_Num);
	
	//index페이지 에서 매장 물품 5개씩 보여주는 메서드
	List<ShopInventoryDto> mtdInventoryListLimit(int Shop_Code);
	
	//재고조정 에서 매장코드,물품명 으로 현재재고 불러오는 메서드
	ShopInventoryDto mtdInventoryItemCntViews(int Shop_Code, String item_Name); // 개별재고불러오기
	
	//개별 물품의 가격 가져오는 메서드
	int mtdInventoryItemPrice(int Shop_Code, String item_Name);
	
	//재고수량조정시 추가,삭제,변경 처리 메서드
	int mtdInventoryItemCntUpdate(Map<String, Object> map);
	
	//상품 추가 처리 메서드
	int mtdInventoryAddItemProc(Map<String, Object> map);
	
}
