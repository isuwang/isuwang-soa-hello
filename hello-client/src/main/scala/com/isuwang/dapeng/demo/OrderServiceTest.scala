package com.isuwang.dapeng.demo

import java.io.{BufferedInputStream, InputStream}

import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.joran.JoranConfigurator
import ch.qos.logback.core.util.StatusPrinter
import com.isuwang.dapeng.demo.domain.{FindOrderRequest, Order}
import com.isuwang.dapeng.demo.enums.PayTypeEnum
import org.slf4j.LoggerFactory

/**
  * 订单服务
  * Created by ever on 2017/7/14.
  */
object OrderServiceTest {

  /**
    * 查找订单
    *
    * @return
    */
  def findOrderTest(): List[Order] = {
    OrderServiceClient.findOrder(FindOrderRequest(payType = PayTypeEnum.AliPay, buyerId = 1))
  }

  def main(args: Array[String]): Unit = {

    val logbackCnfgStream: InputStream = new BufferedInputStream(OrderServiceTest.getClass.getClassLoader.getResourceAsStream("logback.xml"))
    val lc: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    val configurator: JoranConfigurator = new JoranConfigurator
    configurator.setContext(lc)
    lc.reset()
    configurator.doConfigure(logbackCnfgStream)
    StatusPrinter.printInCaseOfErrorsOrWarnings(lc)

    val result = findOrderTest()

    result.foreach(order => println(order))

  }

}

