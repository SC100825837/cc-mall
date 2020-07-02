package com.cc.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cc.mall.entity.UmsMember;
import com.cc.mall.entity.UmsMemberReceiveAddress;
import com.cc.mall.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-06-23 11:50
 **/
@RestController
@RequestMapping("/member")
public class MemberController {

    @Reference
    private MemberService memberService;

    @GetMapping("/allMembers")
    @ResponseBody
    public List<UmsMember> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/getMemberReceiveAddress/{memberId}")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getMemberReceiveAddress(@PathVariable("memberId") String memberId) {
        return memberService.getMemberReceiveAddress(memberId);
    }
}
