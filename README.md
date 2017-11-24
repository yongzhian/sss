# sss(h)

##### Demo页面

<img src="https://github.com/yongzhian/sss/blob/master/docs/demo0.png"/>
<img src="https://github.com/yongzhian/sss/blob/master/docs/demo1.png"/>
<img src="https://github.com/yongzhian/sss/blob/master/docs/demo2.png"/>

##### 流程说明

通过ContextLoaderListener启动Spring。
Spring通过DispatcherServlet启动Servlet进行HTTP请求处理。
添加pringDataJpa在于自动封装部分DAO实现，不再需要手动书写DaoImpl，Dao继承JpaRepository接口即可（或注解）。

##### 功能说明

1. 基于Gradle进行项目构建
1. 基于dbcp2连接池（test中cn.zain.jpa包下）
1. 基于原生的JPA测试（test中cn.zain.jpa包下）
1. 基于原生Spring+JPA测试（test中cn.zain.jpa包下）
1. druid作为连接池
1. 基于JPA的事务管理
1. 基于SpringDataJpa简化Dao（JpaRepository接口，自动实现部分数据库查询方法）
1. 基于Spring Tx方式注解进行事务控制


##### 版本说明

Spring5.0.1.RELEASE+SpringDataJPA2.0.1.RELEASE+Hibernate5.2.12.Final