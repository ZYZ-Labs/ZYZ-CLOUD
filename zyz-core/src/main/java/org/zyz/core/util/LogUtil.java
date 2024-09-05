package org.zyz.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类，封装日志记录逻辑。
 */
public class LogUtil {

    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    /**
     * 记录调试级别日志。
     *
     * @param message 日志信息
     */
    public static void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    /**
     * 记录信息级别日志。
     *
     * @param message 日志信息
     */
    public static void info(String message) {
        logger.info(message);
    }

    /**
     * 记录错误级别日志。
     *
     * @param message 日志信息
     * @param e       异常对象
     */
    public static void error(String message, Throwable e) {
        logger.error(message, e);
    }
}
