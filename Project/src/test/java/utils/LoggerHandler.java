package utils;

import org.apache.log4j.Logger;

public class LoggerHandler {

    static Logger logger = Logger.getLogger(LoggerHandler.class);

    public static void info(String msg) {

        logger.info(msg);
    }

    public static void error(String msg) {

        logger.error(msg);
    }

    public static void trace(String msg) {

        logger.trace(msg);
    }

    public static void fatal(String msg) {

        logger.fatal(msg);
    }

    public static void warn(String msg) {

        logger.warn(msg);
    }

}
