package cn.java.money.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/*
 * 目前市面上最主流的日志门面就是SLF4J，虽然Log4j2也是日志门面，因为它的日志实现功能非常强
 * 大，性能优越。所以大家一般还是将Log4j2看作是日志的实现，Slf4j + Log4j2应该是未来的大势所趋。
 *
 *  log4j2默认加载classpath下的 log4j2.xml 文件中的配置。
 */
public class Log4j2Test {

    public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);

    @Test
    public void testQuick() {
        LOGGER.fatal("fatal");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info"); //默认是INFO
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }

}
