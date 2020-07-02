package com.cc.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cc.mall.entity.PmsProductInfo;
import com.cc.mall.service.PmsSpuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-07-01 19:29
 **/
@RestController
@CrossOrigin
public class PmsSpuController {

    @Reference
    private PmsSpuService pmsSpuService;

    @GetMapping("/spuList")
    public List<PmsProductInfo> spuList(@RequestParam("catalog3Id") String catalog3Id) {
        List<PmsProductInfo> pmsProductInfos = pmsSpuService.spuList(catalog3Id);
        return pmsSpuService.spuList(catalog3Id);
    }
}
