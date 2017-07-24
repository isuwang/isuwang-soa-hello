package com.isuwang.dapeng.demo

import java.util.function.BiConsumer

import com.isuwang.dapeng.core.SoaException
import com.isuwang.dapeng.demo.OrderServiceCodec.{FindOrder_argsSerializer, FindOrder_resultSerializer, findOrder_args, findOrder_result}
import com.isuwang.dapeng.demo.domain.{FindOrderRequest, Order}
import com.isuwang.dapeng.remoting.BaseScalaServiceClient
import com.isuwang.org.apache.thrift.TException

import scala.concurrent.{Future, Promise}

/**
  * Created by ever on 2017/7/19.
  */
object OrderServiceAsyncClient extends BaseScalaServiceClient("com.isuwang.dapeng.demo.service.OrderService", "1.0.0") {

  override def isSoaTransactionalProcess: Boolean = false

  def findOrderAsync(request: FindOrderRequest, timeout: Long): scala.concurrent.Future[List[Order]] = {

    initContext("findOrder")

    try
      val _request = findOrder_args(request)
      val _responseFuture: java.util.concurrent.CompletableFuture[findOrder_result] = sendBaseAsync(_request, new FindOrder_argsSerializer(), new FindOrder_resultSerializer(), timeout).asInstanceOf[java.util.concurrent.CompletableFuture[findOrder_result]]

      val promise = Promise[List[Order]]()

      _responseFuture.whenComplete(new BiConsumer[findOrder_result, Throwable] {
        override def accept(t: findOrder_result, u: Throwable): Unit = {
          if (u != null)
            promise.failure(u)
          else
            promise.success(t.success)
        }
      })
      promise.future

    catch {
      case e: SoaException => throw e
      case e: TException => throw new SoaException(e)
    }
    finally {
      destoryContext()
    }
  }

//  def wrapFuture[T](cf: java.util.concurrent.CompletableFuture[T]): Future[T] = {
//
//    val promise = Promise[T]()
//
//    cf.whenComplete(new BiConsumer[T, Throwable] {
//      override def accept(t: T, u: Throwable): Unit = {
//        if (u != null)
//          promise.failure(u)
//        else
//          promise.success(t)
//      }
//    })
//
//    promise.future
//  }

}
