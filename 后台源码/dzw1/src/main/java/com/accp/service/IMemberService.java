package com.accp.service;

import com.accp.domain.Member;
import com.accp.domain.Recharge;
import com.accp.domain.Rectify;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface IMemberService extends IService<Member> {
    /**
     * 会员充值
     * @param recharge
     * @return
     */
    public boolean addMemberPrice(Recharge recharge);

    /**
     * 会员余额校正
     * @param rectify
     * @return
     */
    public boolean checkMemberPrice(Rectify rectify);

    /**
     * 根据id或姓名模糊查询会员
     * @param str
     * @return
     */
    public List<Member> selByMidOrMname(String str);

    /**
     * 根据mId查询单个会员
     * @param mId
     * @return
     */
    public Member selByMid(Integer mId);
}
