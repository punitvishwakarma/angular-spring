/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.angular.util;

/**
 *
 * @author Punit
 */


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jExample {

	static{
		init();
	}
	
	private final static Logger logger = Logger.getLogger(Log4jExample.class);
	
	public static void main(String[] args) {

		logger.debug("My Debug Log");
		logger.info("My Info Log");
		logger.warn("My Warn Log");
		logger.error("My error log");
		logger.fatal("My fatal log");
		
	}

	/**
	 * method to init log4j configurations
	 */
	private static void init() {
		DOMConfigurator.configure("log4j.xml");
	}

}

