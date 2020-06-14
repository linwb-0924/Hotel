## 前言

因为最近比较空闲，因为无聊所以把很早之前的一个又jsp+serlvet开发的酒店管理系统重新编写成基于Springboot框架开发，界面设计美化。

## 源码地址

github：[https://github.com/linwb-0924](https://github.com/linwb-0924)
（上面还有作者开发的其他的项目源码）

## 技术栈
- Springboot框架
- 前端页面采用thymeleaf模板引擎，bootstrap+semantic框架
- mail邮件发送
- cahce数据缓存
- rabbitmq消息中间件
- Mybatis
- mysql
- ======================================

## 项目启动
因为这是很久之前开发的系统，数据库并没有重新编写，故源码中无sql文件运行，如要运行还得自己创建数据库及数据表。
- 数据库
数据库名：hotel
customer表
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613200814993.png)
employee表
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613200833727.png)
room表
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613200853358.png)
information表
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613200919396.png)
- 修改配置文件

修改数据库连接用户名和密码
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613200958597.png)
修改rabbitmq相关配置

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613201101907.png)
修改邮箱发送的相关配置（邮箱需开启smtp服务）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613201137573.png)
以上修改完成即可运行。
## 功能演示
- 登录页面国际化
- ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613201441246.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
- ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613201456865.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
- 注册发送邮件验证码（填写的邮件需开启smtp）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613201556878.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613201616808.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613201642309.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
- 与注册相关的密码加密
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613201856540.png)
- 登录拦截（这就不演示了）
- 注销
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613201947607.png)

- 实名认证（主要是姓名和照片）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613202045431.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
-  实名认证完个人信息显示

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613202132239.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
- CRUD：包括分页展示，搜索查询（用chche实现数据缓存），新增（用rabbitmq消息队列监听）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613202345557.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613202407565.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613202422878.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613202441582.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)

## 总结
该系统并未对功能实现更加具体的完善，也是对springboot框架的应用，整体架构较简单，springboot小白完全适合读懂，初学springboot框架的推荐观看源码。

