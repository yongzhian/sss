# sss(h)

##### Demo页面

<img src="https://github.com/yongzhian/s1sh/blob/master/doc/login.png"/>

<img src="https://github.com/yongzhian/s1sh/blob/master/doc/index.png"/>

##### 流程说明

通过ContextLoaderListener启动Spring。
基于StrutsPrepareAndExecuteFilter进行分流，配置文件struts.xml。（FilterDispatcher是struts2.0.x到2.1.2版本的核心过滤器. StrutsPrepareAndExecuteFilter是自2.1.3开始就替代了FilterDispatcher）


##### 功能说明

1. 基于Gradle进行项目构建
1. 采用HibernateDaoSupport操作，只能在配置文件中注入
1. 使用TemplateDaoImpl，子类无须分别注入HibernateTemplate
1. struts中SysUser使用配置，SysNode和SysNode使用注解
1. 基于Log4j2，并写日志到文件中
1. hibernate使用ehcache作为二级缓存
1. hibernate中SysUser使用配置，SysNode和SysNode使用注解
1. hibernate使用默认的配置参数
1. druid作为连接池
1. 添加jstl的list遍历

##### 版本说明

struts2与spring不整合相互之间也能工作，但是整合之后可以将struts2中的对象交给spring容器管理， 否则struts2中的对象属性因为不在容器中而无法管理，不能自动注入从而导致空指针等常见异常。
struts2.5.13+spring4.3.2.RELEASE+hibernate5.2.12.Final