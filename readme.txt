springboot�൱��һ��CI����������

���Լ������ǵ�mybatis��redis��mongodb��freemarker��servlet��Filter��DataSource

yml
datasource
      url
	  username
	  password








@Component
AbstractRoutingDataSource


springboot shiro


1��profile���ֻ���
application.properties
application-dev.properties
application-product.properties
Spring Boot ���ȼ���Ĭ�ϵ������ļ���Ȼ��ʹ�þ���ָ����profile�е�����ȥ����Ĭ�����á�
�����������ʱ��ͨ����� �Cspring.profiles.active={profile} ��ָ������ʹ�õ����� 
java -jar demo.jar �Cspring.profiles.active=dev


module Ȩ�ޱ�
select\update\insert\delete

role  ��ɫ
admin1\admin2

module_role ��ϵ��
admin1 -- select\insert
admin2 -- select\update\insert\delete

user --�û�
jack/jeff

user_role  �û��ͽ�ɫ��صı�
jack 1
jeff 2


springboot ��jar
mvn clean
mvn package -Dmaven.test.skip=true

���뵽target�Ҷ�Ӧ��jar��
java -jar xxxx.jar

���jar��ע��
1��xml�ļ���̬�ļ�����Ҫ���뵽jar��
2��webapp����Ķ���Ҳ��Ҫ���뵽jar����


