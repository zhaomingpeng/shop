package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.annotation.IgnoreAuth;
import com.shop.config.EnvConfig;
import com.shop.entity.FullUserInfo;
import com.shop.entity.ShopUser;
import com.shop.entity.UserInfo;
import com.shop.service.ApiTokenService;
import com.shop.service.ApiUserService;
import com.shop.utils.ApiUserUtils;
import com.shop.utils.CharUtil;
import com.shop.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaomingpeng on 2018-09-11
 */
@RestController
@RequestMapping("/api/auth")
public class ApiAuthController extends ApiBaseController {

    @Autowired
    private EnvConfig envConfig;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApiUserService apiUserService;
    @Autowired
    private ApiTokenService apiTokenService;

    @IgnoreAuth
    @PostMapping("loginBywx")
    @ResponseBody
    public Object loginByWeixin() throws Exception{
        JSONObject jsonParam = this.getJsonRequest();
        FullUserInfo fullUserInfo = null;
        String code = "";
        if(!StringUtils.isEmpty(jsonParam.getString("code"))){
            code = jsonParam.getString("code");
        }
        if(null != jsonParam.get("userInfo")){
            fullUserInfo = jsonParam.getObject("userInfo",FullUserInfo.class);
        }
        Map<String, Object> resultObj = new HashMap<String, Object>();
        //
        UserInfo userInfo = fullUserInfo.getUserInfo();
        //获取openid
        String requestUrl = ApiUserUtils.getWebAccess(code,envConfig);
        log.info("requestUrl:"+requestUrl);
        String res = restTemplate.getForObject(requestUrl, String.class);
        JSONObject sessionData = JSON.parseObject(res);
        if (null == sessionData || StringUtils.isEmpty(sessionData.getString("openid"))) {

            return toResponsFail("登录失败");
        }
        //验证用户信息完整性
//        String sha1 = CommonUtils.getSha1(fullUserInfo.getRawData() + sessionData.getString("session_key"));
//        if (!fullUserInfo.getSignature().equals(sha1)) {
//            return toResponsFail("登录失败");
//        }
        //待验证
//        MessageDigest digest = MessageDigest.getInstance("SHA-1");
//        String source = fullUserInfo.getRawData() + sessionData.getString("session_key");
//        digest.update(source.getBytes());
//        byte[] data = digest.digest();
//        StringBuilder sb = new StringBuilder();
//        for(byte b :data){
//            sb.append(String.format("%02x",b));
//        }
//        if(!fullUserInfo.getSignature().equals(sb.toString())){
//            return toResponsFail("登录失败");
//        }

        ShopUser shopUser = apiUserService.queryByOpenId(sessionData.getString("openid"));
        Date date = new Date();
        if(null == shopUser){
            shopUser = new ShopUser();
            shopUser.setUsername("用户"+ CharUtil.getRandomString(12));
            shopUser.setPassword(sessionData.getString("openid"));
            shopUser.setRegisterTime(date);
            shopUser.setRegisterIp(this.getClientIp());
            shopUser.setLastLoginIp(shopUser.getRegisterIp());
            shopUser.setLastLoginTime(shopUser.getRegisterTime());
            shopUser.setWeixinOpenid(sessionData.getString("openid"));
            shopUser.setAvatar(userInfo.getAvatarUrl());
            shopUser.setGender(userInfo.getGender()); // //性别 0：未知、1：男、2：女
            shopUser.setNickname(userInfo.getNickName());
            Integer id = apiUserService.saveShopUser(shopUser);
            shopUser.setId((long)id);

        }else {
            shopUser.setLastLoginIp(this.getClientIp());
            shopUser.setLastLoginTime(date);
            shopUser.setAvatar(userInfo.getAvatarUrl());
            shopUser.setGender(userInfo.getGender()); // //性别 0：未知、1：男、2：女
            shopUser.setNickname(userInfo.getNickName());
            apiUserService.updateShopUser(shopUser);
        }
        Map<String,Object> tokenMap = apiTokenService.createToken(shopUser.getId());
        String token = tokenMap.get("token")==null?"":(String)tokenMap.get("token");
        if(null==userInfo || StringUtils.isEmpty(token)){
            return toResponsFail("登录失败");
        }
        resultObj.put("token", token);
        resultObj.put("userInfo", userInfo);
        resultObj.put("userId", shopUser.getId());

        return toResponsSuccess(resultObj);

    }


}
