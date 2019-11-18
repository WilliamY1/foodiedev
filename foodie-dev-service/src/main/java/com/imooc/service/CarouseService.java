package com.imooc.service;

import com.imooc.pojo.Carousel;

import java.util.List;

public interface CarouseService {

    /**
     * 查询所有轮播图列表
     *
     * @param isShow
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);
}
