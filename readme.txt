springboot相当于一个CI，持续集成

可以集成我们的mybatis、redis、mongodb、freemarker、servlet、Filter、DataSource

yml
datasource
      url
	  username
	  password








@Component
AbstractRoutingDataSource


springboot shiro


1、profile区分环境
application.properties
application-dev.properties
application-product.properties
Spring Boot 会先加载默认的配置文件，然后使用具体指定的profile中的配置去覆盖默认配置。
在启动程序的时候通过添加 –spring.profiles.active={profile} 来指定具体使用的配置 
java -jar demo.jar –spring.profiles.active=dev


module 权限表
select\update\insert\delete

role  角色
admin1\admin2

module_role 关系表
admin1 -- select\insert
admin2 -- select\update\insert\delete

user --用户
jack/jeff

user_role  用户和角色相关的表
jack 1
jeff 2


springboot 打jar
mvn clean
mvn package -Dmaven.test.skip=true

进入到target找对应的jar包
java -jar xxxx.jar

打成jar包注意
1、xml文件静态文件必须要打入到jar中
2、webapp下面的东西也需要打入到jar包中


