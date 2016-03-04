1, 导入为maven工程
2，导入sql:src/main/resources/sql/
3，修改jdbc连接:src/main/resources/application.properties
4，修改mybatis-generate(mybatis配置生成插件)配置文件:src/main/resources/mybatis-generator.xml, 这两项:
    <classPathEntry
            location="mysql驱动jar路径" />
    <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/test" userId="root"
                        password="密码"/>
                        
开发或打包大概流程： 
用maven package命令，会自动调用mybatis-generate自动生成mybatis映射配置、实体对象，dao接口， 快速生成增删改查， 然后基于生成的代码编写更复杂的逻辑
