package com.isuwang.dapeng.demo.domain

import com.isuwang.dapeng.demo.enums.PayTypeEnum.PayTypeEnum

/**
  * 订单信息
  * Created by ever on 2017/7/14.
  */
case class Order(/** 订单id */
                 id: Int,

                 /** 订单号 */
                 orderNo: String,

                 /** 支付方式 */
                 payType: PayTypeEnum,

                 /** 买家id */
                 buyerId: Int,

                 /** 卖家id */
                 sellerId: Int,

                 /** 成交价格 */
                 price: BigDecimal,

                 /** 备注信息 */
                 remark: Option[String])