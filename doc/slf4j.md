## 为什么要使用SLF4J作为日志门面？
1. 使用SLF4J框架，可以在部署时迁移到所需的日志记录框架。 
2. SLF4J提供了对所有流行的日志框架的绑定，例如log4j，JUL，Simple logging和NOP。因此可以 在部署时切换到任何这些流行的框架。 
3. 无论使用哪种绑定，SLF4J都支持参数化日志记录消息。由于SLF4J将应用程序和日志记录框架分离， 因此可以轻松编写独立于日志记录框架的应用程序。而无需担心用于编写应用程序的日志记录框架。 
4. SLF4J提供了一个简单的Java工具，称为迁移器。使用此工具，可以迁移现有项目，这些项目使用日志 框架(如Jakarta Commons Logging(JCL)或log4j或Java.util.logging(JUL))到SLF4J。

##SLF4J的绑定
一类是直接是实现了SLF4J的 如 logback, slf4j-simple, slf4j-nop

另一类没有实现SLF4J的 如: JCL log4j  就需要一个适配层


