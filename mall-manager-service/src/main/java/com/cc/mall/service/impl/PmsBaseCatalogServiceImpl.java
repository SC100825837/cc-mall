package com.cc.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cc.mall.entity.PmsBaseCatalog1;
import com.cc.mall.entity.PmsBaseCatalog2;
import com.cc.mall.entity.PmsBaseCatalog3;
import com.cc.mall.service.PmsBaseCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-06-29 20:26
 **/
@Service
public class PmsBaseCatalogServiceImpl implements PmsBaseCatalogService {

    @Autowired
    private BaseMapper<PmsBaseCatalog1> PmsBaseCatalog1BaseMapper;

    @Autowired
    private BaseMapper<PmsBaseCatalog2> pmsBaseCatalog2BaseMapper;

    @Autowired
    private BaseMapper<PmsBaseCatalog3> pmsBaseCatalog3BaseMapper;


    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return PmsBaseCatalog1BaseMapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        return pmsBaseCatalog2BaseMapper.select(pmsBaseCatalog2);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        return pmsBaseCatalog3BaseMapper.select(pmsBaseCatalog3);
    }
}
