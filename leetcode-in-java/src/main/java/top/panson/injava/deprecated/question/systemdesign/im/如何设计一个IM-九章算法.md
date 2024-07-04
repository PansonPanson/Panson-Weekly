系统设计面试题：如何设计一个即时消息系统？

忙里偷闲，整理了本篇笔记。本文是笔者学习某课的学习笔记总结，侧重于面试八股。
IM 系统是一个非常复杂的系统，受笔者的能力所限，未能囊括所有的业务内容和技术难点。
~抛转引玉~
————————————以下是万字（虚假的~）笔记————————————


如何设计一个即时消息系统？与之类似的题型诸如：
1. 如何设计一个微信
2. 如何设计一个 QQ
3. 如何设计一个 WhatsApp

————————————分析功能/需求 ————————————

我们拿到题目之后如何去分析：首先和面试官沟通，询问核心功能与非核心功能。

一个 IM 系统的核心功能应该包括：
1. 用户登录与注册
2. 通讯录
3. 单聊
4. 群聊

核心功能上，本文只单聊和群聊这两个核心功能。

非核心功能：
1. 限制 or 支持多机登录
2. 显示用户在线状态

————————————分析业务数据量——————————————

其次是询问支持的用户数，以微信2019年的公开数据来举例：
10.8亿月活跃用户，日发送量 450 亿，仅计算消息通信，可得平均QPS 为 45B / 86400，约为 52万，峰值 QPS 约为 150 万，假设每条消息为 30 bytes 的话，大概需要 1.3T 的存储。


————————————分析架构设计和服务拆分————————————
聊完业务功能，我们再来聊服务拆分，IM 系统最起码要包括两个服务：
1. Message Service ： 负责信息相关的存取
2. Realtime Service ： 负责信息的实时推送


————————————分析Message Service ————————————
先看第一个Message Service 的设计。

设计一个简单的Message 表结构:

id：bigint  主键id
from_user_id：bigint  消息发送者（谁发的）
to_user_id: bigint  消息到达者（发给谁）
content: text 消息内容
created_at: datetime 创建时间

如果按照上面的 Message Table，那么要查询 A 与 B 之间的对话，则需要如下的语句：
SELECT * FROM message_table
WHERE from_user_id=A and to_user_id=B
OR from_user_id=B and to_user_id=A
ORDER BY created_at DESC;

当然这种简单粗暴的 SQL会有许多问题，比如：
1：WHERE 语句复杂，导致SQL效率低下
2：如果是多人聊天群，这种结构不可扩展

如何优化？
拆分为两张表：
1. Thread Table ： 通俗的解释就是会话表，比如说张三与李四两个人的聊天会话。
2. Message Table

Thread Table 表设计：

id：bigint 主键id
participant_user_ids：text 比如【1,2】表示 1 和 2 之间的对话
created_at： datetime 创建时间
updated_at：datetime

Message Table 表设计：

id：bigint 主键id
thread_id：bigint 会话id
user_id：bigint 消息发送者（谁发的）
content: text 消息内容
created_at: datetime 创建时间


那么同样的，对于这样的表设计，面试官可能会为：
1. 如何获取某个 Thread 下的所有的 Message?
2. 这样设计的 Thread Table 会有什么问题？

先回答第一个问题：
SELECT * FROM message_table WHERE thread_id=12345 ORDER BY created_at DESC

再回答第二个问题：
这样设计的表没办法存储一些个人私有的会话信息，比如说 is_muted（是否被静音），unread_count（未读信息数）。

那我们如何进一步优化这个表结构呢？我们可以将 Thread  Table 再做一次拆分。
表1： Thread - 存储基本信息
表2：UserThread - 存储 User 在 Thread 上的私有信息

表1： Thread 表设计

id：bigint 主键id
last_message：text 最后一条消息
avatar: varchar 头像
created_at：datetime 创建时间


表2：User Thread Table 表设计
id：bigint 主键 id
user_id：bigint 用户id
thread_id： bigint 会话id
unread_count：int 未读消息数
is_muted：boolean
updated_at：
joint_at：

