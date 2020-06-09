**注：最简单的mybatis项目，不包括spring整合**  
本例包含以下几种使用情形:   
（1） User/UserMapper :一对一简单的表查询、一级缓存、二级缓存；   
（2） Students/Teacher/StudentMapper : 多对一查询；  
（3） Student2/Teacher2/StudentMapper2: 一对多查询；  
（4） Blog/BlogMappaer： 动态sql的使用(if  choose/when  foreach)。  

# Mybatis使用过程：
(1) 由SqlSessionFactoryBuild生成 SqlSessionFactory对象(全局、单例)；  
(2) 由SqlSessionFactory对象生成SqlSession对象（sqlSession对象操作基本的sql）；  
(3) SqlSession对象获取实际的Mapper接口，执行Mapper接口中由xxxMapper.xml实现的各种方法。  

# 配置项内容：
#### mybatis-config.xml
(1) properties标签代表其中有些properity可以在mybatis-config.xml以外的配置文件说明；  
(2) typeAlias 标签配置类型别名，在xxxMapper.xml中可以简化类型写法；  
(3) environments 下可以有多个environment，比如开发环境、测试环境等，并可在environments中表明默认的环境。  

# mybatis缓存：
    缓存就是内存中的一块，可避免多次重复读取数据库相同的数据。
    如果两次查询相同、条件也一样，且两次查询中间没有任何insert/update/delete操作，则mybatis自动使用缓存。
### 一级缓存：
    （1）一级缓存默认开启；
    （2）一级缓存作用域是一个sqlSession范围内，当sqlSession关闭后，则一级缓存消失。
### 二级缓存:
    （1）二级缓存默认是关闭的；
    （2）开启方法: mybatis-config.xml的settings标签的配置项cacheEnabled设置为true；
    （3）二级缓存作用域是 *Mapper.xml中的标注的namespace，一个namespace一个二级缓存；
    （4）注意需要实现操作POJO对象的序列化，否则可能报错。