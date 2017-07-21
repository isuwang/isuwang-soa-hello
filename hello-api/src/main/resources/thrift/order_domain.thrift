namespace java com.isuwang.dapeng.demo.domain

include "order_enum.thrift"


/**
* 订单信息
**/
struct Order {
    /**订单id*/
    1: i32 id,
    /**订单号*/
    2: string orderNo,
    /**支付方式*/
    3: order_enum.PayTypeEnum payType,
    /**买家id*/
    4: i32 buyerId,
    /**卖家id*/
    5: i32 sellerId,
    /**成交价格*
    *  @datatype(name="bigdecimal")
    **/
    6: double price,
    /**备注信息*/
    7: optional string remark,
}

/**
* 查找订单请求
**/
struct FindOrderRequest{
    /**支付方式*/
    1: order_enum.PayTypeEnum payType = order_enum.PayTypeEnum.AliPay,
    /**买家id*/
    2: i32 buyerId,
}
