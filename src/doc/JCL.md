## JCL
全称为Java Commons Logging，是Apache提供的一个通用日志API。  

它是为 "所有的Java日志实现"提供一个统一的接口，它自身也提供一个日志的实现，但是功能非常常弱
（SimpleLog）。所以一般不会单独使用它。他允许开发人员使用不同的具体日志实现工具: Log4j, Jdk
自带的日志（JUL)

JCL 有两个基本的抽象类：Log(基本记录器)和LogFactory(负责创建Log实例)。

## 我们为什么要使用日志门面：
1. 面向接口开发，不再依赖具体的实现类。减少代码的耦合   
2. 项目通过导入不同的日志实现类，可以灵活的切换日志框架  
3. 统一API，方便开发者学习和使用  
4. 统一配置便于项目日志的管理  

## 源码
接口 Log   
 * Jdk14Logger(java1.4的日志实现)java.util.logging.Logger.getLogger();   
 * Log4JLogger  
 * SimpleLog  

抽象类 LogFactory  
* LogFactoryImpl


多个日志实现的加载顺序（有一个问题，如果新增实现JCL 不能动态加载）
```
private static final String LOGGING_IMPL_LOG4J_LOGGER = "org.apache.commons.logging.impl.Log4JLogger";

private static final String[] classesToDiscover = {
            LOGGING_IMPL_LOG4J_LOGGER,
            "org.apache.commons.logging.impl.Jdk14Logger",
            "org.apache.commons.logging.impl.Jdk13LumberjackLogger",
            "org.apache.commons.logging.impl.SimpleLog"
    };

for(int i=0; i<classesToDiscover.length && result == null; ++i) {
            result = createLogFromClass(classesToDiscover[i], logCategory, true);
        }
``` 
 