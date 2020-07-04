package com.cc.mall.service;

import com.cc.mall.entity.PmsBaseSaleAttr;
import com.cc.mall.entity.PmsProductImage;
import com.cc.mall.entity.PmsProductInfo;
import com.cc.mall.entity.PmsProductSaleAttr;

import java.util.List;

public interface PmsSpuService {
    /**
     * spu列表
     * @param catalog3Id
     * @return
     */
    List<PmsProductInfo> spuList(String catalog3Id);

    /**
     * 基础销售属性列表，添加spu时，添加spu的销售属性选择的内容
     * @return
     */
    List<PmsBaseSaleAttr> baseSaleAttrList();

    /**
     * 保存spu
     * @param pmsProductInfo
     */
    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    /**
     * 根据productId查询图片列表
     * @param productId
     * @return
     */
    List<PmsProductImage> spuImageList(String productId);

    /**
     * 获取spu销售属性列表
     * @param productId
     * @return
     */
    List<PmsProductSaleAttr> spuSaleAttrList(String productId);
}