————————————分析 Storage Service ————————————
关于IM 消息信息，一个典型的特点就是消息数据量很大，但不需要修改，一条聊天信息就像一条日志一样。
一般我们都会选择 NoSQL 来做存储。
以常用的查询维度为会话级别，我们可以设计两张表：Thread Table 与 ParticipantHashCode Table，其中设计 ParticipantHashCode Table 旨在解决thread_id 的索引问题，当用户 A 给用户 B 发消息的时候，可能并不知道他们之间的thread_id 是什么，如何在服务器上查询。

表1：Thread Table
row_key = thread_id
column_key = null
value = 其他的基本信息

表2：ParticipantHashCode Table
row_key = participant_hash_code
column_key = null
value = thread_id

更详细的架构与设计模型可以参考之前的帖子：https://t.zsxq.com/0cYVGoBUv


————————————小结————————————

回答到这里的时候，我们已经得到了一个闭环的系统设计（至少能用~）。
1. 用户 A 发送一条消息给 用户 B
2. 服务器收到消息，查询是否有 A 和 B 的对话记录（Thread），如果没有则创建对应的 Thread
3. 根据 Thread id 创建 Message
4. B 每隔 10s 访问一次服务器获取最新的信息（Poll）
5. B 收到信息

接下来该如何优化？面试官此时可能会考察一些系统扩展的问题？
比如说：

问：每隔10秒钟收一次消息太慢了，聊天体验很差，不实时。

答： 可以借助手机自己的消息推送系统 ，比如说 Android GCM (Google Cloud Messaging)、iOS APNS (Apple Push Notification Service)
这时候流程变为：
1. A 发送消息到 Web Server
2. Web Server 创建信息存入数据库之后通知 APNS
3. APNS 告诉 B 有新消息了
4. B 去 Web Server 抓取下新的消息（可选）
5. 如果消息比较短的话，也可以直接通过 APNS 传递
6. 无需 B 再次访问 Web Server 获取

问：这种方式有什么问题？
答：无法支持 Web 端， GCM / APNS 都是依赖于手机操作系统的，无法支持 Web 端或者桌面端的信息推送

问：怎么解决？
答：Socket 网络编程，让服务器可以主动向客户端推送数据

这时候流程变为：
1. 用户A打开App后，问 Web Server 要一个 Push Service 的连接地址
2. A通过 socket 与push server保持连接
3. 用户B发消息给A，消息先被发送到服务器
4. 服务器把消息存储之后，告诉 Push Server 让他通知 A
5. A 收到及时的消息提醒


问：似乎还有群聊的场景没聊到，群聊有什么需要注意的地方？
假如一个群有500人
• 如果不做任何优化，需要给这 500 人一个个发消息
• 但实际上 500 人里只有很少的一些人在线（比如10人）
• 但Message Service仍然会尝试给他们发消息
• Message Service (web server) 无法知道用户和Push Server的socket连接是否已经断开
• 至于 Push Server 自己才知道
• 消息到了Push Server 才发现490个人根本没连上
• Message Service 与 Push Server 之间白浪费490次消息传递

答：
• 增加一个Channel Service（频道服务）
• 为每个聊天的Thread增加一个Channel信息
• 对于较大群，在线用户先需要订阅到对应的 Channel 上
• 用户上线时，Web Server (message service) 找到用户所属的频道（群），并通知 Channel Service 完成订阅
• Channel就知道哪些频道里有哪些用户还活着
• 用户如果断线了，Push Service 会知道用户掉线了，通知 Channel Service 从所属的频道里移除
• Message Service 收到用户发的信息之后
• 找到对应的channel
• 把发消息的请求发送给 Channel Service
• 原来发500条消息变成发1条消息
• Channel Service 找到当前在线的用户
• 然后发给 Push Service 把消息 Push 出去

问：你觉得还有什么需要补充的业务点吗？
答：多机登录、在线or离线状态显示、消息的推（push）拉(pull)模式

————————————设计要点总结————————————
1. 能够设计出 Message, Thread, UserThread 这几个最主要的数据库表单
2. 能够使用 NoSQL 存储以上数据表单
3. 能够设计基于 Socket 技术的 Realtime Service （或者叫 Push Service)
4. 能够针对群聊通过订阅 Channel 的模式优化群聊的 Push
5. 其他通用的业务场景，如多机登录、在线or离线状态显示、消息的推（push）拉(pull)模式