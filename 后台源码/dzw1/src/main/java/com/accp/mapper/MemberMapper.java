package com.accp.mapper;

import com.accp.domain.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface MemberMapper extends BaseMapper<Member> {
    /**
     * 会员充值
     * @param changePrice
     * @param mId
     * @return
     */
    public  int addMemberPrice(@Param("mPrice") Double changePrice, @Param("mId") Integer mId);

    /**
     * 校正会员余额
     * @param checkPrice
     * @param mId
     * @return
     */
    public  int checkMemberPrice(@Param("checkPrice") Double checkPrice,@Param("mId") Integer mId);

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
