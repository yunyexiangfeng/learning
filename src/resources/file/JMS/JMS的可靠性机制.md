#JMS的可靠性机制



##一、消息接收确认

JMS消息只有在被确认之后，才认为已经被成功地消费了。消息的成功消费通常包含三个阶段

- 客户接收消息
- 客户处理消息
- 消息被确认



在事务性会话中，当一个事务被提交的时候，确认自动发生

```java
final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
....
session.commit();
```

在非事务性会话中，消息何时被确认取决于创建会话时的应答（签收）模式（acknowledgement mode）。

通俗点说，就是消费者接受到消息后，需要告诉消息服务器，我收到消息了。当消息服务器收到回执后，本条消息将失效。因此签收将对PTP模式产生很大影响。

该参数有以下三个可选值：

- Session.AUTO_ACKNOWLEDGE：

  当客户成功的从receive方法返回的时候，或者从MessageListener.onMessage方法成功返回的时候，会话自动确认客户收到的消息

  也就是说调用receive()方法时自动签收消息

  ```java
  final Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
  ...
  MapMessage message = (MapMessage) consumer.receive();
  ```

  

- Session.CLIENT_ACKNOWLEDGE：

  客户通过调用消息的acknowledge方法确认消息（确认签收）

  ```java
  MapMessage message = (MapMessage) consumer.receive();
  message.acknowledge();
  ```

  需要注意的是，在这种模式中，确认是在会话层上进行，确认一个被消费的消息将自动确认所有已被会话消费的消息。

  例如，如果一个消息消费者消费了10个消息，然后确认第5个消息，那么所有10个消息都被确认。

  

- Session.DUPS_OK_ACKNOWLEDGE：

  签不签收无所谓，只要消费者能够容忍重复的消息接受

  如果JMSprovider失败，那么可能会导致一些重复的消息。

  如果是重复的消息，那么JMSprovider必须把消息头的JMSRedelivered字段设置为true



##二、消息持久性与消息优先级

### 消息持久性

JMS支持以下两种消息提交模式：

- PERSISTENT：指示JMS provider持久保存消息，以保证消息不会因为JMSprovider的失败而丢失

- NON_PERSISTENT：不要求JMS provider持久保存消息



###消息优先级

可以使用消息优先级来指示JMS provider首先提交紧急的消息。

优先级分10个级别，从0（最低）到9（最高）。如果不指定优先级，默认级别是4。

需要注意的是，JMS provider并不一定保证按照优先级的顺序提交消息



##三、消息过期与消息的临时目的地



### 消息过期

可以设置消息在一定时间后过期，默认是永不过期。

### 消息的临时目的地

可以通过会话上的createTemporaryQueue方法和createTemporaryTopic方法来创建临时目的地。它们的存在时间只限于创建它们的连接所保持的时间。

只有创建该临时目的地的连接上的消息消费者才能够从临时目的地中提取消息



##四、持久订阅



生产者必须使用PERSISTENT提交消息。

客户可以通过会话上的createDurableSubscriber方法来创建一个持久订阅，该方法的第一个参数必须是一个topic。第二个参数是订阅的名称。



JMS provider会存储发布到持久订阅对应的topic上的消息。如果最初创建持久订阅的客户或者任何其它客户，使用相同的连接工厂和连接的客户ID，

相同的主题和相同的订阅名，再次调用会话上的createDurableSubscriber方法，那么该持久订阅就会被激活。JMS provider会向客户发送客户处于非激活

状态时所发布的消息。

持久订阅在某个时刻只能有一个激活的订阅者。持久订阅在创建之后会一直保留，直到应用程序调用会话上的unsubscribe方法。



##五、本地事务



在一个JMS客户端，可以使用本地事务来组合消息的发送和接收。JMSSession接口提供了commit和rollback方法。

事务提交意味着生产的所有消息被发送，消费的所有消息被确认；

事务回滚意味着生产的所有消息被销毁，消费的所有消息被恢复并重新提交，除非它们已经过期。



事务性的会话总是牵涉到事务处理中，commit或rollback方法一旦被调用，一个事务就结束了，而另一个事务被开始。关闭事务性会话将回滚其中的事务。



注意：

 1、如果使用请求/回复机制，即发送一个消息，同时希望在同一个事务中等待接收该消息的回复，那么程序将被挂起，因为知道事务提交，发送操作才会真正执行。

 2、消息的生产和消费不能包含在同一个事务中。