package com.cc.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cc.mall.entity.PmsBaseAttrInfo;
import com.cc.mall.entity.PmsBaseAttrValue;
import com.cc.mall.mapper.PmsBaseAttrInfoMapper;
import com.cc.mall.mapper.PmsBaseAttrValueMapper;
import com.cc.mall.service.PmsBaseAttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-06-29 21:20
 **/
@Service
public class PmsBaseAttrServiceImpl implements PmsBaseAttrService {

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        return pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
    }

    @Override
    @Transactional
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        //判断是否有id，id为空则为新增，否则为编辑
        if (StringUtils.isBlank(pmsBaseAttrInfo.getId())) {
            //插入平台属性
            pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);
            //获取平台属性值列表
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                //将平台属性id设置给平台属性值的对应字段
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                //插入将平台属性值
                pmsBaseAttrValueMapper.insert(pmsBaseAttrValue);
            }
        } else {
            //更新平台属性
            pmsBaseAttrInfoMapper.updateByPrimaryKey(pmsBaseAttrInfo);
            //获取平台属性值列表
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                //判断是否有id，id为空则为新增，否则为编辑
                if (StringUtils.isBlank(pmsBaseAttrValue.getId())) {
                    //将平台属性id设置给平台属性值的对应字段
                    pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                    //插入将平台属性值
                    pmsBaseAttrValueMapper.insert(pmsBaseAttrValue);
                } else {
                    //更新平台属性值
                    pmsBaseAttrValueMapper.updateByPrimaryKey(pmsBaseAttrValue);
                }
            }
        }

    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        return pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
    }
}
