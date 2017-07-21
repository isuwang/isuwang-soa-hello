package com.isuwang.dapeng.demo

import com.isuwang.dapeng.core._
import com.isuwang.dapeng.demo.service.OrderService
import com.isuwang.org.apache.thrift._
import com.isuwang.org.apache.thrift.protocol._

object OrderServiceCodec {

  class OrderSerializer extends TScalaBeanSerializer[com.isuwang.dapeng.demo.domain.Order] {
    @throws[TException]
    override def read(iproto: TProtocol): com.isuwang.dapeng.demo.domain.Order = {

      iproto.readStructBegin

      var schemeField: com.isuwang.org.apache.thrift.protocol.TField = null

      var id: Int = 0
      var orderNo: String = null
      var payType: com.isuwang.dapeng.demo.enums.PayTypeEnum.PayTypeEnum = null
      var buyerId: Int = 0
      var sellerId: Int = 0
      var price: BigDecimal = null
      var remark: Option[String] = None

      while (schemeField == null || schemeField.`type` != com.isuwang.org.apache.thrift.protocol.TType.STOP) {
        schemeField = iproto.readFieldBegin

        schemeField.id match {
          case 1 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.I32 => id = iproto.readI32
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case 2 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.STRING => orderNo = iproto.readString
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case 3 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.I32 =>
                payType = com.isuwang.dapeng.demo.enums.PayTypeEnum.findByValue(iproto.readI32)
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case 4 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.I32 => buyerId = iproto.readI32
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case 5 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.I32 => sellerId = iproto.readI32
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case 6 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.STRING => price = BigDecimal(iproto.readString)
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case 7 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.STRING =>
                val elem0 = iproto.readString
                remark = Some(elem0)
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
        }

        iproto.readFieldEnd
      }

      iproto.readStructEnd

      val bean = com.isuwang.dapeng.demo.domain.Order(id, orderNo, payType, buyerId, sellerId, price, remark)
      validate(bean)

      bean
    }

