package com.isuwang.dapeng.demo.service

import com.isuwang.dapeng.core.{Processor, Service}
import com.isuwang.dapeng.demo.domain.{FindOrderRequest, Order}

/**
  * 订单服务
  * Created by ever on 2017/7/14.
  */
@Service(version = "1.0.0")
@Processor(className = "com.isuwang.dapeng.demo.OrderServiceCodec$Processor")
trait OrderService {
  /**
    * 查找订单
    *
    * @param request
    * @return
    */
  def findOrder(request: FindOrderRequest): List[Order]
}
