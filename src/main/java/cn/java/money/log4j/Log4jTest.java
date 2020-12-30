package cn.java.money.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class Log4jTest {

    @Test
    public void testQuick() {
        /*
            如果没有以下初始化配置，出现如下错误；
            log4j:WARN No appenders could be found for logger (cn.java.money.log4j.Log4jTest).
            log4j:WARN Please initialize the log4j system properly.
         */
        // 初始化系统配置，不需要配置文件
        BasicConfigurator.configure(); // 这里使用代码方式配置
        // 创建日志记录器对象
        Logger logger = Logger.getLogger(Log4jTest.class);
        // 日志记录输出
        logger.info("hello log4j");
        //日志级别
        logger.fatal("fatal"); // 严重错误，一般会造成系统崩溃和终止运行
        logger.error("error");// 错误信息，但不会影响系统运行
        logger.warn("warn"); // 警告信息，可能会发生问题
        logger.info("info"); // 程序运行信息，数据库的连接、网络、IO操作等
        // log4j 默认日志级别debug
        logger.debug("debug"); // 调试信息，一般在开发阶段使用，记录程序的变量、参 数等
        logger.trace("trace");   // 追踪信息，记录程序的所有流程信息
    }
}
