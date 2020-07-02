package com.cc.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cc.mall.entity.PmsBaseAttrInfo;
import com.cc.mall.entity.PmsBaseCatalog1;
import com.cc.mall.entity.PmsBaseCatalog2;
import com.cc.mall.entity.PmsBaseCatalog3;
import com.cc.mall.service.PmsBaseAttrService;
import com.cc.mall.service.PmsBaseCatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-06-29 20:29
 **/
@RestController
@CrossOrigin
public class PmsBaseCatalogController {

    @Reference
    private PmsBaseCatalogService pmsBaseCatalogService;

    @PostMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalogService.getCatalog1();
    }

    @PostMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(@RequestParam("catalog1Id") String catalog1Id) {
        return pmsBaseCatalogService.getCatalog2(catalog1Id);
    }

    @PostMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam("catalog2Id") String catalog2Id) {
        return pmsBaseCatalogService.getCatalog3(catalog2Id);
    }

}
