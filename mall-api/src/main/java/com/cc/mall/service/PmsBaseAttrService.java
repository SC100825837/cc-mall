package com.cc.mall.service;

import com.cc.mall.entity.PmsBaseAttrInfo;
import com.cc.mall.entity.PmsBaseAttrValue;

import java.util.List;

public interface PmsBaseAttrService {
    /**
     * 根据3级分类id查询平台属性信息
     * @param catalog3Id
     * @return
     */
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    /**
     * 新增保存平台属性
     * @param pmsBaseAttrInfo
     */
    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    /**
     * 根据平台属性id查找属性值列表
     * @param attrId
     * @return
     */
    List<PmsBaseAttrValue> getAttrValueList(String attrId);
}
