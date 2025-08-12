# 整体说明
    spring cloud 2.7.12 + nacos + mysql
# 修改配置
# 数据库初始化
# 配置中心初始化
   sh nacos-config.sh -h 127.0.0.1 -p 8848 -g SEATA_GROUP -t "50c3be5d-da46-4ae0-893e-1d960bf2b047" -u nacos -w nacos
##  有一个线程创建异常
   修改xss512-640
# 启动/停止
   sh bin/seata-server.sh
   sh bin/seata-server.sh stop
# 验证seata
   http://localhost:7091
    密码在seata配置文件中配置
# 服务配置
   7.1 需要@GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
   7.2 需要配置seata
   7.3 需要fegin 调用
   7.4 进行服务配置，重点是的fegin的xid传递代理（需要进行代理）
   FeignConfig 代理 SeataFeignInterceptor
   7.5 注册seata
   register TM success.
   register RM success.


#  结果验证
## 库存创建 减少订单钱 验证订单回滚
http://127.0.0.1:8081/stock/save

## 订单创建 减少库存 验证库存回滚
http://127.0.0.1:8081/stock/save