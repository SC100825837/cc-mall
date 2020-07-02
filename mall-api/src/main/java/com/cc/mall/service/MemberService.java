package com.cc.mall.service;

import com.cc.mall.entity.UmsMember;
import com.cc.mall.entity.UmsMemberReceiveAddress;

import java.util.List;

public interface MemberService {

    List<UmsMember> getAllMembers();

    List<UmsMemberReceiveAddress> getMemberReceiveAddress(String memberId);
}
