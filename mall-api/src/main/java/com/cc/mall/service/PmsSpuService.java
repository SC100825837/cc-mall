package com.cc.mall.service;

import com.cc.mall.entity.PmsProductInfo;

import java.util.List;

public interface PmsSpuService {
    List<PmsProductInfo> spuList(String catalog3Id);
}
