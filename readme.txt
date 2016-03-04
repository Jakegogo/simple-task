1, 导入为maven工程
2，导入sql:src/main/resources/sql/
3，修改jdbc连接:src/main/resources/application.properties
4，修改mybatis-generate(mybatis配置生成插件)配置文件:src/main/resources/mybatis-generator.xml, 这两项:
    <classPathEntry
            location="C:\Users\Jake\.m2\repository\mysql\mysql-connector-java\5.1.17\mysql-connector-java-5.1.17.jar" />
    <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/test" userId="root"
                        password="123456"/>
                        
