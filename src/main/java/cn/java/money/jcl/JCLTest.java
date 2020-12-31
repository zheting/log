package cn.java.money.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

public class JCLTest {

    @Test
    public void testQuick()  {
        // 创建日志对象
        Log log = LogFactory.getLog(JCLTest.class);
        // 日志记录输出
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
    }
}
