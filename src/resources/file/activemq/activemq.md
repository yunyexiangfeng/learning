# ActiveMQ

###介绍

基于JMS(Java Message Service)的消息中间件，对比RabbitMQ(ali),kafa(apache)

1.支持多种语言编写客户端

2.易于支持Spring

3.支持多种传输协议

​	TCP,SSL,NIO,UDP等

4.支持AJAX



###JMS属性

Destination

Productor

Consumer

Broker：消息转发器

Model：P2P, Pub/Sub

​	P2P--消息队列(Queue)，发送者(Sender)，接收者(Receiver)

​	Pub/Sub--主题(Topic)，发布者(Publisher)，订阅者(Subscriber)



###消息形式

topic：非安全，没有状态，一对多，数据容易丢失（不保存消息），传输速率高

queue：安全，有状态，一对一，数据不容易丢失（保存消息），传输速率低，分为同步/异步两种方式



###架构图

![activemq架构图](./images/activemq架构图.png)







