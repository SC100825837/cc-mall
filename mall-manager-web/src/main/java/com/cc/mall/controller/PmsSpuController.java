package com.cc.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cc.mall.constant.ServiceConfig;
import com.cc.mall.entity.PmsBaseSaleAttr;
import com.cc.mall.entity.PmsProductImage;
import com.cc.mall.entity.PmsProductInfo;
import com.cc.mall.entity.PmsProductSaleAttr;
import com.cc.mall.service.PmsSpuService;
import com.cc.mall.util.FileUploadUtil;
import org.csource.common.MyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        return pmsSpuService.spuList(catalog3Id);
    }

    @PostMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsSpuService.baseSaleAttrList();
    }

    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException, MyException {
        return FileUploadUtil.fileUpload(file, ServiceConfig.SERVICE_URL);
    }

    @PostMapping("/saveSpuInfo")
    public void saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        pmsSpuService.saveSpuInfo(pmsProductInfo);
    }

    @GetMapping("/spuImageList")
    public List<PmsProductImage> spuImageList(@RequestParam("productId") String productId) {
        return pmsSpuService.spuImageList(productId);
    }

    @GetMapping("/spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(@RequestParam("productId") String productId) {
        return pmsSpuService.spuSaleAttrList(productId);
    }
}
