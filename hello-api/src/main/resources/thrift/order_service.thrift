namespace java com.isuwang.dapeng.demo.service
include "order_domain.thrift"

/**
* 订单服务
**/
service OrderService{

     /**
### 查找订单
#### 业务描述
      查找订单

#### 接口依赖
      无

#### 边界异常说明
     1. 无

#### 输入
     1. order_domain.FindOrderRequest

#### 前置检查

#### 权限检查

#### 逻辑处理


#### 数据库变更
     无

#### 事务处理

#### 输出
        list<order_domain.Order>
    */
    list<order_domain.Order> findOrder(order_domain.FindOrderRequest request),
}
