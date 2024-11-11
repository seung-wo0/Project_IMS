package com.project.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.ims.dto.ShopListDto;

@Mapper
public interface ShopListDao {
	ShopListDto mtdfindShopName(int Shop_Code);
    List<ShopListDto> mtdAllShopList();
}
