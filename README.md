# log
## 官网url
* JUL: JDK
* JCL: http://commons.apache.org/proper/commons-logging/
* slf4j: http://www.slf4j.org/manual.html
* logback: https://logback.qos.ch/
* log4j2: http://logging.apache.org/log4j/2.x/index.html

## 日志门面
* JCL
* SLF4J
* Log4j2
 
## 具体实现
#### JUL (java.util.logging)
JDK1.4 以后增加的日志记录功能。
```
import java.util.logging.*;

Logger logger = Logger.getLogger(JULTest.class.getName());
```

#### log4j

```
import org.apache.log4j.Logger;

Logger logger = Logger.getLogger(Log4jTest.class);
```

### JCL  Java commons logging
JCL 本身一个API, 并提供了一个简单实现。 
```
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

Log log = LogFactory.getLog(JCLTest.class);
```
多个日志实现的加载顺序，首先加载的就是log4j（有一个问题，如果新增实现JCL 不能动态加载）
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

#### slf4j-simple
slf4j-simple 是slf4j官方提供一个实现。
````
 <dependency>
     <groupId>org.slf4j</groupId>
     <artifactId>slf4j-simple</artifactId>
 </dependency>
````
```
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final static Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);
```

#### logback 
logback 遵循的是 slf4j接口规范。因此coding层面和slf4j的使用时一模一样的。
```
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final static Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);
```

#### log4j2
log4j2单独使用。
log4j2 本身就提供了API，其实也可以作为一个门面。
```
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);
```

slf4j 和 log4j2 一起使用需要提供适配层来遵循的是 slf4j接口规范。因此coding层面和slf4j的使用时一模一样的。



 