    @throws[TException]
    override def write(bean: com.isuwang.dapeng.demo.domain.Order, oproto: TProtocol): Unit = {
      validate(bean)
      oproto.writeStructBegin(new com.isuwang.org.apache.thrift.protocol.TStruct("Order"))

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("id", com.isuwang.org.apache.thrift.protocol.TType.I32, 1.asInstanceOf[Short]))
      oproto.writeI32(bean.id)
      oproto.writeFieldEnd

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("orderNo", com.isuwang.org.apache.thrift.protocol.TType.STRING, 2.asInstanceOf[Short]))
      oproto.writeString(bean.orderNo)
      oproto.writeFieldEnd

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("payType", com.isuwang.org.apache.thrift.protocol.TType.I32, 3.asInstanceOf[Short]))
      oproto.writeI32(bean.payType.id)
      oproto.writeFieldEnd

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("buyerId", com.isuwang.org.apache.thrift.protocol.TType.I32, 4.asInstanceOf[Short]))
      oproto.writeI32(bean.buyerId)
      oproto.writeFieldEnd

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("sellerId", com.isuwang.org.apache.thrift.protocol.TType.I32, 5.asInstanceOf[Short]))
      oproto.writeI32(bean.sellerId)
      oproto.writeFieldEnd

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("price", com.isuwang.org.apache.thrift.protocol.TType.STRING, 6.asInstanceOf[Short]))
      oproto.writeString(bean.price.toString())
      oproto.writeFieldEnd

      bean.remark.map { elem0 =>
        oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("remark", com.isuwang.org.apache.thrift.protocol.TType.STRING, 7.asInstanceOf[Short]))
        oproto.writeString(elem0)
        oproto.writeFieldEnd
      }

      oproto.writeFieldStop
      oproto.writeStructEnd
    }

    @throws[TException]
    override def validate(bean: com.isuwang.dapeng.demo.domain.Order): Unit = {
      if (bean.orderNo == null)
        throw new SoaException(SoaBaseCode.NotNull, "orderNo字段不允许为空")
      if (bean.payType == null)
        throw new SoaException(SoaBaseCode.NotNull, "payType字段不允许为空")
      if (bean.price == null)
        throw new SoaException(SoaBaseCode.NotNull, "price字段不允许为空")
    }

    @throws[TException]
    override def toString(bean: com.isuwang.dapeng.demo.domain.Order): String = {
      if (bean == null) "null" else bean.toString
    }
  }

  class FindOrderRequestSerializer extends TScalaBeanSerializer[com.isuwang.dapeng.demo.domain.FindOrderRequest] {
    @throws[TException]
    override def read(iproto: TProtocol): com.isuwang.dapeng.demo.domain.FindOrderRequest = {
      iproto.readStructBegin

      var schemeField: com.isuwang.org.apache.thrift.protocol.TField = null

      var payType: com.isuwang.dapeng.demo.enums.PayTypeEnum.PayTypeEnum = null
      var buyerId: Int = 0

      while (schemeField == null || schemeField.`type` != com.isuwang.org.apache.thrift.protocol.TType.STOP) {
        schemeField = iproto.readFieldBegin

        schemeField.id match {
          case 1 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.I32 =>
                payType = com.isuwang.dapeng.demo.enums.PayTypeEnum.findByValue(iproto.readI32)
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case 2 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.I32 => buyerId = iproto.readI32
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
        }

        iproto.readFieldEnd
      }

      iproto.readStructEnd

      val bean = com.isuwang.dapeng.demo.domain.FindOrderRequest(payType, buyerId)
      validate(bean)

      bean
    }

    @throws[TException]
    override def write(bean: com.isuwang.dapeng.demo.domain.FindOrderRequest, oproto: TProtocol): Unit = {
      validate(bean)
      oproto.writeStructBegin(new com.isuwang.org.apache.thrift.protocol.TStruct("FindOrderRequest"))

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("payType", com.isuwang.org.apache.thrift.protocol.TType.I32, 1.asInstanceOf[Short]))
      oproto.writeI32(bean.payType.id)
      oproto.writeFieldEnd

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("buyerId", com.isuwang.org.apache.thrift.protocol.TType.I32, 2.asInstanceOf[Short]))
      oproto.writeI32(bean.buyerId)
      oproto.writeFieldEnd

      oproto.writeFieldStop
      oproto.writeStructEnd
    }

    @throws[TException]
    override def validate(bean: com.isuwang.dapeng.demo.domain.FindOrderRequest): Unit = {
      if (bean.payType == null)
        throw new SoaException(SoaBaseCode.NotNull, "payType字段不允许为空")
    }

    override def toString(bean: com.isuwang.dapeng.demo.domain.FindOrderRequest): String = if (bean == null) "null" else bean.toString
  }

  case class findOrder_args(request: com.isuwang.dapeng.demo.domain.FindOrderRequest)

  case class findOrder_result(success: List[com.isuwang.dapeng.demo.domain.Order])

  class FindOrder_argsSerializer extends TScalaBeanSerializer[findOrder_args] {
    @throws[TException]
    override def read(iproto: TProtocol): findOrder_args = {
      iproto.readStructBegin

      var schemeField: com.isuwang.org.apache.thrift.protocol.TField = null

      var request: com.isuwang.dapeng.demo.domain.FindOrderRequest = null

      while (schemeField == null || schemeField.`type` != com.isuwang.org.apache.thrift.protocol.TType.STOP) {
        schemeField = iproto.readFieldBegin

        schemeField.id match {
          case 1 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.STRUCT =>
                request = new FindOrderRequestSerializer().read(iproto)
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
        }

        iproto.readFieldEnd
      }

      iproto.readStructEnd

      val bean = findOrder_args(request)
      validate(bean)

      bean
    }

    @throws[TException]
    override def write(bean: findOrder_args, oproto: TProtocol): Unit = {
      validate(bean)
      oproto.writeStructBegin(new com.isuwang.org.apache.thrift.protocol.TStruct("findOrder_args"))

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("request", com.isuwang.org.apache.thrift.protocol.TType.STRUCT, 1.asInstanceOf[Short]))
      new FindOrderRequestSerializer().write(bean.request, oproto)
      oproto.writeFieldEnd

      oproto.writeFieldStop
      oproto.writeStructEnd
    }

    @throws[TException]
    override def validate(bean: findOrder_args): Unit = {
      if (bean.request == null)
        throw new SoaException(SoaBaseCode.NotNull, "request字段不允许为空")
    }

    override def toString(bean: findOrder_args): String = if (bean == null) "null" else bean.toString

  }

  class FindOrder_resultSerializer extends TScalaBeanSerializer[findOrder_result] {
    @throws[TException]
    override def read(iproto: TProtocol): findOrder_result = {
      iproto.readStructBegin

      var schemeField: com.isuwang.org.apache.thrift.protocol.TField = null

      var success: List[com.isuwang.dapeng.demo.domain.Order] = List.empty

      while (schemeField == null || schemeField.`type` != com.isuwang.org.apache.thrift.protocol.TType.STOP) {
        schemeField = iproto.readFieldBegin

        schemeField.id match {
          case 0 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.LIST =>
                val _list0: com.isuwang.org.apache.thrift.protocol.TList = iproto.readListBegin()
                success = (0 until _list0.size).map(_ => {
                  new OrderSerializer().read(iproto)
                }).toList
                iproto.readListEnd
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
        }

        iproto.readFieldEnd
      }

      iproto.readStructEnd

      val bean = findOrder_result(success)
      validate(bean)

      bean
    }

    @throws[TException]
    override def write(bean: findOrder_result, oproto: TProtocol): Unit = {
      validate(bean)
      oproto.writeStructBegin(new com.isuwang.org.apache.thrift.protocol.TStruct("findOrder_result"))

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("success", com.isuwang.org.apache.thrift.protocol.TType.LIST, 0.asInstanceOf[Short]))

      val elem0 = bean.success

      oproto.writeListBegin(new com.isuwang.org.apache.thrift.protocol.TList(com.isuwang.org.apache.thrift.protocol.TType.STRUCT, elem0.size))

      elem0.foreach(elem1 => {
        new OrderSerializer().write(elem1, oproto)
      })

      oproto.writeListEnd

      oproto.writeFieldEnd

      oproto.writeFieldStop
      oproto.writeStructEnd
    }

    @throws[TException]
    override def validate(bean: findOrder_result): Unit = {
      if (bean.success == null)
        throw new SoaException(SoaBaseCode.NotNull, "success字段不允许为空")
    }

    override def toString(bean: findOrder_result): String = if (bean == null) "null" else bean.toString

  }


  class findOrder extends SoaProcessFunction[com.isuwang.dapeng.demo.service.OrderService, findOrder_args, findOrder_result, FindOrder_argsSerializer, FindOrder_resultSerializer](
    "findOrder", new FindOrder_argsSerializer(), new FindOrder_resultSerializer()) {
    def isOneway: Boolean = false

    def getEmptyArgsInstance: findOrder_args = findOrder_args(null)

    @throws[TException]
    def getResult(iface: com.isuwang.dapeng.demo.service.OrderService, args: findOrder_args): findOrder_result = {
      findOrder_result(iface.findOrder(args.request))
    }
  }

  class getServiceMetadata extends SoaProcessFunction[com.isuwang.dapeng.demo.service.OrderService, getServiceMetadata_args, getServiceMetadata_result, GetServiceMetadata_argsSerializer, GetServiceMetadata_resultSerializer](
    "getServiceMetadata", new GetServiceMetadata_argsSerializer(), new GetServiceMetadata_resultSerializer()) {
    override def isOneway: Boolean = false

    override def getEmptyArgsInstance: getServiceMetadata_args = getServiceMetadata_args()

    @throws[TException]
    override def getResult(iface: com.isuwang.dapeng.demo.service.OrderService, args: getServiceMetadata_args): getServiceMetadata_result = {

      val source = scala.io.Source.fromInputStream(OrderServiceCodec.getClass.getClassLoader.getResourceAsStream("com.isuwang.dapeng.demo.service.OrderService.xml"))

      val success = source.mkString
      source.close

      getServiceMetadata_result(success)
    }
  }

  case class getServiceMetadata_args()

  case class getServiceMetadata_result(success: String)

  class GetServiceMetadata_argsSerializer extends TScalaBeanSerializer[getServiceMetadata_args] {

    @throws[TException]
    override def read(iprot: TProtocol): getServiceMetadata_args = {

      iprot.readStructBegin

      var schemeField: com.isuwang.org.apache.thrift.protocol.TField = null

      while (schemeField == null || schemeField.`type` != com.isuwang.org.apache.thrift.protocol.TType.STOP) {
        schemeField = iprot.readFieldBegin
        com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.`type`)
        iprot.readFieldEnd
      }

      iprot.readStructEnd

      val bean = getServiceMetadata_args()
      validate(bean)

      bean
    }

    @throws[TException]
    override def write(bean: getServiceMetadata_args, oproto: TProtocol): Unit = {
      validate(bean)
      oproto.writeStructBegin(new com.isuwang.org.apache.thrift.protocol.TStruct("getServiceMetadata_args"))

      oproto.writeFieldStop
      oproto.writeStructEnd
    }

    @throws[TException]
    override def validate(bean: getServiceMetadata_args): Unit = {}

    override def toString(bean: getServiceMetadata_args): String = if (bean == null) "null" else bean.toString
  }


  class GetServiceMetadata_resultSerializer extends TScalaBeanSerializer[getServiceMetadata_result] {
    @throws[TException]
    override def read(iproto: TProtocol): getServiceMetadata_result = {
      iproto.readStructBegin

      var schemeField: com.isuwang.org.apache.thrift.protocol.TField = null

      var success: String = null

      while (schemeField == null || schemeField.`type` != com.isuwang.org.apache.thrift.protocol.TType.STOP) {
        schemeField = iproto.readFieldBegin

        schemeField.id match {
          case 0 =>
            schemeField.`type` match {
              case com.isuwang.org.apache.thrift.protocol.TType.STRING => success = iproto.readString
              case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
            }
          case _ => com.isuwang.org.apache.thrift.protocol.TProtocolUtil.skip(iproto, schemeField.`type`)
        }
        iproto.readFieldEnd
      }

      iproto.readStructEnd
      val bean = getServiceMetadata_result(success)
      validate(bean)

      bean
    }

    @throws[TException]
    override def write(bean: getServiceMetadata_result, oproto: TProtocol): Unit = {
      validate(bean)
      oproto.writeStructBegin(new com.isuwang.org.apache.thrift.protocol.TStruct("getServiceMetadata_result"))

      oproto.writeFieldBegin(new com.isuwang.org.apache.thrift.protocol.TField("success", com.isuwang.org.apache.thrift.protocol.TType.STRING, 0.asInstanceOf[Short]))
      oproto.writeString(bean.success)
      oproto.writeFieldEnd

      oproto.writeFieldStop
      oproto.writeStructEnd
    }

    @throws[TException]
    override def validate(bean: getServiceMetadata_result): Unit = {
      if (bean.success == null)
        throw new SoaException(SoaBaseCode.NotNull, "success字段不允许为空")
    }

    override def toString(bean: getServiceMetadata_result): String = if (bean == null) "null" else bean.toString

  }

  class Processor(iface: OrderService) extends SoaScalaBaseProcessor(iface, Processor.getProcessMap)

  object Processor {

    type PF = SoaProcessFunction[OrderService, _, _, _ <: TScalaBeanSerializer[_], _ <: TScalaBeanSerializer[_]]

    def getProcessMap(): java.util.Map[String, PF] = {
      val map = new java.util.HashMap[String, PF]()
      map.put("findOrder", new findOrder)
      map.put("getServiceMetadata", new getServiceMetadata)
      map
    }
  }

}

