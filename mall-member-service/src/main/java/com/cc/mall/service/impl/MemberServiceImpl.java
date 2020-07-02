package com.cc.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cc.mall.entity.UmsMemberReceiveAddress;
import com.cc.mall.mapper.MemberMapper;
import com.cc.mall.mapper.MemberReceiveAddressMapper;
import com.cc.mall.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-06-23 11:49
 **/
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberReceiveAddressMapper memberReceiveAddressMapper;

    @Override
    public List getAllMembers() {
        return memberMapper.selectAll();
    }

    @Override
    public List<UmsMemberReceiveAddress> getMemberReceiveAddress(String memberId) {
        UmsMemberReceiveAddress memberReceiveAddress = new UmsMemberReceiveAddress();
        memberReceiveAddress.setMemberId(memberId);
        return memberReceiveAddressMapper.select(memberReceiveAddress);
    }
}
