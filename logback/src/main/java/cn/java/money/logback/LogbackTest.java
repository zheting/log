package cn.java.money.logback;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  logback 实现的就是slf4j的api
 */
public class LogbackTest {

    //定义日志对象
    public final static Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void testSlf4j() {
        //打印日志信息
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug"); // 默认是debug级别的日志输出
        LOGGER.trace("trace");
    }
}
