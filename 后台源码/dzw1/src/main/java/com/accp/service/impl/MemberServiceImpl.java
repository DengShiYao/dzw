package com.accp.service.impl;

import com.accp.domain.Member;
import com.accp.domain.Recharge;
import com.accp.domain.Rectify;
import com.accp.mapper.MemberMapper;
import com.accp.mapper.RechargeMapper;
import com.accp.mapper.RectifyMapper;
import com.accp.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    RectifyMapper rectifyMapper;

    @Autowired
    RechargeMapper rechargeMapper;

    @Override
    /**
     * 会员充值
     */
    public boolean addMemberPrice(Recharge recharge) {
        try {
            int a= memberMapper.addMemberPrice(recharge.getMoney(),recharge.getMId());
            int a1= rechargeMapper.insert(recharge);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

    @Override
    /**
     * 会员余额校正
     */
    public boolean checkMemberPrice(Rectify rectify) {
        try {
            int a=memberMapper.checkMemberPrice(rectify.getMoney(),rectify.getMId());
            int a1=rectifyMapper.insert(rectify);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Member> selByMidOrMname(String str) {
        return memberMapper.selByMidOrMname(str);
    }

    @Override
    public Member selByMid(Integer mId) {
        return memberMapper.selByMid(mId);
    }
}
