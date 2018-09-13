package com.shop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhaomingpeng on 2018-09-07
 *
 */
public class ShopAd implements Serializable {

    private static final long serialVersionUID = -1758462173501843988L;

    //主键
    private Integer id;
    //广告位置Id
    private Integer adPositionId;
    //形式
    private Integer mediaType;
    //广告名称
    private String name;
    //链接
    private String link;
    //图片
    private String imageUrl;
    //内容
    private String content;
    //结束时间
    private Date endTime;
    //状态
    private Integer enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdPositionId() {
        return adPositionId;
    }

    public void setAdPositionId(Integer adPositionId) {
        this.adPositionId = adPositionId;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
