package com.bydan.framework.erp.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class FuncionesEjb {
	public static void manageException(Logger logger,Exception e) throws Exception {
		try {
			
			logger.info("Exception:" + e.getMessage());			
			logger.error("Exception:" + e.getMessage());
			
			StringWriter  stringWriter=new StringWriter();
			
			e.printStackTrace(new PrintWriter(stringWriter));
						
			logger.error("Exception:" + stringWriter.toString());
			
		} catch(Exception exc) {
			throw exc;
		}
	}
}
