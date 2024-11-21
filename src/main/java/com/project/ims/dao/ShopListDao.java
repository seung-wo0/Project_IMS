package com.project.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.ims.dto.ShopListDto;

@Mapper
public interface ShopListDao {
	
	//매장코드에따른 매장명 불러오기
	ShopListDto mtdfindShopName(int Shop_Code); 
	
	//전체매장리스트 불러오기
    List<ShopListDto> mtdAllShopList();
    
}
