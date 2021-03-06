package com.isuwang.dapeng.demo

import com.isuwang.dapeng.core.SoaException
import com.isuwang.dapeng.demo.OrderServiceCodec._
import com.isuwang.dapeng.demo.domain.{FindOrderRequest, Order}
import com.isuwang.dapeng.remoting.BaseScalaServiceClient
import com.isuwang.org.apache.thrift.TException
import com.sun.xml.internal.ws.util.CompletedFuture

/**
  * Created by ever on 2017/7/19.
  */
object OrderServiceClient extends BaseScalaServiceClient("com.isuwang.dapeng.demo.service.OrderService", "1.0.0") {

  override def isSoaTransactionalProcess: Boolean = false

  def findOrder(request: FindOrderRequest): List[Order] = {
    initContext("findOrder")

    try {
      val _request = findOrder_args(request)
      val _response = sendBase(_request, new FindOrder_argsSerializer(), new FindOrder_resultSerializer())
      _response.success
    } catch {
      case e: SoaException => throw e
      case e: TException => throw new SoaException(e)
    }
    finally {
      destoryContext()
    }
  }


  @throws[SoaException]
  def getServiceMetadata: String = {

    initContext("getServiceMetadata")
    try {
      val _request = new getServiceMetadata_args()
      val _response = sendBase(_request, new GetServiceMetadata_argsSerializer(), new GetServiceMetadata_resultSerializer())
      _response.success
    } catch {
      case e: SoaException => throw e
      case e: TException => throw new SoaException(e)
    }
    finally {
      destoryContext()
    }
  }

}
