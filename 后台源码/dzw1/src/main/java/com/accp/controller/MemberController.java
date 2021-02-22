package com.accp.controller;


import com.accp.domain.Member;
import com.accp.domain.Recharge;
import com.accp.domain.Rectify;
import com.accp.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberServiceImpl memberService;
    /**
     * 会员充值
     * @return
     */
    @PutMapping("/addMemberPrice")
    public boolean addMemberPrice(@RequestBody Recharge recharge){
      return  memberService.addMemberPrice(recharge);
    }

    /**
     * 会员余额校正
     * @param rectify
     * @return
     */
    @PutMapping("/checkMemberPrice")
    public boolean checkMemberPrice(@RequestBody Rectify rectify){
        return  memberService.checkMemberPrice(rectify);
    }
    @GetMapping
    /**
     * 查询全部会员
     */
    public List<Member> selAll(){
        return memberService.list();
    }
    @GetMapping("selByMidOrName/{parse}")
    /**
     * 根据id或姓名查询
     */
    public  List<Member> selByMidOrName(@PathVariable String parse){
        if(parse.equals("我是空查询")){
            return this.selAll();
        }
        return memberService.selByMidOrMname(parse);
    }
    @GetMapping("/selByMid/{mId}")
    /**
     * 根据id查询单个会员
     */
    public Member selByMid(@PathVariable Integer mId){
        return memberService.selByMid(mId);
    }
}

