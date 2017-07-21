package com.isuwang.dapeng.demo

import com.isuwang.dapeng.core.SoaException
import com.isuwang.dapeng.demo.OrderServiceCodec._
import com.isuwang.dapeng.demo.domain.{FindOrderRequest, Order}
import com.isuwang.dapeng.remoting.BaseScalaServiceClient
import com.isuwang.org.apache.thrift.TException

/**
  * Created by ever on 2017/7/19.
  */
object OrderServiceAsyncClient extends BaseScalaServiceClient("com.isuwang.dapeng.demo.service.OrderService", "1.0.0") {

  override def isSoaTransactionalProcess: Boolean = false

  def findOrderAsync(request: FindOrderRequest, timeout: Long): scala.concurrent.Future[List[Order]] = {

    initContext("findOrder")

    try
      val _request = findOrder_args(request)
      val _resultFuture: java.util.concurrent.CompletableFuture[findOrder_result] = sendBaseAsync(_request, new FindOrder_argsSerializer(), new FindOrder_resultSerializer(), timeout).asInstanceOf[java.util.concurrent.CompletableFuture[findOrder_result]]


    catch {
      case e: SoaException => throw e
      case e: TException => throw new SoaException(e)
    }
    finally {
      destoryContext()
    }
  }

}
