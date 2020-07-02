package com.cc.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cc.mall.entity.PmsProductInfo;
import com.cc.mall.mapper.PmsSpuMapper;
import com.cc.mall.service.PmsSpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-07-01 19:28
 **/
@Service
public class PmsSpuServiceImpl implements PmsSpuService {

    @Autowired
    private PmsSpuMapper pmsSpuMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        return pmsSpuMapper.select(pmsProductInfo);
    }
}
