package com.shop.dao;

import com.shop.entity.ShopGoods;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/**
 * Created by zhaomingpeng on 2018-09-08
 */
@SqlResource("api.good")
public interface ApiGoodsDao extends BaseMapper<ShopGoods>{

    List<ShopGoods> queryGoodsByGoodType(@Param("type") Integer type);
}
