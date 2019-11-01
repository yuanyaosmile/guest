# guest

Guest 是一个简版的访客预约管理系统，访客直接在页面填写相关信息，进行提交。后台会将相关的访客信息发送邮件给相关的被访人以及需要通知的相关人员。管理员可以在管理界面查看访客信息，设置发送的邮箱等等。

### 环境搭建

- 使用mysql 8数据库
- jdk 8
- maven 3
- intellij IDEA 2019.2
- angular JS
- angular JS material

### 架构总览

- 后端

  基于Spring Boot 2.2，使用Spring + Spring MVC + Mybatis框架，项目中还使用了lombook来简化开发，也使用了t k.mybatis来减少sql语句的编写。

- 前端

  使用Angular JS与Angular JS Material进行开发，实现前后端分离。（但是这里没有分开部署，所以跨域问题在这里不涉及）

### 说明

- 访客页面的访问路径：http://localhost:10086/index.html
- 管理员的访问地址：http://localhost:10086/manager.html
- 系统管理员不是通过系统注册的，是直接在数据库中添加到manager表的。
- 必须先保证manager表中有数据，才可以进行邮箱的设置。
- 如果没有邮箱设置，那么系统无法发送邮件，这里还没有做处理。
- 目前都是基于用户不会胡乱输入信息，因此没有做信息校验，这个在后续慢慢补齐（挖坑不断）



