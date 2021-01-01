package cn.java.money.slf4j;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  slf4j 只是一个日志门面，只提供了API, 必须提供一个具体的实现才可以输入日志
 *
 *  slf4j-simple 就是其中一个实现
 */
public class Slf4jTest {

    public final static Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

    @Test
    public void testQuick() {
        //打印日志信息
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
        // 使用占位符输出日志信息
        String name = "jack";
        Integer age = 18;
        LOGGER.info("用户：{},{}", name, age);

        // 将系统异常信息写入日志
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // e.printStackTrace();
            LOGGER.info("出现异常：", e);
        }
    }
}
