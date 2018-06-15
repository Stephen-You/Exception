package cn.exception180610.log;
/**
 * 
 * @author �������h
 * 2018��6��14��
 * @core ���쳣д�뵽��־
 */

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException extends Exception{

	private static Logger logger = Logger.getLogger("LoggingException");

	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
		// TODO Auto-generated constructor stub
	}
}
