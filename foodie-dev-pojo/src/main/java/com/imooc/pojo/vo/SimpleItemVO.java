package com.imooc.pojo.vo;

/**
 * 六个最新商品的简单数据类型
 *
 * @author WuJunyi
 * @create 2019-11-18 14:57
 **/
public class SimpleItemVO {

    private String itemId;
    private String itemName;
    private String itemUrl;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
}
