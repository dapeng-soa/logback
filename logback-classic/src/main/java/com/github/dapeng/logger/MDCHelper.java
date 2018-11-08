package com.github.dapeng.logger;

import ch.qos.logback.classic.Level;

/**
 * Logger context for Dynamic change the logger level
 *
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-10-22 2:10 PM
 */
public class MDCHelper {
    public static final String THREAD_LEVEL_KEY = "thread-log-level";

    private static final String OFF = "OFF";
    private static final String ERROR = "ERROR";
    private static final String WARN = "WARN";
    private static final String INFO = "INFO";
    private static final String DEBUG = "DEBUG";
    private static final String TRACE = "TRACE";
    private static final String ALL = "ALL";

    public static Level getLevel(String level) {
        if (level == null) {
            return null;
        }
        switch (level) {
            case INFO:
                return Level.INFO;
            case DEBUG:
                return Level.DEBUG;
            case OFF:
                return Level.OFF;
            case ERROR:
                return Level.ERROR;
            case WARN:
                return Level.WARN;
            case TRACE:
                return Level.TRACE;
            case ALL:
                return Level.ALL;
            default:
                return null;
        }
    }
}
