package cn.java.money.slf4jlog4j2;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *  slf4j 和 log4j2 组合使用
 */
public class Slf4jLog4j2 {

    /*
     *  看似使用的slf4j的api 实际是log4j2输出日志
     */
    public final static Logger LOGGER = LoggerFactory.getLogger(Slf4jLog4j2.class);

    @Test
    public void test(){
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
