package com.shop.controller;

import com.shop.annotation.IgnoreAuth;
import com.shop.entity.GoodsType;
import com.shop.entity.ShopAd;
import com.shop.entity.ShopGoods;
import com.shop.service.ApiAdService;
import com.shop.service.ApiGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaomingpeng on 2018-09-07
 */
@Controller
@RequestMapping("/api/index")
public class ApiIndexController extends ApiBaseController{

    //首页banner广告
    private static final Integer POSITION_ID = 1;

    @Autowired
    private ApiAdService apiAdService;

    @Autowired
    private ApiGoodsService apiGoodsService;

    @IgnoreAuth
    @GetMapping(value = "banner")
    @ResponseBody
    public Object banner(){
        Map<String,Object> resultObj = new HashMap<>();
        List<ShopAd> shopAdList = apiAdService.queryAdsByPosition(POSITION_ID);
        resultObj.put("banner", shopAdList);
        return toResponsSuccess(resultObj);
    }

    @IgnoreAuth
    @GetMapping(value = "group")
    @ResponseBody
    public Object group(){
        Map<String,Object> resultObject = new HashMap<>();
        List<ShopGoods> shopGoodsList = apiGoodsService.queryGoodsByGoodType(GoodsType.GROUP.getId());
        resultObject.put("groupGoodsList", shopGoodsList);
        return toResponsSuccess(resultObject);
    }

}
