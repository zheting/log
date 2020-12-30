 ## Log4j组件
Log4J 主要由 Loggers (日志记录器)、Appenders（输出端）和 Layout（日志格式化器）组成。
* Loggers 控制日志的输出级别与日志是否输出；
* Appenders 指定日志的输出方式（输出到控制台、文件等）；
* Layout 控制日志信息的输出格式。

###  Loggers
日志记录器，负责收集处理日志记录，实例的命名就是类“XX”的full quailied name（类的全限定名），   
**Logger的名字大小写敏感，其命名有继承机制**：  
例如：name为org.apache.commons的logger会继承name为org.apache的logger。

Log4J中有一个特殊的logger叫做“root”，他是所有logger的根，也就意味着其他所有的logger都会直接
或者间接地继承自root。   
root logger可以用Logger.getRootLogger()方法获取。

### Appenders

Appender 用来指定日志的输出目的地。Log4j 常用的输出目的地
有以下几种：

![appenders](images/appenders.png "appenders.png")