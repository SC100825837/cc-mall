package com.cc.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cc.mall.entity.PmsBaseAttrInfo;
import com.cc.mall.entity.PmsBaseAttrValue;
import com.cc.mall.service.PmsBaseAttrService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-06-29 21:25
 **/
@RestController
@CrossOrigin
public class PmsBaseAttrController {

    @Reference
    private PmsBaseAttrService pmsBaseAttrService;

    /**
     * 根据三级分类id查询平台属性列表
     * @param catalog3Id
     * @return
     */
    @GetMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(@RequestParam("catalog3Id") String catalog3Id) {
        return pmsBaseAttrService.attrInfoList(catalog3Id);
    }

    /**
     * 新增保存平台属性
     * @param pmsBaseAttrInfo
     */
    @PostMapping("/saveAttrInfo")
    public void saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        pmsBaseAttrService.saveAttrInfo(pmsBaseAttrInfo);
    }

    /**
     * 根据平台属性id查找属性值列表
     * @param attrId
     * @return
     */
    @PostMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(@RequestParam("attrId") String attrId) {
        return pmsBaseAttrService.getAttrValueList(attrId);
    }
}
