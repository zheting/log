package cn.java.money.jul;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.logging.*;

public class JULTest {

    @Test
    public void testQuick() {
        // 1.创建日志记录器对象
        Logger logger = Logger.getLogger(JULTest.class.getName());
        // 2.日志记录输出
        logger.info("hello JUL");
        logger.log(Level.INFO, "info msg");
        String name = "jack";
        Integer age = 18;
        logger.log(Level.INFO, "用户信息：{0},{1}", new Object[]{name, age});
    }

    /*
     * 日志级别
     */
    @Test
    public void testLogLevel() {
        // 1.获取日志对象
        Logger logger = Logger.getLogger(JULTest.class.getName());
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        //默认日志输出级别INFO
        logger.info("info");
        logger.config("cofnig");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /*
     * 通过代码配置 logger
     */
    @Test
    public void testLogConfig() throws Exception {
        // 1.创建日志记录器对象
        Logger logger = Logger.getLogger(JULTest.class.getName());
        // 一、自定义日志级别
        // a.关闭系统默认配置
        logger.setUseParentHandlers(false);
        // b.创建handler对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // c.创建formatter对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // d.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        // e.设置日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        // 二、输出到日志文件
        FileHandler fileHandler = new FileHandler("d:/logs/jul.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testLogParent() {
        // 日志记录器对象父子关系
        Logger logger1 = Logger.getLogger("cn.java.money.jul");
        Logger logger2 = Logger.getLogger("cn.java.money");
        /*
         *  从路径上看出logger2是logger1的parent。
         *  logger2以上没有定义Logger,那么就是顶级Logger RootLogger
         *  就会继承父Logger的设置
         */
        System.out.println(logger1.getParent() == logger2);
        // 所有日志记录器对象的顶级父元素 class为java.util.logging.LogManager$RootLogger name为""
        System.out.println("logger2 parent:" + logger2.getParent() + "，name：" + logger2.getParent().getName());


        //******************** 配置开始  这些配置会放在配置文件logging.properties*****************************
        // 一、自定义日志级别
        // a.关闭系统默认配置
        logger2.setUseParentHandlers(false);
        // b.创建handler对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // c.创建formatter对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // d.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);
        // e.设置日志级别
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        //************************ 配置结束 ************************

        // 测试日志记录器对象父子关系。 由于修改了logger2的配置，而logger1是logger2的子logger,因此会把所有级别的日志答应出来
        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");
    }

    /*
     * java.util.logging.LogManager.readConfiguration() 读取默认的配置文件
     * 默认配置文件路径$JAVAHOME\jre\lib\logging.properties
     * C:\Program Files\Java\jdk1.8.0_221\jre\lib\logging.properties
     */
    @Test
    public void testProperties() throws Exception {
        // 读取自定义配置文件
        InputStream in = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        // 获取日志管理器对象
        LogManager logManager = LogManager.getLogManager();
        // 通过日志管理器加载配置文件
        logManager.readConfiguration(in);

        // 在logging.properties中自定义了  cn.java.money， 所有子包都会应用该配置
        Logger logger = Logger.getLogger("cn.java.money.jul");
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Logger logger2 = Logger.getLogger("cn.java");
        logger2.severe("severe test");
        logger2.warning("warning test");
        logger2.info("info test");
        logger2.config("config test");
        logger2.fine("fine test");
        logger2.finer("finer test");
        logger2.finest("finest test");
    }
}
