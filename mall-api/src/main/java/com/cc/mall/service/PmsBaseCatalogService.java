package com.cc.mall.service;

import com.cc.mall.entity.PmsBaseCatalog1;
import com.cc.mall.entity.PmsBaseCatalog2;
import com.cc.mall.entity.PmsBaseCatalog3;

import java.util.List;

public interface PmsBaseCatalogService {
    List<PmsBaseCatalog1> getCatalog1();
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
