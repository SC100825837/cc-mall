package com.cc.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cc.mall.entity.PmsSkuInfo;
import com.cc.mall.service.PmsSkuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-07-04 16:12
 **/
@RestController
@CrossOrigin
public class PmsSkuController {

    @Reference
    private PmsSkuService pmsSkuService;

    @PostMapping("/saveSkuInfo")
    public void saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        pmsSkuService.saveSkuInfo(pmsSkuInfo);
    }
}
