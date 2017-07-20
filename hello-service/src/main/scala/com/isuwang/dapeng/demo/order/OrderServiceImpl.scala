package com.isuwang.dapeng.demo.order

import com.isuwang.dapeng.demo.domain.{FindOrderRequest, Order}
import com.isuwang.dapeng.demo.enums.PayTypeEnum
import com.isuwang.dapeng.demo.service.OrderService

/**
  * 订单服务
  * Created by ever on 2017/7/14.
  */
class OrderServiceImpl extends OrderService {
  /**
    * 查找订单
    *
    * @param request
    * @return
    */
  override def findOrder(request: FindOrderRequest): scala.List[Order] = {

    println(request)

    val order = Order(1, "testOrder", PayTypeEnum.AliPay, 100, 101, BigDecimal(100), Option("test"))

    List(order)
  }
}
