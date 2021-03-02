package com.accp.controller;


import com.accp.domain.Dingdan;
import com.accp.domain.SysUser;
import com.accp.pay.entity.qrcode.QrServiceEntity;
import com.accp.pay.service.AlipayService;
import com.accp.pay.utils.ParamsUtil;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.DingdanServiceImpl;
import com.accp.utils.OrderCodeFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.SimpleFormatter;

/**
 * <p>
 * 前端控制器
 * </p>
 * 订单
 *
 * @author dsy
 * @since 2021-03-01
 */
@RestController
@RequestMapping("/dingdan")
public class DingdanController {

    @Autowired
    DingdanServiceImpl service;
    @Autowired
    AlipayService alipayService;

    /**
     * 后台生成订单号
     * @param session
     * @return
     */
    @PostMapping("/factoryorderid")
    public ResultVO factoryOrderId(HttpSession session, Dingdan dingdan) {
        //点击结算增加订单并生成二维码返回


        //column2   1  等待付款
        //column2   2  交易成功
        //column2   3  退款
        //column2   4
        //column3   1  支付宝
        //column3   2  微信
        //column3   3  现金
        //column3   4  银联
        /*
        * WAIT_BUYER_PAY	交易创建，等待买家付款
        TRADE_CLOSED	未付款交易超时关闭，或支付完成后全额退款
        TRADE_SUCCESS	交易支付成功
        TRADE_FINISHED	交易结束，不可退款
        * */
        dingdan.setColumn2(1);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String dateTime = simpleDateFormat.format(date);
        dingdan.setCreateTime(dateTime);

        session.setAttribute("user",new SysUser().setUserId(1));
        SysUser user = (SysUser) session.getAttribute("user");
        //用户未登录
        if (user == null) {return new ResultVO(ResultCode.USER_NOT_LOGIN);}
        //生成订单号
        String orderCode = OrderCodeFactory.getOrderCode(Long.valueOf(user.getUserId()));
        boolean b = checkdeOrderId(orderCode);
        if (b) {
            dingdan.setOrderid(orderCode);
            dingdan.setUserid(user.getUserId());
            service.save(dingdan);
            return new ResultVO(ResultCode.SUCCESS, orderCode);
        }
        return new ResultVO(ResultCode.PEY_EXIT);
    }

    /**
     * 验证订单号是否重复
     *
     * @param orderid
     * @return
     */
    public boolean checkdeOrderId(String orderid) {
        Dingdan one = service.getOne(new QueryWrapper<Dingdan>().lambda().eq(Dingdan::getOrderid, orderid));
        if (one == null) {
            return true;
        }
        return false;
    }

    public void insOrder(Dingdan dingdan) {
        boolean save = service.save(dingdan);
    }

    @PostMapping("/findorderid")
    public ResultVO requestPya(String orderid){
        Dingdan one = service.getOne(new QueryWrapper<Dingdan>().lambda().eq(Dingdan::getOrderid, orderid));
        return new ResultVO(ResultCode.SUCCESS,one.getColumn2());
    }

    /**
     * 支付宝回调查询修改当前订单状态
     * @param request
     * @return
     */
    @RequestMapping(value = "notify_url",method = RequestMethod.POST)
    public String notifyurl(HttpServletRequest request) {
        QrServiceEntity qrServiceEntity = alipayService.alipayNotify(request);
        if ("TRADE_SUCCESS".equals(qrServiceEntity.getTran_starus())){
            Dingdan dingdan = new Dingdan().setDealTime(qrServiceEntity.getGmt_payment()).setColumn2(2);
            dingdan.update(new QueryWrapper<Dingdan>().lambda().eq(Dingdan::getOrderid,qrServiceEntity.getOut_trade_no()));
            //支付成功
            //修改订单状态
            return "success";
        }else if ("WAIT_BUYER_PAY".equals(qrServiceEntity.getTran_starus())){
            //交易创建 待付款
            Dingdan dingdan = new Dingdan().setColumn2(1);
            dingdan.update(new QueryWrapper<Dingdan>().lambda().eq(Dingdan::getOrderid,qrServiceEntity.getOut_trade_no()));
            return "success";
        }else if("TRADE_CLOSED".equals(qrServiceEntity.getTran_starus())){
            //订单超时或者退款
            //交易创建 待付款
            Dingdan dingdan = new Dingdan().setColumn2(3);
            dingdan.update(new QueryWrapper<Dingdan>().lambda().eq(Dingdan::getOrderid,qrServiceEntity.getOut_trade_no()));
            return "success";
        }
        return "failer";
    }
}

