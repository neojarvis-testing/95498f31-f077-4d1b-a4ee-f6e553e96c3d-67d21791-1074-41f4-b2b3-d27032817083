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

    
}