package com.imooc.enums;

/**
 * @Desc:商品分类 枚举
 */
public enum CategortType {

    ROOT(1,"父目录"),
    SECOND(2,"子目录");

    public final Integer type;
    public final String value;

    CategortType(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
