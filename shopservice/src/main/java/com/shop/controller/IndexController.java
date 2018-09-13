package com.shop.controller;

import com.shop.annotation.IgnoreAuth;
import com.shop.entity.ShopUser;
import com.shop.interceptor.LoginUser;
import com.shop.service.ApiUserService;
import com.shop.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaomingpeng on 2018-09-04
 */
@RestController
@RequestMapping("/api/test")
public class IndexController {

    @Autowired
    private ApiUserService apiUserService;

    @GetMapping("/userInfo")
    public R userInfo(@LoginUser ShopUser shopUser){
        return R.ok().put("user",shopUser);
    }

    @IgnoreAuth
    @GetMapping("notToken")
    public R notToken() {
        return R.ok().put("msg", "无需token也能访问。。。");
    }

}
