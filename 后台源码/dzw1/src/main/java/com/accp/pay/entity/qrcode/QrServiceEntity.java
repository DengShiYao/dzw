package com.accp.pay.entity.qrcode;

import lombok.Data;

@Data
public class QrServiceEntity {

    private boolean isreceive;

    /**
     * WAIT_BUYER_PAY	交易创建，等待买家付款
        TRADE_CLOSED	未付款交易超时关闭，或支付完成后全额退款
        TRADE_SUCCESS	交易支付成功
        TRADE_FINISHED	交易结束，不可退款
     */
    private String tran_starus;

    //支付时间
    private String gmt_payment;
    //订单号
    private String out_trade_no;

}
