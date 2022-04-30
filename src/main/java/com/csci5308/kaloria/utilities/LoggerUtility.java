package com.csci5308.kaloria.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

	private LoggerUtility() {
	}

	public static Logger getLoggerInstance(Class<?> className) {
		return LogManager.getLogger(className);
	}
}
