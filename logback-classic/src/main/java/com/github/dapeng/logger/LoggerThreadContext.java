package com.github.dapeng.logger;

import ch.qos.logback.classic.Level;

/**
 * Logger context for Dynamic change the logger level
 *
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-10-22 2:10 PM
 */
public class LoggerThreadContext {

    private static final String OFF = "OFF";
    private static final String ERROR = "ERROR";
    private static final String WARN = "WARN";
    private static final String INFO = "INFO";
    private static final String DEBUG = "DEBUG";
    private static final String TRACE = "TRACE";
    private static final String ALL = "ALL";

    private Level level;

    public void setLevel(String level) {
        switch (level) {
            case INFO:
                this.level = Level.INFO;
                break;
            case DEBUG:
                this.level = Level.DEBUG;
                break;
            case OFF:
                this.level = Level.OFF;
                break;
            case ERROR:
                this.level = Level.ERROR;
                break;
            case WARN:
                this.level = Level.WARN;
                break;
            case TRACE:
                this.level = Level.TRACE;
                break;
            case ALL:
                this.level = Level.ALL;
                break;
            default:
                this.level = Level.OFF;
        }
    }

    public Level getLevel() {
        return level;
    }

    public static class Factory {
        private static ThreadLocal<LoggerThreadContext> threadLocal = new ThreadLocal<LoggerThreadContext>();


        /**
         * must be invoked one time per thread before work begin
         *
         * @return
         */
        public static LoggerThreadContext createNewInstance() {
            assert threadLocal.get() == null;

            LoggerThreadContext context = new LoggerThreadContext();

            threadLocal.set(context);
            return context;
        }

        public static LoggerThreadContext currentInstance() {
            LoggerThreadContext context = threadLocal.get();

            //客户端可能不手动创建上下文.
            if (context == null) {
                context = createNewInstance();
            }
            return context;
        }

        public static LoggerThreadContext currentInstance(LoggerThreadContext context) {
            threadLocal.set(context);
            return context;
        }

        /**
         * must be invoked after work done
         */
        public static void removeCurrentInstance() {
            threadLocal.remove();
        }
    }

}
