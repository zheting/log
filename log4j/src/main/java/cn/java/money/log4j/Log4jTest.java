package cn.java.money.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.jupiter.api.Test;

public class Log4jTest {

    @Test
    public void testQuick() {
        //开启log4j内置的日志记录,可以查看log4j自身代码中的日志
        //LogLog.setInternalDebugging(true);

        /*
            如果没有以下初始化配置，出现如下错误；
            log4j:WARN No appenders could be found for logger (cn.java.money.log4j.Log4jTest).
            log4j:WARN Please initialize the log4j system properly.
         */
        // 初始化系统配置，不需要配置文件
        //BasicConfigurator.configure(); // 这里使用代码方式配置 log4j.prorerties
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

        // 测试按照大小分隔
        /*for (int i = 0; i < 100000; i++) {
            logger.info("寒蝉凄切，对长亭晚，骤雨初歇。都门帐饮无绪，留恋处，兰舟催发。执手相看泪眼，竟无语凝噎。念去去，千里烟波，暮霭沉沉楚天阔。多情自古伤离别，更那堪，冷落清秋节！今宵酒醒何处？杨柳岸，晓风残月。此去经年，应是良辰好景虚设。便纵有千种风情，更与何人说？");
        }*/
    }

    @Test
    public void testCustomLogger() {
        // 自定义 com.itheima
        Logger logger1 = Logger.getLogger(Log4jTest.class);
        logger1.fatal("fatal");
        logger1.error("error");
        logger1.warn("warn");
        logger1.info("info");
        logger1.debug("debug");
        logger1.trace("trace");

        // 自定义 org.apache
        Logger logger2 = Logger.getLogger(Logger.class);
        logger2.fatal("fatal logger2");
        logger2.error("error logger2");
        logger2.warn("warn logger2");
        logger2.info("info logger2");
        logger2.debug("debug logger2");
        logger2.trace("trace logger2");
    }

}
