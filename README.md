## isuwang-soa的使用示例

1. java版本的，参考`com.isuwang.soa.hello.HelloServiceImpl`

2. scala版本的，参考`com.isuwang.dapeng.demo.order.OrderServiceImpl`

3. 客户端测试： `OrderServiceTest`

4. 本地启动：`mvn compile com.isuwang:dapeng-maven-plugin:1.1.0:run -Dsoa.transactional.enable=false`
    启动成功后打开[http://localhost:8080/index.htm](htto://localhost:8080/index.htm) 可以查看文档站点和在线测试