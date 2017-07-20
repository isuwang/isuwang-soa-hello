package com.isuwang.dapeng.demo.domain

import com.isuwang.dapeng.demo.enums.PayTypeEnum.PayTypeEnum

/**
  * 查找订单请求
  * Created by ever on 2017/7/14.
  */
case class FindOrderRequest(/** 支付方式 */
                            payType: PayTypeEnum,

                            /** 买家id */
                            buyerId: Int)