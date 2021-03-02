package com.accp.pay.service;

import com.accp.pay.entity.RefundRequestParams;
import com.accp.pay.entity.qrcode.*;
import com.alipay.api.domain.AlipayTradePrecreateModel;

import javax.servlet.http.HttpServletRequest;

public interface AlipayService {

    RefundResponse pcRefund(RefundRequestParams requestParams);

    QrCodeResponse qrcodePay(AlipayTradePrecreateModel model);

    QrServiceEntity alipayNotify(HttpServletRequest request);

    RefundQueryResponse refundQuery(RefundQueryParams refundQueryParams);

    String pcPreOrder(PreOrderParams preOrderParams);

}
